package edu.fiuba.algo3.entrega_1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Dictionary;

public class casosDeUso4 {
    /*Verificar que extractor sin zánganos trabajando no genera gas. Verificar que con 1 saca
     *10, con 2 20, con 3 30 y que no puede recibir a un 4to zángano porque está lleno. Verificar
     *que el Asimilador recoge gas una vez construido según lo estipulado.
     */

    @Test
    public void Test01UnExtractorSinZanganosNoGeneraGas() {

        //ARRANGE
        String mensaje = "El extractor no tiene zanganos trabajando";
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio extractor = Extractor.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            extractor.extraerGas(); //esto creo que habria que mandarselo a una metodo del banco para agregar
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void Test02UnExtractorCon1ZanganoSaca10DeGas() {

        //ARRANGE
        Gas gasEsperado = new Gas(10);
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio extractor = Extractor.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        extractor.agregarZangano();
        Gas gasObtenido = extractor.extraerGas();

        //ASSERT
        assertEquals(gasObtenido.total(), gasEsperado.total());
    }


    @Test
    public void Test03UnExtractorCon2ZanganosSaca20DeGas() {

        //ARRANGE
        Gas gasEsperado = new Gas(20);
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio extractor = Extractor.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        extractor.agregarZangano();
        extractor.agregarZangano();
        Gas gasObtenido = extractor.extraerGas();

        //ASSERT
        assertEquals(gasObtenido.total(), gasEsperado.total());
    }

    @Test
    public void Test04UnExtractorCon3ZanganosSaca30DeGas() {

        //ARRANGE
        Gas gasEsperado = new Gas(30);
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio extractor = Extractor.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        extractor.agregarZangano();
        extractor.agregarZangano();
        extractor.agregarZangano();
        Gas gasObtenido = extractor.extraerGas();

        //ASSERT
        assertEquals(gasObtenido.total(), gasEsperado.total());
    }

    @Test
    public void Test05UnExtractorNoPuedeTener4ZanganosTrabajando() {

        //ARRANGE
        String mensaje = "El extractor ya tiene 3 zanganos trabajando duro";
        Casillero casillero = new NodoDeGas();
        Banco banco = new Banco(300,300);
        Edificio extractor = Extractor.construir(casillero, banco);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        extractor.agregarZangano();
        extractor.agregarZangano();
        extractor.agregarZangano();
        Exception exception = assertThrows(Exception.class, () -> {
            extractor.agregarZangano(); //esto creo que habria que mandarselo a una metodo del banco para agregar
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }
}
