package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class casosDeUso1 {
    /*Criadero se inicia con 3 larvas, se consume una para engendrar un zángano, le quedan 2 y
     *después de 1 turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar
     *que se regeneren acorde a los tiempos estipulados.
     */

    @Test
    public void test01ConsumoLaLarvaDeUnCriaderoParaEngendrarZanganoYCuandoPasaElTurnoTengo3OtraVez() {
        
        //ARRANGE
        Criadero criadero = Criadero.inicializar();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        //ACT
        criadero.engendrarZangano();
        
        //ASSERT
        criadero.pasarTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();

       //falta chequear que no lance error o no se que 
    }

    
}
