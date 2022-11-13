package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuaridaTests {

    @Test
    public void test01ConstruyoUnaGuaridaQueEstaraListoEn12Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300,300);
        Edificio guarida = new Guarida(casillero, inventario);

        //ACT
        for(int i=0; i<12; i++){
            guarida.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(guarida.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnaGuaridaQueNoSePuedeUsarPasados11Turnos() {

        //ARRANGE
        String mensaje = "Tu Guarida ha sido destruida";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300,300);
        Edificio guarida = new Guarida(casillero, inventario);

        //ACT
        for(int i=0; i<11; i++){
            guarida.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            guarida.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03NoSePuedeConstruirUnaGuaridaSinTenerUnaReservaDeReproduccion(){
        //ARRANGE
        String mensaje = "Aun no puedes construir una guarida";
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio guarida = new Guarida(casillero, inventario);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04SePuedeConstruirUnaGuaridaSiTengoUnaReservaDeReproduccion(){
        //ARRANGE
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        //ACT

        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);

        //ASSERT
        assertDoesNotThrow(Edificio guarida = new Guarida(casillero, inventario) );
    }

}
