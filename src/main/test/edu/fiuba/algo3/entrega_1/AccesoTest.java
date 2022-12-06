package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Acceso;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccesoTest {
    @Test
    public void test01AccesoSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario inventario = new Inventario();
        // Act & Assert
        assertDoesNotThrow(() -> Acceso.construir(casillero, inventario));
    }

    @Test
    public void test02AccesoSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario inventario = new Inventario();
        //Vacio inventario
        inventario.pagarMateriales(0,200);

        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Acceso.construir(casillero, inventario));
    }

    @Test
    public void test03AccesoSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        Inventario inventario = new Inventario();
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Acceso.construir(casillero, inventario));
    }

    @Test
    public void test04ConstruyoUnAccesoQueEstaraListoEn8Turnos() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario inventario = new Inventario();
        Danio mockedDanio = mock(Danio.class);
        when(mockedDanio.ataqueTerrestre()).thenReturn(1);

        Unidad acceso = Acceso.construir(casillero, inventario);
        
        for (int i = 0; i < 8; i++) {
            acceso.pasarTurno();
        }
        // Act
        try{acceso.recibirDanio(mockedDanio);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> acceso.recibirDanio(mockedDanio));
    }

    @Test
    public void test05ConstruyoUnAccesoYNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        Inventario inventario = new Inventario();
        Danio danio = new Danio(0,1);

        Unidad acceso = Acceso.construir(casillero, inventario);

        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> acceso.recibirDanio(danio));
    }

    @Test
    public void test06ConstruyoUnAccesoYLuegoDe7turnosNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario inventario = new Inventario();
        
        Danio danio = new Danio(0,1);

        Unidad acceso = Acceso.construir(casillero, inventario);
        for (int i = 0; i < 7; i++) {
            acceso.pasarTurno();
        }
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> acceso.recibirDanio(danio));
    }

    @Test
    public void test07AccesoRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();

        Inventario inventario = new Inventario();
        
        Danio danio = new Danio(0,50);
        Danio danio2 = new Danio(0,999);

        Unidad acceso = new Acceso(casillero, inventario);
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        acceso.pasarTurno();
        try{acceso.recibirDanio(danio2);}
        catch(Exception e){}
        //ASSERT
        assertDoesNotThrow(()-> casillero.desocupar());
    }

    @Test
    public void test08AccesoRecibeDanioPerdiendoTodoElEscudoYRecuperaSoloEscudo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.energizar();
        
        Danio danio = new Danio(0,550);
        Danio danio2 = new Danio(0,950);

        Inventario inventario = new Inventario();
    
        Unidad acceso = new Acceso(casillero, inventario);
        // Act
        try{acceso.recibirDanio(danio);}
        catch(Exception e){}
        for(int i=0; i<55; i++){
            acceso.pasarTurno();
        }
        try{acceso.recibirDanio(danio2);}
        catch(Exception e){
        }
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test09AccesoRecibeDanioYSeDestruye() {
        // Arrange
        Casillero casillero = mock(Casillero.class);
        casillero.energizar();

        Inventario inventario = new Inventario();

        Danio danio = new Danio(0,5000);

        Unidad acceso = new Acceso(casillero, inventario);
        // Act
        acceso.recibirDanio(danio);
        try{
            acceso.recibirDanio(danio);
        } catch (Exception e){}
        //ASSERT
        verify(casillero, times(1)).desocupar();
    }
}

