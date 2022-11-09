package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class casosDeUso1 {
    
    @Test
    public void test01ConsumoLaLarvaDeUnCriaderoParaEngendrarZanganoYCuandoPasaElTurnoTengo3OtraVez() {
        
        //ARRANGE
        Criadero criadero = Criadero.inicializar();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        //ACT
        criadero.engendrarZangano();
        
        //ASSERT
        criadero.pasarTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();

       //falta chequear que no lance error o no se que 
    }

    
}
