package edu.fiuba.algo3.entrega_1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso16 {
    /*- Verificar que no se pueda construir sobre un volcán con una edificación ya existente
     * (propia o del enemigo)
     *- Verificar que no se pueda construir un nexo mineral si hay un zángano trabajando en él y
     * viceversa (zángano no puede extraer mineral si ya tiene un nexo construido sobre el
     * nodo).
     */
    @Test
    public void Test01NoPuedoConstruirUnAsimiladorSobreOtro() {
        //ARRANGE
        String mensaje = "No se puede construir sobre otra construccion";
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio asimilador = new Asimilador(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            asimilador.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio asimilador = new Asimilador(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void Test02NoPuedoConstruirUnNexoMineralSobreUnNodoConZangano() {
        //ARRANGE
        String mensaje = "No se puede construir en un mineral donde estan trabajando";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(300,300);
        Criadero criadero = Criadero.inicializar();


        //Supuesto
        Zangano zangano = criadero.engendrarZangano();
        zangano.recolectarMineral(casillero);
        //TODO ZANGANO EXTRAER MINERAL EN ESA CASILLA

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio nexoMineral = new NexoMineral(casillero, banco);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void Test03NoPuedoMandarUnZanganoARecolectarDondeHayUnNexoMineral() {
        //ARRANGE
        String mensaje = "No se puede extraer donde hay construcciones";
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(300,300);
        Edificio nexoMineral = new NexoMineral(casillero, banco);
        for(int i=0; i<6; i++){
            nexoMineral.pasarTurno();
        }

        Criadero criadero = Criadero.inicializar();
        Zangano zangano = criadero.engendrarZangano();

        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            zangano.recolectarMineral(casillero);
            //TODO ZANGANO EXTRAER MINERAL EN ESA CASILLA
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
