package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.ParametrosInvalidos;
import edu.fiuba.algo3.exceptions.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int cantidadGas;
    private int cantidadMineral;
    List<Unidad> unidades;
    //List<Unidad> edificios;

    private static int POBLACION_MAXIMA =200;
    private static int SUMINISTROS_MAXIMOS = 200;
    private int suministrosDisponibles;
    int suministrosEmpleados;

    public Inventario(){
        this.cantidadGas = 0;
        this.cantidadMineral = 200;
        this.suministrosDisponibles = 0;
        this.suministrosEmpleados = 0;
        this.unidades = new ArrayList<>();
    }
    public void agregarGas(int i) {
        this.cantidadGas += i;
    }
    public void agregarMineral(int i) {
        this.cantidadMineral += i;
    }
    public void agregar(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public void agregarSuministro(int cantidad){
        this.suministrosDisponibles += cantidad;
        if(this.suministrosDisponibles > SUMINISTROS_MAXIMOS){this.suministrosDisponibles = 200;}
    }
    public void perderSuministro(int cantidad){
        this.suministrosDisponibles -= cantidad;
    }
    public boolean tieneSuministros(int cantidad){
        return this.suministrosDisponibles >= cantidad;
    }
    public boolean puedeCrecerPoblacion(int cantidad){
        return (this.suministrosEmpleados+cantidad) <= POBLACION_MAXIMA;
    }
    public void suministrarUnidad(int cantidad) throws PoblacionMaximaAlcanzada {
        if (tieneSuministros(cantidad) && puedeCrecerPoblacion(cantidad)){ //Puedo pagarlo y tengo capacidad de poblacion
            this.suministrosEmpleados += cantidad;
            perderSuministro(cantidad);
        }
    }

    public boolean tieneRecursos(int cantidadGas, int cantMineral) {
        return ((this.cantidadMineral >= cantMineral) && (this.cantidadGas >= cantidadGas));
    }
    public void pagarMateriales(int cantidadGas, int cantidadMineral){
        if(!this.tieneRecursos(cantidadMineral,cantidadGas)){
            throw new RecursosInsuficientes("Recursos insuficientes");
        }
        this.cantidadMineral -= cantidadMineral;
        this.cantidadGas -= cantidadGas;
    }
    //TODO: evitar instanceof

    public boolean tieneGuarida() {
        for (Unidad unidad : this.unidades) {
            if (unidad instanceof Guarida) {
                return true;
            }
        }
        return false;
    }

    public boolean tieneReservaDeReproduccion() {
        for (Unidad unidad : this.unidades) {
            if (unidad instanceof ReservaDeReproduccion) {
                return true;
            }
        }
        return false;
    }

    public boolean tieneAcceso() {
        for (Unidad unidad : this.unidades) {
            if (unidad instanceof Acceso) {
                return true;
            }
        }
        return false;
    }


    public boolean tieneEdificios(){
        return !(unidades.isEmpty());
        //cuando esten separados los edificios se manda a edificios
    }
    public void pasarTurno(){
        for(Unidad unidad :unidades){
            unidad.pasarTurno();
        }
    }
    public List<AmoSupremo> obtenerAmosSupremos(){
        List<AmoSupremo> amosSupremos = new ArrayList<>();
        for (Unidad unidad : this.unidades) {
            if (unidad instanceof AmoSupremo) {
                amosSupremos.add((AmoSupremo) unidad);
            }
        }
        return amosSupremos;
    }
}


    /*int cantidadGas;
    int cantidadMineral;


    public Inventario(int cantidadInicialGas, int cantidadInicialMineral){
        this.cantidadGas = cantidadInicialGas;
        this.cantidadMineral = cantidadInicialMineral;
    }

    private boolean puedePagar(int pagoDeMineral, int pagoDeGas){
        if((this.cantidadMineral < pagoDeMineral) || (this.cantidadGas < pagoDeGas)){
            return false;
        }
        return true;
    }
    public void pagar(int pagoDeGas, int pagoDeMineral) throws Exception {
        if (!this.puedePagar(pagoDeGas, pagoDeMineral)) {
            throw new Exception("Materiales insuficientes");
        }
        this.cantidadGas -= pagoDeGas;
        this.cantidadMineral -= pagoDeMineral;
    }
    public void recibirMineral(int cantidad){
        this.cantidadMineral += cantidad;
    }
    public void recibirGas(int cantidad){
        this.cantidadGas += cantidad;
    }*/