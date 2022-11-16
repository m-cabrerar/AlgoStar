package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import static org.junit.jupiter.api.Assertions.*;

public class casosDeUso3 {
    /*Verificar que solo Asimilador y extractor se puedan construir sobre el gas.*/







    @Test
    public void test06ConstruirUnPilonSobreElGasLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un pilon en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Pilon pilon = new Pilon(casillero, inventario);
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
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            NexoMineral nexo = new NexoMineral(casillero, inventario);
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
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Acceso acceso = new Acceso(casillero, inventario);
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
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            PuertoEstelar puerto = new PuertoEstelar(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
