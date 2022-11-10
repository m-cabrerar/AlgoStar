package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class casosDeUso10 {
    /*Verificar que al dañar una construcción zerg, la misma recupera la vida por turnos hasta
     *volver a tener el 100%.
     */
    @Test
    public void test01CriaderoRecibeDanioYRecuperaVida(){
        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new Moho());
        Banco banco = new Banco(200,200);
        Criadero criadero = new Criadero(casillero, banco);
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
        Banco banco = new Banco(200,200);
        Extractor extractor = new Extractor(casillero, banco);
        //ACT
        extractor.recibirDanio(50);
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
        Banco banco = new Banco(200,200);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(casillero, banco);
        //ACT
        reservaDeReproduccion.recibirDanio(50);
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
        Banco banco = new Banco(200,200);
        Guarida guarida = new Guarida(casillero, banco);
        //ACT
        guarida.recibirDanio(50);
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
        Banco banco = new Banco(200,200);
        Espiral espiral = new Espiral(casillero, banco);
        //ACT
        espiral.recibirDanio(50);
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.recibirDanio(1299);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }
}
