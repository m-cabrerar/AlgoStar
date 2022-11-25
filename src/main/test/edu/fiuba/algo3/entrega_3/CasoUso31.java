package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.exceptions.SuministrosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoUso31{
    //Verificar que al destruir pilones, amos supremos o criaderos disminuye la capacidad de
    //suministros del jugador.
    @Test
    public void TengoDosCriaderosYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarGas(150);

        Casillero casillero = mock(Casillero.class);
        Criadero criadero = new Criadero(casillero, inventario);

        Casillero casillero2 = mock(Casillero.class);
        Criadero criadero2 = new Criadero(casillero2, inventario);

        for (int i = 0; i < 5; i++) {
            Zerling zerling = new Zerling(inventario);
        }
        criadero2.recibirDanio(600);
        assertThrows(EstaDestruido.class, () -> criadero2.recibirDanio(600));
        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }
    @Test
    public void TengoDosPilonesYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarGas(150);

        Casillero casillero = mock(Casillero.class);
        Pilon pilon = new Pilon(casillero, inventario);

        Casillero casillero2 = mock(Casillero.class);
        Pilon pilon2 = new Pilon(casillero2, inventario);

        for (int i = 0; i < 5; i++) {
            Zerling zerling = new Zerling(inventario);
        }
        pilon2.recibirDanio(600);

        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }

    @Test
    public void TengoDosAmosSupremosYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarGas(150);
        inventario.agregarMineral(150);

        AmoSupremo amo1 = new AmoSupremo(inventario);
        AmoSupremo amo2 = new AmoSupremo(inventario);

        for (int i = 0; i < 5; i++) {
            Zerling zerling = new Zerling(inventario);
        }
        amo2.recibirDanio(600);

        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }

}
