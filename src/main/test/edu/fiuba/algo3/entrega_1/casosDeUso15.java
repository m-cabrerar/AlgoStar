package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class casosDeUso15 {
    /*Verificar que no se sigan recolectando ni gas ni mineral una vez agotados los recursos del
     *nodo mineral o del volcán.
     */
    @Test
    public void Test01ExtractorRecolectoGasPeroSeAgotoElVolcanYNoCambiaElGasQueTengo() {

        //ARRANGE
        int unidadesGas = 5000;
        int unidadesRecolecto = 10;
        Gas gasEsperado = new Gas(unidadesGas);
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio extractor = Extractor.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno(); //Lo construi
        }

        extractor.agregarZangano();
        Gas gasObtenido = extractor.extraerGas();
        for(int i=0; i< (unidadesGas/unidadesRecolecto); i++){
            gasObtenido = gasObtenido + extractor.extraerGas();//Le saco una vez por turno hasta vaciarlo y repito una vez mas
            extractor.pasarTurno();
        }
        //Todo que se pueda sumar gas para poder hacer la operacion/refactor esa cuenta.

        //ASSERT
        assertEquals(gasObtenido.total(), gasEsperado.total()); //Aunque repeti mas veces de las necesarias extraer deberia igual tener solo 5000
    }

    @Test
    public void Test02AsimiladorRecolectoGasPeroSeAgotoElVolcanYNoCambiaElGasQueTengo() {

        //ARRANGE
        int unidadesGas = 5000;
        int unidadesRecolecto = 20;
        Gas gasEsperado = new Mineral(unidadesGas);
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio asimilador = Asimilador.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            asimilador.pasarTurno(); //Lo construi
        }

        Gas gasObtenido = asimilador.extraerGas();
        for(int i=0; i< (unidadesGas/unidadesRecolecto); i++){
            gasObtenido = gasObtenido + asimilador.extraerGas();//Le saco una vez por turno hasta vaciarlo y repito una vez mas
            asimilador.pasarTurno();
        }
        //Todo que se pueda sumar gas para poder hacer la operacion/refactor esa cuenta.

        //ASSERT
        assertEquals(gasObtenido.total(), gasEsperado.total()); //Aunque repeti mas veces de las necesarias extraer deberia igual tener solo 5000
    }

    @Test
    public void Test03NexoMineralRecolectaPeroElNodoSeAgotoYNoRecolectaNada() {
    //SUPONGO QUE RECOLECTO 10 UNIDADES POR TURNO
        //ARRANGE
        int unidadesMineral = 2000;
        int unidadesRecolecto = 10;
        Mineral mineralEsperado = new Mineral(unidadesMineral);
        Casillero casillero = new NodoMineral();
        Banco banco = new Banco(300,300);
        Edificio nexoMineral = NexoMineral.construir(casillero, banco);

        //ACT
        for(int i=0; i<4; i++){
            nexoMineral.pasarTurno(); //Lo construi
        }

        Mineral mineralObtenido = nexoMineral.extraerMineral();
        for(int i=0; i< (unidadesMineral/unidadesRecolecto); i++){
            mineralObtenido = mineralObtenido + nexoMineral.extraerMineral();//Le saco una vez por turno hasta vaciarlo y repito una vez mas
            nexoMineral.pasarTurno();
        }
        //Todo que se pueda sumar gas para poder hacer la operacion/refactor esa cuenta.

        //ASSERT
        assertEquals(mineralObtenido.total(), mineralEsperado.total()); //Aunque repeti mas veces de las necesarias extraer deberia igual tener solo 5000
    }

}
