package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtractorTests {

    @Test
    public void test01ConstruyoUnExtractorQueEstaraListoEn6Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(extractor.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnExtractorQueNoSePuedeUsarPasados5Turnos() {

        //ARRANGE
        String mensaje = "Tu Extractor ha sido destruido";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

        //ACT
        for(int i=0; i<5; i++){
            extractor.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            extractor.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03ConstruyoUnExtractorSobreElGas(){
        //ARRANGE
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(200,200);
        //ACT
        Extractor extractor = new Extractor(casillero, inventario);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04ConstruirUnExtractorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un extractor en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Extractor extractor = new Extractor(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void Test05UnExtractorSinZanganosNoGeneraGas() {

        //ARRANGE
        String mensaje = "El extractor no tiene zanganos trabajando";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            extractor.extraerGas(inventario); //esto creo que habria que mandarselo a una metodo del inventario para agregar
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void Test06UnExtractorCon1ZanganoSaca10DeGas() {

        //ARRANGE
        Gas gasEsperado = new Gas(10);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

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
    public void Test07UnExtractorCon2ZanganosSaca20DeGas() {

        //ARRANGE
        Gas gasEsperado = new Gas(20);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

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
    public void Test08UnExtractorCon3ZanganosSaca30DeGas() {

        //ARRANGE
        Gas gasEsperado = new Gas(30);
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

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
    public void Test09UnExtractorNoPuedeTener4ZanganosTrabajando() {

        //ARRANGE
        String mensaje = "El extractor ya tiene 3 zanganos trabajando duro";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio extractor = new Extractor(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            extractor.pasarTurno();
        }
        extractor.agregarZangano();
        extractor.agregarZangano();
        extractor.agregarZangano();
        Exception exception = assertThrows(Exception.class, () -> {
            extractor.agregarZangano(); //esto creo que habria que mandarselo a una metodo del inventario para agregar
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }
}
