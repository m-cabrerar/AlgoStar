package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso5 {
    /* Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del
     *moho.
     */
    //Todo pasar a Mock el banco que siempre pueda pagar.

    @Test
    public void test01NoSePuedeConstruirUnAccesoFueraDelRangoDelPilon(){
        //ARRANGE
        String mensaje = "No se puede construir en este tipo de casillero";
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(false);
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = new Acceso(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test02NoSePuedeConstruirUnPuertoEstelarFueraDelRangoDelPilon(){
        //ARRANGE
        String mensaje = "No se puede construir en este tipo de casillero";
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(false);
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test03SePuedeConstruirUnAccesoDentroDelRangoDelPilon(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        //ACT
        Acceso acceso = new Acceso(casillero, banco);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04SePuedeConstruirUnPuertoEstelarDentroDelRangoDelPilon(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        //ACT
        PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, banco);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }
    /*
    *//*********************Edificios Que Necesitan Moho**************************//*
    *//* INTENTO CONSTRUIR SOBRE NODO MINERAL Y NO SE PUEDE. *//*
    @Test
    public void test01ConstruyoUnCriaderoEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Criadero en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test02ConstruyoUnaReservaDeReproduccionEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Reserva de Reproduccion en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeReproduccion reserva = new ReservaDeReproduccion (casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test03ConstruyoUnExtractorEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Extractor en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test04ConstruyoUnCriaderoEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Guarida en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida guarida = new Guarida(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test05ConstruyoUnCriaderoEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Espiral en este casillero";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral espiral = new Espiral(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    //INTENTO CONSTRUIR SOBRE UN NODO DE GAS Y NO SE PUEDE
    @Test
    public void test06ConstruyoUnCriaderoEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Criadero en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test07ConstruyoUnaReservaDeReproduccionEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Reserva de Reproduccion en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeReproduccion reserva = new ReservaDeReproduccion (casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test08ConstruyoUnExtractorEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Extractor en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test09ConstruyoUnCriaderoEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Guarida en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida guarida = new Guarida(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test10ConstruyoUnCriaderoEnUnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Espiral en este casillero";
        Casillero casillero = new NodoGas();
        Banco banco = new Banco(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral espiral = new Espiral(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
*/
}
