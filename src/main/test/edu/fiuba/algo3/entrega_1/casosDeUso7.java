package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso7 {
    /*Verificar la recolección de minerales para ambas razas.*/

    @Test
    public void Test01ProtossNexoMineralRecolecta10mineralEnUnTurno(){
        /*se asume que se recolecta 10 mineral por turno. Después se corroborará*/
        //Arrange
        Mineral mineralEsperado = new Mineral(10);
        Casillero casillero = new NodoMineral();
        Inventario inventario = new Inventario(50,0);
        Edificio nexoMineral = NexoMineral.construir(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            nexoMineral.pasarTurno();
        }
        Mineral mineralObtenido = nexoMineral.extraerMineral();

        //ASSERT
        assertEquals(mineralObtenido.total(), mineralEsperado.total());
    }

    @Test
    public void ProtossNoPuedeExtraerMineralSinEngendrarZangano(){

        //ARRANGE
        String mensaje = "No hay zanganos disponibles";

        //ARRANGE
        Casillero casillero = new NodoMineral();
        Criadero criadero = Criadero.inicializar();

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.enviarZanganoAExtraerMineral();
        });
        assertEquals(mensaje, exception.getMessage());
    }


    @Test
    public void Test02ZergZanganoExtrae10mineralEnUnTurno{

        //ARRANGE
        Criadero criadero = Criadero.inicializar();
        Mineral mineralEsperado = new Mineral(10)
        Casillero casillero = new NexoMineral();
        //por ahora el criadero se encarga directamente de esta tarea, necesita refactor
        //el haber engendrado zangano es lo que le permite extraerMineral
        criadero.engendrarZangano();

        //ACT
        for(int i=0; i<6; i++){
            criadero.pasarTurno();
        }
        Mineral mineralObtenido = criadero.enviarZanganoAExtraerMineral();

        //ASSERT
        assertEquals(mineralObtenido.total(), mineralEsperado.total());
    }
    
}
