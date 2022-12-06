package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

public class Criadero extends EdificioZerg{

    private static int COSTO_GASEOSO = 50;
    private static int COSTO_MINERAL = 0;
    private int cantidadLarvas;
    private static int VIDA_MAXIMA = 500;
    private int cantidadZanganos;
    private static int SUMINISTRA = 5;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    
    public Criadero(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA_MAXIMA);
        this.cantidadLarvas = 3;
        this.cantidadZanganos = 0;
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO, COSTO_MINERAL);
        inventario.agregarSuministro(SUMINISTRA);
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
        if(obtenerUnidad()!=null){
            UnidadMovil unidad = obtenerUnidad();
            unidad.ubicarEn(casillero.obtenerAdyacente());
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }
    
    public int turnosParaConstruir() {
        return 4;
    }
    
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        if(!inventario.tieneRecursos(50, 0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Criadero criadero = new Criadero(casillero, inventario);
        return new EdificioEnConstruccion(criadero, casillero, inventario);
    }
    
    public void engendrarZangano() throws Exception {
        if(!this.tieneLarvas()){
            throw new Exception("Ya no quedan larvas disponibles");
        }
        this.cantidadLarvas -= 1;
        this.cantidadZanganos += 1;
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
}
