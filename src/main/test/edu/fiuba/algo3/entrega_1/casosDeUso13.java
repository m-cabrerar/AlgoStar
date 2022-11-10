package edu.fiuba.algo3.entrega_1;
import org.junit.jupiter.api.Test;
public class casosDeUso13 {
    /*Se destruye un criadero e igual se puede seguir construyendo sobre el moho que dejó.*/
    @Test
    public void Test01AlDestruirUnCriaderoSePuedeConstruirSobreElMohoQueDejo() {

        //ARRANGE
        Casillero casillero = new Moho();
        Banco banco = new Banco(300,300);
        Edificio criadero = new Criadero(casillero, banco);

        //ACT
        for(int i=0; i<4; i++){
            criadero.pasarTurno();
        }
        criadero.destruir();

        //ASSERT
        assertDoesNotThrow( new Criadero(casillero, banco) );

    }
}
