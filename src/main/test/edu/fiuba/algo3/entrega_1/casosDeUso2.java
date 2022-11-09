package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class casosDeUso2 {
    /* Verificar que cada edificio / construcción tarde en construirse lo que dice que tarda y que
     *recién están “operativos” cuando ya se terminaron de construir.
     */
    @Test
    public void test01ConstruyoUnCriaderoQueEstaraListoEn4Turnos() {

        //ARRANGE
        Criadero criadero = Criadero.inicializar();
        
        //ACT
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        //ASSERT
        //chequeo que este listo para uso
    }

    @Test
    public void test02ConstruyoUnNexoMineralQueEstaraListoEn4Turnos(){

        //ARRANGE
        NexoMineral nexo = NexoMineral.inicializar();

        //ACT
        nexo.pasarTurno();
        nexo.pasarTurno();
        nexo.pasarTurno();
        nexo.pasarTurno();

        //ASSERT

    }

}
