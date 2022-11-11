package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Criadero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class casosDeUso1 {
    /*Criadero se inicia con 3 larvas, se consume una para engendrar un zángano, le quedan 2 y
     *después de 1 turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar
     *que se regeneren acorde a los tiempos estipulados.
     */

    @Test
    public void test01ConsumoLaLarvaDeUnCriaderoParaEngendrarZanganoYCuandoPasaElTurnoTengo3OtraVez() {
        
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Criadero criadero = new Criadero();

        //ACT
        criadero.engendrarZangano();
        criadero.pasarTurno();

        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
 
    }

    @Test
    public void test02Consumo2LarvasDeUnCriaderoParaEngendrarZanganosYCuandoPasan2TurnosTengo3OtraVez() {
        
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Criadero criadero = Criadero.inicializar();

        //ACT
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.pasarTurno();
        criadero.pasarTurno();

        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
 
    }

    @Test
    public void test03Consumo3LarvasDeUnCriaderoParaEngendrarZanganosYCuandoPasan3TurnosTengo3OtraVez() {
        
        //ARRANGE
        String mensaje = "Ya no quedan larvas disponibles";
        Criadero criadero = Criadero.inicializar();

        //ACT
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        Exception exception = assertThrows(Exception.class, () -> {
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
            criadero.engendrarZangano();
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
 
    }    
    
}
