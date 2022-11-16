package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso8 {
    /*Verificar que si no se tienen los recursos no se pueden construir los edificios (Para cada
     *edificio para cada raza).
     */

    //TODO CAMBIAR CASILLERO POR UN MOCK DEL MISMO ASI ME ASEGURO Q NO SALTA POR REGLA PILONES.
    //TODO Cambiar inventario por mock que siempre diga q no se puede
    //TODO tambien cambiar casillero de Zerg por mock

    //**************************PROTOSS ********************************
    @Test
    public void test01NoPuedoConstruirUnAsimiladorSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un asimilador";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Asimilador asimilador = new Asimilador(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test02NoPuedoConstruirUnNexoMineralSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Nexo Mineral";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            NexoMineral nexoMineral = new NexoMineral(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test03NoPuedoConstruirUnPilonSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Pilon";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Pilon pilon = new Pilon(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04NoPuedoConstruirUnAccesoSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un Acceso";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = new Acceso(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
    @Test
    public void test05NoPuedoConstruirUnPuertoEstelarSinLosRecursos(){
        //ARRANGE
        String mensaje = "No se tienen los fondos para construir un PuertoEstelar";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(0,0);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

}
