package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import org.mockito.*;

public class casosDeUso9 {
    /*Verificar que un edificio protoss sigue operativo si le destruyen un pilon que lo energiza
     *pero aún está dentro del rango de otro que también lo energiza.
     */

    @Test
    public void Test01AccesoSigueActivoUbicadoEnCasilleroEnergizado2PilonesCuandoUnoSeDestruye

    {
        //ARRANGE
        Casillero casillero;
        Casillero otroCasillero;
        casillero.energizar();
        casillero.energizar();
        Edificio.pilon(casillero);
        Banco banco = new Banco(200,200);
        Edificio edificio (otroCasillero, banco)
        //ACT
        pilon.recibirDanio(600);
        //Assert
        assertTrue(edificio.tieneEnergia());
    }
}




    /*
    Tenemos que usar la estructura esta?// @ExtendWith(MockitoExtension.class)
    @InjectMocks - @Mocks - @Test ?
        @InjectMocks
        Casillero casillero;
        @Mock
        Edificio edificio;
        @Test
        public void Test01name{
            Mockito.when(mockedCasillero.estaOcupado()).thenReturn(false);
        }

        //otro modo de encararlo, incompleto, ver si me sirve
         @Mock
    Edificio mockedPilon;
    Casillero casillero;

    @Captor
    private ArgumentCaptor<int> vidaPilonCaptor;
    @Test
    public void Test01EdificioSigueActivoUbicadoEnCasilleroEnergizado2PilonesCuandoUnoSeDestruye{
        Mockito.when(mockedCasillero.tieneEnergia()).thenReturn(true);

        verify(mockedPilon).recibirDanio(600)(vidaPilonCaptor.capture());
        int 0 = vidaPilonCaptor.getValue();
    }termino siendo para corroborar que el pilon este destruido
    //
       */