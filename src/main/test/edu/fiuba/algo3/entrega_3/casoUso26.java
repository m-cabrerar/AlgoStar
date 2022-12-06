package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.SuministrosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.unidades.moviles.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class casoUso26 {
    /* Verificar que para construir unidades se cuente con la capacidad de suministro
correspondiente*/

    @Test
    public void Test01NoSePuedenConstruirDragonSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Dragon(inventarioMock));
    }

    @Test
    public void Test02NoSePuedenConstruirGuardianSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Guardian(inventarioMock));
    }

    @Test
    public void Test03NoSePuedenConstruirHidraliscoSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Hidralisco(inventarioMock));
    }

    @Test
    public void Test04NoSePuedenConstruirMutaliscoSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Mutalisco(inventarioMock));
    }

    @Test
    public void Test05NoSePuedenConstruirScoutSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Scout(inventarioMock));
    }

    @Test
    public void Test06NoSePuedenConstruirZealotSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Zealot(inventarioMock));
    }

    @Test
    public void Test07NoSePuedenConstruirZerlingSinSuministrosSuficientes(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Zerling(inventarioMock));
    }
}
