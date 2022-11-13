package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EspiralTests {

    @Test
    public void test01ConstruyoUnEspiralQueEstaraListoEn10Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300,300);
        Edificio espiral = new Espiral(casillero, inventario);

        //ACT
        for(int i=0; i<10; i++){
            espiral.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(espiral.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnEspiralQueNoSePuedeUsarPasados9Turnos() {

        //ARRANGE
        String mensaje = "Tu Espiral ha sido destruido";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300,300);
        Edificio espiral = new Espiral(casillero, inventario);

        //ACT
        for(int i=0; i<9; i++){
            espiral.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            espiral.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03NoSePuedeConstruirUnEspiralSinTenerUnaGuarida(){
        //ARRANGE
        String mensaje = "Aun no puedes construir un Espiral";
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio espiral = new Espiral(casillero, inventario);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04SePuedeConstruirUnEspiralSiTengoUnaGuarida(){
        //ARRANGE
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        //ACT

        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);
        Edificio guarida = new Guarida(casillero, inventario);

        //ASSERT
        assertDoesNotThrow( Edificio espiral = new Espiral(casillero, inventario));
    }
}
