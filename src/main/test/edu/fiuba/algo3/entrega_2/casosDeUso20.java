package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class casosDeUso20 {
    //Verificar  que solo las unidades voladoras puedan moverse por áreas espaciales.
    @Test
    public void Test01elCasilleroEspecialAceptaUnaUnidadVoladora(){
        //Arrange
        int alto = 10;
        int ancho = 10;
        Mapa mapa = new Mapa(alto,ancho);
        mapa.cambiarTipoCasilla(0,0,new CasilleroEspacial());


        //Act and assert
        assertDoesNotThrow(() -> casillero.ocupar(unidadVoladoraMock));
    }
}
