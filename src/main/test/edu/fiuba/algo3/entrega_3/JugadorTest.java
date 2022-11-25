package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {

    @Test
    public void Test01JugadorConstruyePilonSuInventarioTieneUnidades(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        when(mockedCasillero.esDelTipo(any())).thenReturn(true);
        Jugador unJugador = new Jugador();
        //ACT
        unJugador.construirPilon(mockedCasillero);
        //ASSERT
        assertTrue(unJugador.tieneEdificios());
    }
}
