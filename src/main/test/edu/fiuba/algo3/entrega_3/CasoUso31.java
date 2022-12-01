package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.exceptions.SuministrosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CasoUso31{
    //Verificar que al destruir pilones, amos supremos o criaderos disminuye la capacidad de
    //suministros del jugador.
    @Test
    public void TengoDosCriaderosYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Danio danio = new Danio(600,600);
        Inventario inventario = new Inventario();
        inventario.agregarGas(150);

        Casillero casilleroMock = mock(Casillero.class);
        new Criadero(casilleroMock, inventario);
        Criadero criadero = new Criadero(casilleroMock, inventario);

        for (int i = 0; i < 5; i++) {
            new Zerling(inventario);
        }
        criadero.recibirDanio(danio);
        verify(casilleroMock, times(1)).desocupar();
        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }
    @Test
    public void TengoDosPilonesYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Danio danio = new Danio(600,600);
        Inventario inventario = new Inventario();
        inventario.agregarGas(300);
        inventario.agregarMineral(300);

        Casillero casilleroMock = mock(Casillero.class);
        new Pilon(casilleroMock, inventario);
        Pilon pilon2 = new Pilon(casilleroMock, inventario);

        for (int i = 0; i < 5; i++) {
            new Zerling(inventario);
        }
        pilon2.recibirDanio(danio);
        pilon2.recibirDanio(danio);

        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }

    @Test
    public void TengoDosAmosSupremosYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Danio danio = new Danio(600,600);
        Casillero casilleroMock = mock(Casillero.class);
        Inventario inventario = new Inventario();
        inventario.agregarGas(150);
        inventario.agregarMineral(300);

        new AmoSupremo(inventario);
        AmoSupremo amo2 = new AmoSupremo(inventario);
        amo2.ubicarEn(casilleroMock);

        for (int i = 0; i < 5; i++) {
            new Zerling(inventario);
        }
        amo2.recibirDanio(danio);

        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }

}
