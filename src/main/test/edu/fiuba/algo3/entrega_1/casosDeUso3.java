package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class casosDeUso3 {
    /*Verificar que solo Asimilador y extractor se puedan construir sobre el gas.*/

    @Test
    public void test01ConstruyoUnAsimiladorSobreElGas(){
        //ARRANGE
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Asimilador asimilador = new Asimilador(casillero, banco);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test02ConstruirUnAsimiladorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un asimilador en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoMineral());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Asimilador asimilador = new Asimilador(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test03ConstruyoUnExtractorSobreElGas(){
        //ARRANGE
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Extractor extractor = new Extractor(casillero, banco);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04ConstruirUnExtractorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un extractor en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoMineral());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test05ConstruirUnCriaderoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un criadero en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test06ConstruirUnPilonSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un pilon en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Pilon pilon = new Pilon(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test07ConstruirUnNexoMineralSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un nexo mineral en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            NexoMineral nexo = new NexoMineral(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test08ConstruirUnAccesoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un acceso en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = new Acceso(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test09ConstruirUnPuertoEstelarSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un puerto estelar en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puerto = new PuertoEstelar(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
