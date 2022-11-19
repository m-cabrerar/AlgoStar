package edu.fiuba.algo3.modelo;

import java.util.List;

public class Inventario {

    int cantidadGas;
    int cantidadMineral;
    List<Unidad> unidades;
    List<NexoMineral> nexos;
    List<Criadero> criaderos;

    private static int POBLACION_MAXIMA =200;
    private int suministros;

    public void agregarGas(int i) {
        this.cantidadGas += i;
    }
    public void agregarMineral() throws Exception {
        for(NexoMineral nexo: this.nexos ){
            cantidadMineral = nexo.extraerMineral(cantidadMineral);
        }
        for(Criadero criadero:this.criaderos){ //si no tiene criadero no hará nada
            cantidadGas = criadero.enviarZanganoExtraerMineral(cantidadMineral);
        }

    }

    public void agregarNexo(NexoMineral unNexoMineral){
        this.nexos.add(unNexoMineral);
    }

    public void agregar(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public void agregarSuministro(int cantidad){
        this.suministros += cantidad;
    }
    public boolean tieneSuministros(int costoSuministro){
        return this.suministros>=costoSuministro;
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

    public boolean tieneRecursos(int cantMineral, int cantGas) {
        return (this.cantidadMineral >= cantMineral) && (this.cantidadGas >= cantGas);
    }

    public boolean tieneAcceso() {
        for (Unidad unidad : this.unidades) {
            if (unidad instanceof Acceso) {
                return true;
            }
        }
        return false;
    }
}



    /*
    public void pagar(int pagoDeGas, int pagoDeMineral) throws Exception {
        if (!this.puedePagar(pagoDeGas, pagoDeMineral)) {
            throw new Exception("Materiales insuficientes");
        }
        this.cantidadGas -= pagoDeGas;
        this.cantidadMineral -= pagoDeMineral;
    }
*/