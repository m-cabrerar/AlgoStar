package edu.fiuba.algo3.modelo;

public class EstaDestruido extends Exception {
    public EstaDestruido(String el_edificio_esta_destruido) {
        super(el_edificio_esta_destruido);
    }
}
