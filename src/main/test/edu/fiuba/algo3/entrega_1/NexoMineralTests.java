package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.NexoMineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NexoMineralTests {

    @Test
    public void test01ConstruyoUnNexoMineralQueEstaraListoEn4Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio nexo = new NexoMineral(casillero, inventario);

        //ACT
        for(int i=0; i<4; i++){
            nexo.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(nexo.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnNexoMineralQueNoSePuedeUsarPasados3Turnos() {

        //ARRANGE
        String mensaje = "Tu Nexo Mineral ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio nexo = new NexoMineral(casillero, inventario);

        //ACT
        for(int i=0; i<3; i++){
            nexo.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            nexo.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }
}
