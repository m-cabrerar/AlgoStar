package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.exceptions.CasilleroNoCompatible;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.exceptions.CorrelativasInsuficientes;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class casosDeUso20 {
    //Verificar  que solo las unidades voladoras puedan moverse por áreas espaciales.
    @Test
    public void Test01elCasilleroEspecialVacioAceptaUnaUnidadVoladora(){
        //Arrange
        int alto = 10;
        int ancho = 10;
        Mapa mapa = new Mapa(alto,ancho);
        mapa.cambiarTipoCasilla(0,0,new CasilleroEspacial());
        UnidadMovil unidadVoladoraMock = mock(UnidadMovil.class);
        when(unidadVoladoraMock.esVoladora()).thenReturn(true);

        //Act and assert
        //assertDoesNotThrow(() -> casillero.ocupar(unidadVoladoraMock));
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
        //assertThrows(CasilleroNoCompatible.class, () -> casillero.ocupar(unidadVoladoraMock));
    }


}
