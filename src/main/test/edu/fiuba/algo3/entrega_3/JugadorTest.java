package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Pilon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class JugadorTest {

    @Test
    public void Test01JugadorConstruyePilonSuInventarioTieneUnidades(){
        //ARRANGE
        Casillero mockedCasillero = mock(Casillero.class);
        Jugador unJugador = new Jugador("Jugador 1", "rojo", "Protoss");
        //ACT
        Pilon.construir(mockedCasillero, unJugador.getInventario());
        //ASSERT
        assertTrue(unJugador.tieneEdificios());
    }
}
