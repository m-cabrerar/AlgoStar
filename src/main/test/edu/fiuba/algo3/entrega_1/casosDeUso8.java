package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso8 {
    /*Verificar que si no se tienen los recursos no se pueden construir los edificios (Para cada
     *edificio para cada raza).
     */

    //TODO CAMBIAR CASILLERO POR UN MOCK DEL MISMO ASI ME ASEGURO Q NO SALTA POR REGLA PILONES.
    //TODO Cambiar banco por mock que siempre diga q no se puede
    //TODO tambien cambiar casillero de Zerg por mock

    //**************************PROTOSS ********************************
    @Test
    public void test01NoPuedoConstruirUnAsimiladorSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un asimilador";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Asimilador asimilador = new Asimilador(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test02NoPuedoConstruirUnNexoMineralSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Nexo Mineral";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            NexoMineral nexoMineral = new NexoMineral(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test03NoPuedoConstruirUnPilonSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Pilon";
        Casillero casillero = new NodoMoho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Pilon pilon = new Pilon(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04NoPuedoConstruirUnAccesoSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Acceso";
        Casillero casillero = new Moho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = new Acceso(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test05NoPuedoConstruirUnPuertoEstelarSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un PuertoEstelar";
        Casillero casillero = new Moho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    //************************** ZERG ********************************
    @Test
    public void test06NoPuedoConstruirUnCriaderoSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Criadero";
        Casillero casillero = new Moho(); //Cambiar a mock
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test07NoPuedoConstruirUnaReservaDeReproduccionSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir una Reserva de Reproduccion";
        Casillero casillero = new Moho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeReproduccion reserva = new ReservaDeReproduccion(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test08NoPuedoConstruirUnExtractorSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Extractor";
        Casillero casillero = new Moho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test09NoPuedoConstruirUnaGuaridaSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir una guarida";
        Casillero casillero = new Moho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida guarida = new Guarida(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test09NoPuedoConstruirUnaEspiralSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir";
        Casillero casillero = new Moho();
        Banco banco = new Banco(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral espiral = new Espiral(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
