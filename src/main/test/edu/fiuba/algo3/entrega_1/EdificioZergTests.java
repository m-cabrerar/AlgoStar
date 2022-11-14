package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class EdificioZergTests {

    // Asumo que los edificios Zerg recuperan 10 de vida por turno.

    @Test
    public void test01CriaderoRecibeDanioYRecuperaVida(){
        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(200,200);
        Criadero criadero = new Criadero(casillero, inventario);
        //ACT
        criadero.recibirDanio(50);
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.recibirDanio(499);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test02ExtractorRecibeDanioYRecuperaVida(){
        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(200,200);
        Extractor extractor = new Extractor(casillero, inventario);
        //ACT
        extractor.recibirDanio(50);
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.recibirDanio(999);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test03ReservaDeReproduccionRecibeDanioYRecuperaVida(){
        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(200,200);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casillero, inventario);
        //ACT
        reservaDeReproduccion.recibirDanio(50);
        reservaDeReproduccion.pasarTurno();
        reservaDeReproduccion.pasarTurno();
        reservaDeReproduccion.pasarTurno();
        reservaDeReproduccion.pasarTurno();
        reservaDeReproduccion.pasarTurno();
        reservaDeReproduccion.recibirDanio(749);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04GuaridaRecibeDanioYRecuperaVida(){
        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(200,200);
        Guarida guarida = new Guarida(casillero, inventario);
        //ACT
        guarida.recibirDanio(50);
        guarida.pasarTurno();
        guarida.pasarTurno();
        guarida.pasarTurno();
        guarida.pasarTurno();
        guarida.pasarTurno();
        guarida.recibirDanio(1249);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test05EspiralRecibeDanioYRecuperaVida(){
        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario(200,200);
        Espiral espiral = new Espiral(casillero, inventario);
        //ACT
        espiral.recibirDanio(50);
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.recibirDanio(1299);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }
}
