package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasilleroEspacialTest {
    @Test
    public void Test01elCasilleroEspecialVacioAceptaUnaUnidadVoladora(){
        //Arrange
        int alto = 10;
        int ancho = 10;
        Mapa mapa = new Mapa(alto,ancho);
        mapa.cambiarTipoCasilla(0,0, new CasilleroEspacial());
        UnidadMovil unidadVoladoraMock = mock(UnidadMovil.class);
        when(unidadVoladoraMock.esVoladora()).thenReturn(true);

        //Act and assert
        assertDoesNotThrow(() -> mapa.obtenerCasillero(0,0).ocupar(unidadVoladoraMock));
    }

    @Test
    public void Test02elCasilleroEspecialVacioNoAceptaUnaUnidadNoVoladora(){
        //Arrange
        int alto = 10;
        int ancho = 10;
        Mapa mapa = new Mapa(alto,ancho);
        mapa.cambiarTipoCasilla(0,0,new CasilleroEspacial());
        UnidadMovil unidadVoladoraMock = mock(UnidadMovil.class);
        when(unidadVoladoraMock.esVoladora()).thenReturn(false);

        //Act and assert
        assertThrows(UbicacionInvalida.class, () -> mapa.obtenerCasillero(0,0).ocupar(unidadVoladoraMock));
    }


}
