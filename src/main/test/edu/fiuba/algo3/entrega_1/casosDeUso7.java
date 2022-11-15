/*
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class casosDeUso7 {
    //Verificar la recolección de minerales para ambas razas.
    @Test
    public void Test04ZergZanganoExtrae10mineralEnUnTurno(){

        //ARRANGE
        Criadero criadero = Criadero.inicializar();
        Mineral mineralEsperado = new Mineral(10);
        Casillero casillero = new NexoMineral();
        //por ahora el criadero se encarga directamente de esta tarea, necesita refactor
        //el haber engendrado zangano es lo que le permite extraerMineral
        criadero.engendrarZangano();

        //ACT3

        for(int i=0; i<6; i++){
            criadero.pasarTurno();
        }
        Mineral mineralObtenido = criadero.enviarZanganoAExtraerMineral();

        //ASSERT
        assertEquals(mineralObtenido.total(), mineralEsperado.total());
    }
    
}
*/