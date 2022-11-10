package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class casosDeUso17 {
    /* Verificar las “correlativas” de construcción. */

    @Test
    public void test01NoSePuedeConstruirUnaGuaridaSinTenerUnaReservaDeReproduccion(){
        //ARRANGE
        String mensaje = "Aun no puedes construir una guarida";
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Moho();
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio guarida = new Guarida(casillero, inventario);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test02NoSePuedeConstruirUnEspiralSinTenerUnaGuarida(){
        //ARRANGE
        String mensaje = "Aun no puedes construir un Espiral";
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Moho();
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio espiral = new Espiral(casillero, inventario);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test03SePuedeConstruirUnaGuaridaSiTengoUnaReservaDeReproduccion(){
        //ARRANGE
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Moho(); 
        //ACT
        
        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);

        //ASSERT
        assertDoesNotThrow(Edificio guarida = new Guarida(casillero, inventario) );
    }

    @Test
    public void test04SePuedeConstruirUnEspiralSiTengoUnaGuarida(){
        //ARRANGE
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Moho(); 
        //ACT
        
        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);
        Edificio guarida = new Guarida(casillero, inventario);

        //ASSERT
        assertDoesNotThrow( Edificio espiral = new Espiral(casillero, inventario));
    }

    @Test
    public void test05NoSePuedeConstruirUnPuertoEstelarSinTenerUnAcceso(){
        //ARRANGE
        String mensaje = "Aun no puedes construir un Puerto Estelar";
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero(); //que debera estar en rango de un pilon
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio puerto = new PuertoEstelar(casillero, inventario);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test06SePuedeConstruirUnPuertoEstelarSiTengoUnAcceso(){
        //ARRANGE
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero(); //que debera estar en rango de minimo un pilon
        //ACT
        
        Edificio acceso = new Acceso(casillero, inventario);
        //ASSERT
        assertDoesNotThrow( Edificio puerto = new PuertoEstelar(casillero, inventario));
    }
}
