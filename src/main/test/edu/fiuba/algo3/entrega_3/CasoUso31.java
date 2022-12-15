package edu.fiuba.algo3.entrega_3;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.Pilon;
import edu.fiuba.algo3.modelo.unidades.moviles.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.moviles.Zerling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CasoUso31{
    //Verificar que al destruir pilones, amos supremos o criaderos disminuye la capacidad de
    //suministros del jugador.
    @Test
    public void Test01TengoDosCriaderosYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Danio danio = new Danio(600,600);
        Inventario inventario = new Inventario();
        inventario.agregarMineral(500);
        inventario.agregarGas(500);

        Casillero casilleroMock = mock(Casillero.class);
        new Criadero(casilleroMock, inventario);
        Criadero criadero = new Criadero(casilleroMock, inventario);

        for (int i = 0; i < 5; i++) {
            new Zerling(inventario);
        }
        try {
            criadero.recibirDanio(danio);
        } catch (Exception EstaDestruido){

        }

        verify(casilleroMock, times(1)).desocupar();
        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }
    @Test
    public void Test02TengoDosPilonesYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

        //ARRANGE
        Danio danio = new Danio(600,600);
        Inventario inventario = new Inventario();
        inventario.agregarGas(600);
        inventario.agregarMineral(600);

        Casillero casilleroMock = mock(Casillero.class);
        Pilon pilon1 = new Pilon(casilleroMock, inventario);
        pilon1.ubicarEnInventario();
        Pilon pilon2 = new Pilon(casilleroMock, inventario);
        pilon2.ubicarEnInventario();

        for (int i = 0; i < 5; i++) {
            new Zerling(inventario);
        }
        try {
            pilon2.recibirDanio(danio);
            fail();
        } catch (Exception EstaDestruido){
            assertFalse(inventario.tieneSuministros(1));
        }
    }

    @Test
    public void Test03TengoDosAmosSupremosYDestruyoUnoSoloPuedoHacer5ZerlingsYMeQuedoSinSuministros() {

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
        try {
            amo2.recibirDanio(danio);
        } catch (Exception EstaDestruido){

        }

        //act & assert
        assertFalse(inventario.tieneSuministros(1));

    }

}
