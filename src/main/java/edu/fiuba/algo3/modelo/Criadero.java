package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Criadero extends EdificioZerg{
    private int cantidadLarvas;
    private static int VIDA_MAXIMA = 500;
    private int cantidadZanganos;
    private static int SUMINISTRA = 5;
    
    public Criadero(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA_MAXIMA);
        this.cantidadLarvas = 3;
        this.cantidadZanganos = 0;
        inventario.agregarSuministro(SUMINISTRA);
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(0);
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
}
