package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.SuministrosInsuficientes;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CasoUso29 {
    //Verificar que alcanzado el limite máximo de 200 de suministros no se siga sumando su
    //capacidad.
    @Test
    public void Agrego41PilonesPeroLosSuministrosDisponiblesSon200(){

        Casillero mockedCasillero = mock(Casillero.class);
        Inventario inventario = new Inventario();
        inventario.agregarMineral(4200);
        // Act
        for (int i = 0; i < 41; i++) {
            Pilon.construir(mockedCasillero, inventario);
        }

        //Assert
        assertTrue(inventario.tieneSuministros(200));
        assertFalse(inventario.tieneSuministros(201));
    }
}
