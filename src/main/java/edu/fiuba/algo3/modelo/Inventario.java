package edu.fiuba.algo3.modelo;

import java.util.List;

public class Inventario {

    int cantidadGas = 0;
    int cantidadMineral =0;
    List<Unidad> unidades;

    public void agregarGas(int i) {
        this.cantidadGas += i;
    }

    public void agregarMineral(int i) {
        this.cantidadMineral += i;
    }
    public void agregar(Unidad unidad) {
        this.unidades.add(unidad);
    }
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

    public void pagar(int pagoDeGas, int pagoDeMineral) throws Exception {
        if (!this.puedePagar(pagoDeGas, pagoDeMineral)) {
            throw new Exception("Materiales insuficientes");
        }
        this.cantidadGas -= pagoDeGas;
        this.cantidadMineral -= pagoDeMineral;
    }

}