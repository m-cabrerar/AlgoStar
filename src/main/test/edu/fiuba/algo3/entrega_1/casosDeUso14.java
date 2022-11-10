package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class casosDeUso14 {
    /*- Un pilón no puede energizar en un área ya cubierta por moho (Es decir las construcciones
     * protoss no se pueden hacer sobre moho, por más que estén dentro del alcance de un
     * pilón).
     *- El moho se puede expandir por un área no ocupada (es decir que no tenga un edificio ya
     * construido) aunque ésta esté energizada por un pilón.
     */
    @Test
    public void Test01UnPilonNoEnergizaUnCasilleroConMoho() {
        //ARRANGE
        Mapa mapa = new Mapa(dimensionX, dimensionY);
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300, 300);
        Edificio pilon = new Pilon(mapa.adyacentes(casillero)[0], inventario);
        //ACT
        estaEnergizado = casillero.tieneEnergia();
        //ASSERT
        assertFalse(estaEnergizado);
    }

    @Test
    public void Test02UnAccesoNoSePuedeConstruirEnMohoPorMasQueEsteCercaDePilon() {
        //ARRANGE
        String expectedMessage = "Acceso no se puede construir en este casillero";
        Mapa mapa = new Mapa(dimensionX, dimensionY);
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300, 300);
        Edificio pilon = new Pilon(mapa.adyacentes(casillero)[0], inventario);
        //ACT
        Exception exception = assertThrows(NoSePuedeConstruirEnCasilleroConMohoException.class, () -> {
            new Acceso(casillero, inventario);
        });
        //ASSERT
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void Test03UnPuertoEstelarNoSePuedeConstruirEnMohoPorMasQueEsteCercaDePilon() {
        //ARRANGE
        String expectedMessage = "Puerto Estelar no se puede construir en este casillero";
        Mapa mapa = new Mapa(dimensionX, dimensionY);
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300, 300);
        Edificio pilon = new Pilon(mapa.adyacentes(casillero)[0], inventario);
        //ACT
        Exception exception = assertThrows(NoSePuedeConstruirEnCasilleroConMohoException.class, () -> {
            new PuertoEstelar(casillero, inventario);
        });
        //ASSERT
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void Test04MohoSePuedeExpandirPorAreaEnergizadaPorPilon() {
        //ARRANGE
        Mapa mapa = new Mapa(dimensionX, dimensionY);
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Edificio pilon = new Pilon(mapa.adyacentes(casillero)[0], inventario);
        casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(300, 300);
        //ACT
        mapa.pasarTurno();
        pilon.recibirDanio(1000);
        //ASSERT
        assertDoesNotThrow(new Criadero(casillero, inventario));
    }
}
