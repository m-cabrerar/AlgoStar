/*
package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso5 {
    */
/* Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del
     *moho.
     *//*

    //Todo pasar a Mock el inventario que siempre pueda pagar.


    */
/*
    *//*
*/
/*********************Edificios Que Necesitan Moho**************************//*
*/
/*
    *//*
*/
/* INTENTO CONSTRUIR SOBRE NODO MINERAL Y NO SE PUEDE. *//*
*/
/*
    @Test
    public void test01ConstruyoUnCriaderoEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Criadero en este casillero";
        Casillero casillero = new NodoMineral();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test02ConstruyoUnaReservaDeReproduccionEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Reserva de Reproduccion en este casillero";
        Casillero casillero = new NodoMineral();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeReproduccion reserva = new ReservaDeReproduccion (casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test03ConstruyoUnExtractorEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Extractor en este casillero";
        Casillero casillero = new NodoMineral();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test04ConstruyoUnCriaderoEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Guarida en este casillero";
        Casillero casillero = new NodoMineral();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida guarida = new Guarida(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test05ConstruyoUnCriaderoEnUnNodoMineralYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Espiral en este casillero";
        Casillero casillero = new NodoMineral();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral espiral = new Espiral(casillero, inventario);
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
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Criadero criadero = new Criadero(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test07ConstruyoUnaReservaDeReproduccionEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Reserva de Reproduccion en este casillero";
        Casillero casillero = new NodoGas();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            ReservaDeReproduccion reserva = new ReservaDeReproduccion (casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test08ConstruyoUnExtractorEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir un Extractor en este casillero";
        Casillero casillero = new NodoGas();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test09ConstruyoUnCriaderoEnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Guarida en este casillero";
        Casillero casillero = new NodoGas();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Guarida guarida = new Guarida(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test10ConstruyoUnCriaderoEnUnUnNodoDeGasYDaError(){
        //ARRANGE
        String mensaje = "No se puede construir una Espiral en este casillero";
        Casillero casillero = new NodoGas();
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Espiral espiral = new Espiral(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
*//*

}
*/
