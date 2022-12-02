package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.lang.module.FindException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AsimiladorTest {
    @Test
    public void test01AsimiladorSeConstruyeEnLaCasillaCorrectaYConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario inventario = new Inventario();
        // Act & Assert
        assertDoesNotThrow(() -> Asimilador.construir(casillero, inventario));
    }

    @Test
    public void test02AsimiladorSeConstruyeEnLaCasillaCorrectaPeroConRecursosInsuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Inventario inventario = new Inventario();
        //Vacio inventario
        inventario.pagarMateriales(0,200);
        // Act & Assert
        assertThrows(RecursosInsuficientes.class, () -> Asimilador.construir(casillero, inventario));
    }

    @Test
    public void test03AsimiladorSeConstruyeEnLaCasillaIncorrectaPeroConRecursosSuficientes() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new Moho());
        Inventario inventario = new Inventario();
        // Act & Assert
        assertThrows(UbicacionInvalida.class, () -> Asimilador.construir(casillero, inventario));
    }

    @Test
    public void test04ConstruyoUnAsimiladorQueEstaraListoEn6Turnos() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());

        Inventario inventario = new Inventario();
        Danio mockedDanio = mock(Danio.class);
        when(mockedDanio.ataqueTerrestre()).thenReturn(1);

        Unidad asimilador = Asimilador.construir(casillero, inventario);
        for (int i = 0; i < 6; i++) {
            asimilador.pasarTurno();
        }
        // Act
        try{asimilador.recibirDanio(mockedDanio);}
        catch(Exception e){}
        // Assert
        assertDoesNotThrow(() -> asimilador.recibirDanio(mockedDanio));
    }

    @Test
    public void test05ConstruyoUnAsimiladorYNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());

        Inventario inventario = new Inventario();

        Danio danio = new Danio(0,1);

        Unidad asimilador = Asimilador.construir(casillero, inventario);
        // Act
        try{asimilador.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> asimilador.recibirDanio(danio));
    }

    @Test
    public void test06ConstruyoUnAsimiladorYLuegoDe5turnosNoEstaListo() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());

        Inventario inventario = new Inventario();
       
        Danio danio = new Danio(0,1);

        Unidad asimilador = Asimilador.construir(casillero, inventario);
        for (int i = 0; i < 5; i++) {
            asimilador.pasarTurno();
        }
        // Act
        try{asimilador.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertThrows(EstaDestruido.class, () -> asimilador.recibirDanio(danio));
    }

    @Test
    public void test07AsimiladorRecibeDanioSinPerderTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());

        Danio danio1 = new Danio(0,50);
        Danio danio2 = new Danio(0,440);

        Inventario inventario = new Inventario();

        Unidad asimilador = new Asimilador(casillero, inventario);
        // Act
        try{asimilador.recibirDanio(danio1);}
        catch(Exception e){fail();}

        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();
        asimilador.pasarTurno();

        try{asimilador.recibirDanio(danio2);}
        catch(Exception e){fail();}
        // Assert
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test08AsimiladorRecibeDanioPerdiendoTodoElEscudoYSeRegenera() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());

        Danio danio = new Danio(0,500);
        Danio danio2 = new Danio(0,400);

        Inventario inventario = new Inventario();

        Unidad asimilador = new Asimilador(casillero, inventario);
        // Act
        try{
            asimilador.recibirDanio(danio);
            asimilador.recibirDanio(danio2); //con esto queda sin escudo y 50 de vida
        }
        catch(Exception EstaDestruido){fail();}
        for (int i = 0; i < 50; i++) {
            asimilador.pasarTurno();
        }
        try{asimilador.recibirDanio(danio);}
        catch(Exception e){fail();}
        // Assert
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test09AsimiladorRecibeDanioYSeDestruye() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());
        Danio danio = new Danio(0,1000);

        Inventario inventario = new Inventario();

        Unidad asimilador = Asimilador.construir(casillero, inventario);
        // Act
        try{asimilador.recibirDanio(danio);}
        catch(Exception e){}
        // Assert
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void test10AsimiladorExtraeGas() {
        // Arrange
        Casillero casillero = new Casillero(0,0,mock(Mapa.class));
        casillero.setTipoCasillero(new NodoGas());

        Inventario inventario = new Inventario();

        Asimilador asimilador = new Asimilador(casillero, inventario);
        // Act
        int gasExtraido = asimilador.extraerGas();
        // Assert
        assertEquals(20, gasExtraido);
    }
}
