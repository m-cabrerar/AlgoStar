package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class casosDeUso3 {
    /*Verificar que solo Asimilador y extractor se puedan construir sobre el gas.*/

    @Test
    public void test01ConstruyoUnAsimiladorSobreElGas(){
        //ARRANGE
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Asimilador asimilador = Asimilador.construir(casillero,banco);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test02ConstruirUnAsimiladorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un asimilador en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Asimilador asimilador = Asimilador.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test03ConstruyoUnExtractorSobreElGas(){
        //ARRANGE
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Extractor extractor = Extractor.construir(casillero,banco);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04ConstruirUnExtractorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un extractor en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = Extractor.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test05ConstruirUnCriaderoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un criadero en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = Criadero.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test06ConstruirUnPilonSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un pilon en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Pilon pilon = Pilon.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test07ConstruirUnNexoMineralSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un nexo mineral en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            NexoMineral nexo = NexoMineral.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test08ConstruirUnAccesoSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un acceso en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = Acceso.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test09ConstruirUnPuertoEstelarSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un puerto estelar en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puerto = PuertoEstelar.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test10ConstruirUnReservaDeProduccionSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir una reserva de produccion en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeProduccion reserva = ReservaDeProduccion.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test11ConstruirUnaGuaridaSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir una guarida en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida guarida = Guarida.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test12ConstruirUnEspiralSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir una espiral en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(99,99);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral espiral = Espiral.construir(casillero,banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
