package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CriaderoTests {
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

    @Test
    public void test04ConstruyoUnCriaderoQueEstaraListoEn4Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(100,100);
        Edificio criadero = new Criadero(casillero, inventario);

        //ACT
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        //ASSERT
        assertDoesNotThrow(criadero.recibirDanio(5));

    }

    @Test
    public void test05ConstruyoUnCriaderoQueNoSePuedeUsarPasados3Turnos() {

        //ARRANGE
        String mensaje = "Tu Criadero ha sido destruido";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(100,100);
        Edificio criadero = new Criadero(casillero, inventario);

        //ACT
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test06ConstruirUnCriaderoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un criadero en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    
}
