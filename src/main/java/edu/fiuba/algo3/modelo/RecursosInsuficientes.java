package edu.fiuba.algo3.modelo;

public class RecursosInsuficientes extends Exception {
    public RecursosInsuficientes(String no_tiene_recursos) {
        super(no_tiene_recursos);
    }
}
