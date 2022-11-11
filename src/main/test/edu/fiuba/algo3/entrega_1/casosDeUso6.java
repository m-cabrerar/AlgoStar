package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import java.util.Collection;

public class casosDeUso6 {
    /*Verificar el crecimiento del moho acorde a lo estipulado.*/
    @Test
    public void test01PasaElTurnoYCreceElMoho(){

        //Arrange
        x = ;
        y= ;
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(200,200);
        Mapa mapa = new Mapa(DimensionX,DimensionY);
        tablero.agregarCasilla(x,y,casillaMoho);
        Collection casillasAdyacentes = mapa.adyacentes(x,y); //Todo uso collection provisoriamente

        //Act
        tablero.pasarTurno();
        for (Casilla casilla : casillasAdyacentes) {
            new Criadero(casillero, inventario)
        }
        //Assert

        for (Casilla casilla : casillasAdyacentes) {
            assertTrue(casilla.estaOcupado());
        }
    }
}
