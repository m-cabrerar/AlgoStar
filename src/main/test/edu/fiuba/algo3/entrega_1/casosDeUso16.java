package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Criadero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
/*
public class casosDeUso16 {
    */
/*- Verificar que no se pueda construir sobre un volcán con una edificación ya existente
     * (propia o del enemigo)
     *- Verificar que no se pueda construir un nexo mineral si hay un zángano trabajando en él y
     * viceversa (zángano no puede extraer mineral si ya tiene un nexo construido sobre el
     * nodo).
     *//*



    @Test
    public void Test02NoPuedoConstruirUnNexoMineralSobreUnNodoConZangano() {
        //ARRANGE
        String mensaje = "No se puede construir en un mineral donde estan trabajando";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario(300,300);
        Criadero criadero = new Criadero(casillero,inventario);


        //Supuesto
        criadero.engendrarZangano();
        criadero.enviarZanganoAExtraerMineral(Casillero)
        //TODO ZANGANO EXTRAER MINERAL EN ESA CASILLA

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Unidad nexoMineral = new NexoMineral(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void Test03NoPuedoMandarUnZanganoARecolectarDondeHayUnNexoMineral() {
        //ARRANGE
        String mensaje = "No se puede extraer donde hay construcciones";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario(300,300);
        Unidad nexoMineral = new NexoMineral(casillero, inventario);
        for(int i=0; i<6; i++){
            nexoMineral.pasarTurno();
        }

        Criadero criadero = new Criadero(casillero,inventario);
        criadero.engendrarZangano();

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.enviarZanganoAExtraerMineral(Casillero)
            //TODO ZANGANO EXTRAER MINERAL EN ESA CASILLA
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
*/
