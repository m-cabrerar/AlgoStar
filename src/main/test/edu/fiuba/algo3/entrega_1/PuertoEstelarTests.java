package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Inventario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PuertoEstelarTests {

    @Test
    public void test01ConstruyoUnPuertoEstelarQueEstaraListoEn10Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio puerto = new PuertoEstelar(casillero, inventario);

        //ACT
        for(int i=0; i<10; i++){
            puerto.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(puerto.recibirDanio(5) );

    }

    @Test
    public void test02ConstruyoUnPuertoEstelarQueNoSePuedeUsarPasados9Turnos() {

        //ARRANGE
        String mensaje = "Tu Puerto Estelar ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio puerto = new PuertoMineral(casillero, inventario);

        //ACT
        for(int i=0; i<9; i++){
            puerto.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            puerto.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03NoSePuedeConstruirUnPuertoEstelarSinTenerUnAcceso(){
        //ARRANGE
        String mensaje = "Aun no puedes construir un Puerto Estelar";
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero(); //que debera estar en rango de un pilon
        //ACT
        Exception exception = assertThrows(Exception.class, () -> {
            Edificio puerto = new PuertoEstelar(casillero, inventario);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test04SePuedeConstruirUnPuertoEstelarSiTengoUnAcceso(){
        //ARRANGE
        Inventario inventario = new Inventario(300,300);
        Casillero casillero = new Casillero(); //que debera estar en rango de minimo un pilon
        //ACT

        Edificio acceso = new Acceso(casillero, inventario);
        //ASSERT
        assertDoesNotThrow( Edificio puerto = new PuertoEstelar(casillero, inventario));
    }
}
