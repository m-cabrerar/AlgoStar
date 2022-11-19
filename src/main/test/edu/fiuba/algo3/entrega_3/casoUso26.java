package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class casoUso26 {
    /* Verificar que para construir unidades se cuente con la capacidad de suministro
correspondiente*/

    @Test
    public void Test01ProtossNopuedeConstruirDragonNoTieneSuministro(){
        Inventario mockedInventario = mock(Inventario.class);
        when(mockedInventario.tieneRecursos(anyInt(), anyInt())).thenReturn(true);

        Dragon unDragon = new Dragon(mockedInventario);



    }
}
