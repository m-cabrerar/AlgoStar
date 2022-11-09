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
        Coordenada coordenadaMoho = new Coordenada (x,y);
        Mapa tablero = new Tablero(DimensionX,DimensionY);
        //poner en el tablero moho en la coordenada correspondiente
        Collection coordenadasAdyacentes = coordenadaMoho.adyacentes() //uso collection pero quizas hay algo mejor

        //Act
        tablero.pasarTurno();
        //Assert

        for (Coordenada coordenada : coordenadasAdyacentes) {
           //Chequear que en esa coordenada de mapa sea un moho
        }
    }
}
