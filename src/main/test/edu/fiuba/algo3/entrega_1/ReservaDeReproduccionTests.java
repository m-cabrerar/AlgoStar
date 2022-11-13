package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReservaDeReproduccionTests {

    @Test
    public void test01ConstruyoUnaRerservaDeReproduccionQueEstaraListoEn12Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300,300);
        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);

        //ACT
        for(int i=0; i<12; i++){
            reserva.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(reserva.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnaReservaDeReproduccionQueNoSePuedeUsarPasados11Turnos() {

        //ARRANGE
        String mensaje = "Tu Reserva de Produccion ha sido destruido";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300,300);
        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);

        //ACT
        for(int i=0; i<11; i++){
            reserva.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            reserva.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }
}
