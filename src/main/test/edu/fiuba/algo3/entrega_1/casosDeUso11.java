package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class casosDeUso11 {
    /*Verificar que al dañar una construcción protoss sin quitarle _todo el escudo, la misma
     *recupera su escudo por turnos hasta volver a tener el 100% del mismo
     */

    // Asumo que los edificios Protoss recuperan 10 de escudo por turno.
    @Test
    public void test01AccesoRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        Acceso acceso = new Acceso(casillero, banco);
        //ACT
        acceso.recibirDanio(50);
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.recibirDanio(999);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test02NexoMineralRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        NexoMineral nexoMineral = new NexoMineral(casillero, banco);
        //ACT
        nexoMineral.recibirDanio(50);
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.pasarTurno();
        nexoMineral.recibirDanio(499);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test03PilonRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        Pilon pilon = new Pilon(casillero, banco);
        //ACT
        pilon.recibirDanio(50);
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.recibirDanio(599);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04PuertoEstelarRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, banco);
        //ACT
        puertoEstelar.recibirDanio(50);
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.pasarTurno();
        puertoEstelar.recibirDanio(1199);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test05AsimiladorRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Banco banco = new Banco(200,200);
        Asimilador asimilador = new Asimilador(casillero, banco);
        //ACT
        asimilador.recibirDanio(50);
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.recibirDanio(899);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

}
