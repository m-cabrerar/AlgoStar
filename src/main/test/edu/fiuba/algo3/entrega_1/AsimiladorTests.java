package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.NodoMineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AsimiladorTests {

    @Test
    public void test01ConstruyoUnAsimiladorQueEstaraListoEn6Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());//que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio asimilador = new Asimilador(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            asimilador.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(asimilador.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnAsimiladorQueNoSePuedeUsarPasados5Turnos() {

        //ARRANGE
        String mensaje = "Tu Asimilador ha sido destruido";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(300,300);
        Edificio asimilador = new Asimilador(casillero, inventario);

        //ACT
        for(int i=0; i<5; i++){
            asimilador.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            asimilador.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03ConstruyoUnAsimiladorSobreElGas(){
        //ARRANGE
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoDeGas());
        Inventario inventario = new Inventario(200,200);
        //ACT
        Asimilador asimilador = new Asimilador(casillero, inventario);
        //ASSERT
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void test04ConstruirUnAsimiladorSobreOtroCasilleroLanzaError(){
        //ARRANGE
        String mensaje = "No se puede construir un asimilador en este casillero";
        Casillero casillero = new Casillero();
        casillero.setTipoCasillero(new NodoMineral());
        Inventario inventario = new Inventario(200,200);
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Asimilador asimilador = new Asimilador(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void Test05NoPuedoConstruirUnAsimiladorSobreOtro() {
        //ARRANGE
        String mensaje = "No se puede construir sobre otra construccion";
        Casillero casillero = new Casillero();
        Casillero.setTipoCasillero(new NodoGas());
        Inventario inventario = new Inventario(300,300);
        Edificio asimilador = new Asimilador(casillero, inventario);

        //ACT
        for(int i=0; i<6; i++){
            asimilador.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio asimilador = new Asimilador(casillero, inventario);
        });
        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }
}
