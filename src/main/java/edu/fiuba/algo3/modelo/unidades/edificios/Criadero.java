package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.casillero.Moho;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.moviles.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Collection;
import java.util.List;

public class Criadero extends EdificioZerg{

    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 200;
    private int cantidadLarvas;
    private static int VIDA_MAXIMA = 500;
    private static int SUMINISTRA = 5;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    private List<UnidadEnEvolucion> unidadesEnEvolucion;
    
    public Criadero(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA_MAXIMA);
        this.cantidadLarvas = 3;
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO, COSTO_MINERAL);
        inventario.agregarSuministro(SUMINISTRA);
        this.unidadesEnEvolucion = new ArrayList<>();
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
        inventario.agregarSuministro(SUMINISTRA);
    }
    
    public void pasarTurno() {
        super.pasarTurno();
        if(!estaEnCapacidadMaxima()) {
            this.cantidadLarvas += 1;
        }
        if(!unidadesEnEvolucion.isEmpty()){
            List<UnidadEnEvolucion> aEliminar = new ArrayList<>();
            for(UnidadEnEvolucion unidadEnEvolucion : unidadesEnEvolucion){
                unidadEnEvolucion.pasarTurno();
                if(unidadEnEvolucion.estaListo()){
                    aEliminar.add(unidadEnEvolucion);
                }
            }
            for(UnidadEnEvolucion unidadAEliminar: aEliminar){
                unidadesEnEvolucion.remove(unidadAEliminar);
            }

        }
    }
    
    public int turnosParaConstruir() {
        return 4;
    }
    
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes, CorrelativasInsuficientes {
        if(!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Criadero criadero = new Criadero(casillero, inventario);
        System.out.println(casillero.posicionX() + " " + casillero.posicionY());
        Moho moho = new Moho();
        casillero.setTipoCasillero(moho);
        List<Casillero> casillerosAdyacentes = casillero.obtenerAdyacentes();
        List<Casillero> casillerosAdyacentesYAdyacentes = casillero.obtenerAdyacentes();
        System.out.println("Adyacentes" + casillerosAdyacentes.size());
        for (Casillero casilleroAdyacente : casillerosAdyacentes) {
            System.out.println(casilleroAdyacente.posicionX() + " " + casilleroAdyacente.posicionY());
            casillerosAdyacentesYAdyacentes.addAll(casilleroAdyacente.obtenerAdyacentes());
        }
        System.out.println("Adyacentes y adyacentes" + casillerosAdyacentesYAdyacentes.size());
        for (Casillero casilleroAdyacenteYAdyacente : casillerosAdyacentesYAdyacentes) {
            System.out.println(casilleroAdyacenteYAdyacente.posicionX() + " " + casilleroAdyacenteYAdyacente.posicionY());
        }

        moho.expandirMoho(casillerosAdyacentesYAdyacentes);
        return new EdificioEnConstruccion(criadero, casillero, inventario);
    }
    
    private boolean tieneLarvas(){
        return cantidadLarvas > 0;
    }
    
    private boolean estaEnCapacidadMaxima(){
        return cantidadLarvas == 3;
    }

    public void recibirDanio(Danio danio) throws EstaDestruido{
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.inventario.perderSuministro(SUMINISTRA);
            throw new EstaDestruido("Unidad destruida");
        }
    }
    public static int getNivelDeConstruccion(){
        return NIVEL_DE_CONSTRUCCION;
    }

    public void engendrarZangano(){
        if(tieneLarvas()){
            Zangano zangano = new Zangano(inventario);
            this.iniciarEvolucion(zangano);
        } else {
            throw new YaNoQuedanLarvas("No quedan larvas");
        }
    }
    public void engendrarZerling() {
        if (tieneLarvas() && inventario.puedeConstruir(1)) {
            Zerling zerling = new Zerling(inventario);
            this.iniciarEvolucion(zerling);
        } else {
            throw new YaNoQuedanLarvas("No quedan larvas");
        }
    }
    public void engendrarAmoSupremo(){
        if(tieneLarvas()){
            AmoSupremo amo = new AmoSupremo(inventario);
            this.iniciarEvolucion(amo);
        } else {
            throw new YaNoQuedanLarvas("No quedan larvas");
        }
    }
    public void engendrarHidralisco(){
        if(tieneLarvas() && inventario.puedeConstruir(2)){
            Hidralisco hidra = new Hidralisco(inventario);
            this.iniciarEvolucion(hidra);
        } else {
            throw new YaNoQuedanLarvas("No quedan larvas");
        }
    }
    public void engendrarMutalisco(){
        if(tieneLarvas() && inventario.puedeConstruir(3)){
            Mutalisco muta = new Mutalisco(inventario);
            this.iniciarEvolucion(muta);
        } else {
            throw new YaNoQuedanLarvas("No quedan larvas");
        }
    }

    private void iniciarEvolucion(UnidadMovil unidad){
        this.unidadesEnEvolucion.add(new UnidadEnEvolucion(this.casillero, this.inventario, unidad));
        this.cantidadLarvas -= 1;
    }




}
