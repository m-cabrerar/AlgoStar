package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import java.util.Collection;

public class casosDeUso6 {
    /*Verificar el crecimiento del moho acorde a lo estipulado.*/
    @Test
    public void test01PasaElTurnoYCreceElMoho(){
        /*Como el test prueba la propagacion de moho yo diria que esto
        * es mas para chequear que tan bien anda el mapa, pq seria mas
        * correcto q el mapa se fije si se propagó*/

        //Arrange
        x = ;
        y= ;
        Mapa tablero = new Mapa(DimensionX,DimensionY);
        Casilla casillaMoho = new Moho ();
        tablero.agregarCasilla(x,y,casillaMoho);

        Collection casillasAdyacentes = casillaMoho.adyacentes(); //Todo uso collection provisoriamente
        //Esto por ahi haya q pregutarselo al tablero. 

        //Act
        tablero.pasarTurno();
        //Assert

        for (Casilla casilla : casillasAdyacentes) {
            assertEquals(casilla.getClass(), Moho.class);
        }
    }
}
