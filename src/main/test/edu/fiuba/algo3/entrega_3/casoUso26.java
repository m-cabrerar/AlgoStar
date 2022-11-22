package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.SuministrosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class casoUso26 {
    /* Verificar que para construir unidades se cuente con la capacidad de suministro
correspondiente*/

    @Test
    public void Test01ProtossNopuedeConstruirDragonNoTieneSuministro(){
        //ARRANGE
        Inventario inventarioMock = mock(Inventario.class);
        when(inventarioMock.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(inventarioMock.tieneSuministros(anyInt())).thenReturn(false);
        //ACT & ASSERT
        assertThrows(SuministrosInsuficientes.class, () -> new Dragon(inventarioMock));
    }
}
