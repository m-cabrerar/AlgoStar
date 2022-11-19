package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class casoUso26 {
    /* Verificar que para construir unidades se cuente con la capacidad de suministro
correspondiente*/

    @Test
    public void Test01ProtossNopuedeConstruirDragonNoTieneSuministro(){
        String mensaje = "No tiene suministros";
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);
        when(mockedInventario.tieneSuministros(anyInt())).thenReturn(false);
        //quien engengra las unidades?
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Dragon unDragon = new Dragon(mockedInventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
