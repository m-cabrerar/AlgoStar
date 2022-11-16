package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Criadero extends EdificioZerg{
    private int cantidadLarvas;
    private static int VIDA_MAXIMA = 500;
    private int cantidadZanganos;
    public Criadero(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA_MAXIMA);
        this.cantidadLarvas = 3;
        this.cantidadZanganos = 0;
    }
    public void pasarTurno() {
        if(vida<VIDA_MAXIMA){
            regenerarVida();
        }
        if(!estaEnCapacidadMaxima()) {
            this.cantidadLarvas += 1;
        }
    }
    int turnosParaConstruir() {
        return 4;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!casillero.esDelTipo(new Moho())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(50, 0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        EdificioConcreto criadero = new Criadero(casillero, inventario);
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



}
