package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class casosDeUso12 {
    /*Verificar que al dañar una construcción protoss quitandole _todo el escudo y parte de la
     *vida la misma recupera SOLO su escudo por turnos hasta volver a tener el 100% del
     *mismo.
     */

    // Asumo que los edificios Protoss recuperan 10 de escudo por turno.
    @Test
public void test01NexoMineralRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero casillero = new Casillero();
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        Acceso acceso = new Acceso(casillero, inventario);
        //ACT
        acceso.recibirDanio(300);
        for(int i=0; i<30; i++){
            acceso.pasarTurno();
        }
        acceso.recibirDanio(450);
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test02PilonRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        Pilon pilon = new Pilon(casillero, inventario);
        //ACT
        pilon.recibirDanio(350);
        for(int i=0; i<35; i++){
            pilon.pasarTurno();
        }
        pilon.recibirDanio(550);
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test03AsimiladorRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        Asimilador asimilador = new Asimilador(casillero, inventario);
        //ACT
        asimilador.recibirDanio(500);
        for(int i=0; i<50; i++){
            asimilador.pasarTurno();
        }
        asimilador.recibirDanio(850);
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test04AccesoRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        Acceso acceso = new Acceso(casillero, inventario);
        //ACT
        acceso.recibirDanio(550);
        for(int i=0; i<55; i++){
            acceso.pasarTurno();
        }
        acceso.recibirDanio(950);
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test05PuertoEstelarRecibeDanioYRecuperaEscudo(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.estaOcupado()).thenReturn(false);
        when(mockedCasillero.tieneEnergia()).thenReturn(true);
        Inventario inventario = new Inventario(200,200);
        PuertoEstelar puertoEstelar = new PuertoEstelar(casillero, inventario);
        //ACT
        puertoEstelar.recibirDanio(650);
        for(int i=0; i<65; i++){
            puertoEstelar.pasarTurno();
        }
        puertoEstelar.recibirDanio(1150);
        //ASSERT
        assertFalse(casillero.estaOcupado());
    }
}

