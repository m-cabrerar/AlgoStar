package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccesoTests {

    @Test
    public void test01ConstruyoUnAccesoQueEstaraListoEn8Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio acceso = new Acceso(casillero, inventario);

        //ACT
        for(int i=0; i<8; i++){
            acceso.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(acceso.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnAccesoQueNoSePuedeUsarPasados7Turnos() {

        //ARRANGE
        String mensaje = "Tu Acceso ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio acceso = new Acceso(casillero, inventario);

        //ACT
        for(int i=0; i<7; i++){
            acceso.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            acceso.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
