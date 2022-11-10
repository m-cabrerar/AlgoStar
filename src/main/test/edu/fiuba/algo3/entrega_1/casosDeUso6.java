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
        Mapa mapa = new Mapa(DimensionX,DimensionY);

        tablero.agregarCasilla(x,y,casillaMoho);

        Collection casillasAdyacentes = mapa.adyacentes(x,y); //Todo uso collection provisoriamente
        //Esto por ahi haya q pregutarselo al tablero. 

        //Act
        tablero.pasarTurno();
        //Assert

        for (Casilla casilla : casillasAdyacentes) {
            assertEquals(casilla.getClass(), Moho.class);
        }
    }
}
