package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class casosDeUso2 {
    /* Verificar que cada edificio / construcción tarde en construirse lo que dice que tarda y que
     *recién están “operativos” cuando ya se terminaron de construir.
     */
    @Test
    public void test01ConstruyoUnCriaderoQueEstaraListoEn4Turnos() {

        //ARRANGE
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(100,100);
        Edificio criadero = new Criadero(casillero, inventario);
        
        //ACT
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        //ASSERT
        assertDoesNotThrow(criadero.recibirDanio(5));

    }

    @Test
    public void test02ConstruyoUnCriaderoQueNoSePuedeUsarPasados3Turnos() {

        //ARRANGE
        String mensaje = "Tu Criadero ha sido destruido";
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(100,100);
        Edificio criadero = new Criadero(casillero, inventario);
        
        //ACT
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        Exception exception = assertThrows(Exception.class, () -> {
            criadero.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test03ConstruyoUnaRerservaDeReproduccionQueEstaraListoEn12Turnos() {

        //ARRANGE
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(300,300);
        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);
        
        //ACT
        for(int i=0; i<12; i++){
            reserva.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(reserva.recibirDanio(5) );

    }

    @Test
    public void test04ConstruyoUnaReservaDeReproduccionQueNoSePuedeUsarPasados11Turnos() {

        //ARRANGE
        String mensaje = "Tu Reserva de Produccion ha sido destruido";
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(300,300);
        Edificio reserva = new ReservaDeReproduccion(casillero, inventario);
        
        //ACT
        for(int i=0; i<11; i++){
            reserva.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            reserva.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test05ConstruyoUnExtractorQueEstaraListoEn6Turnos() {

        //ARRANGE
        Casillero casillero = new NodoDeGas();
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
    public void test06ConstruyoUnExtractorQueNoSePuedeUsarPasados5Turnos() {

        //ARRANGE
        String mensaje = "Tu Extractor ha sido destruido";
        Casillero casillero = new NodoDeGas();
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
    public void test07ConstruyoUnaGuaridaQueEstaraListoEn12Turnos() {

        //ARRANGE
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(300,300);
        Edificio guarida = new Guarida(casillero, inventario);
        
        //ACT
        for(int i=0; i<12; i++){
            guarida.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(guarida.recibirDanio(5) );

    }

    @Test
    public void test08ConstruyoUnaGuaridaQueNoSePuedeUsarPasados11Turnos() {

        //ARRANGE
        String mensaje = "Tu Guarida ha sido destruida";
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(300,300);
        Edificio guarida = new Guarida(casillero, inventario);
        
        //ACT
        for(int i=0; i<11; i++){
            guarida.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            guarida.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test09ConstruyoUnEspiralQueEstaraListoEn10Turnos() {

        //ARRANGE
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(300,300);
        Edificio espiral = new Espiral(casillero, inventario);
        
        //ACT
        for(int i=0; i<10; i++){
            espiral.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(espiral.recibirDanio(5) );

    }

    @Test
    public void test10ConstruyoUnEspiralQueNoSePuedeUsarPasados9Turnos() {

        //ARRANGE
        String mensaje = "Tu Espiral ha sido destruido";
        Casillero casillero = new Moho();
        Inventario inventario = new Inventario(300,300);
        Edificio espiral = new Espiral(casillero, inventario);
        
        //ACT
        for(int i=0; i<9; i++){
            espiral.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            espiral.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test11ConstruyoUnNexoMineralQueEstaraListoEn4Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio nexo = new NexoMineral(casillero, inventario);
        
        //ACT
        for(int i=0; i<4; i++){
            nexo.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(nexo.recibirDanio(5) );

    }

    @Test
    public void test12ConstruyoUnNexoMineralQueNoSePuedeUsarPasados3Turnos() {

        //ARRANGE
        String mensaje = "Tu Nexo Mineral ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio nexo = new NexoMineral(casillero, inventario);
        
        //ACT
        for(int i=0; i<3; i++){
            nexo.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            nexo.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test13ConstruyoUnPilonQueEstaraListoEn5Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio pilon = new Pilon(casillero, inventario);
        
        //ACT
        for(int i=0; i<5; i++){
            pilon.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(pilon.recibirDanio(5) );

    }

    @Test
    public void test14ConstruyoUnPilonQueNoSePuedeUsarPasados4Turnos() {

        //ARRANGE
        String mensaje = "Tu Pilon ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio pilon = new Pilon(casillero, inventario);
        
        //ACT
        for(int i=0; i<4; i++){
            pilon.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            pilon.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());

    }

    @Test
    public void test15ConstruyoUnAsimiladorQueEstaraListoEn6Turnos() {

        //ARRANGE
        Casillero casillero = new NodoDeGas(); //que debera tener energia o estar en rango
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
    public void test16ConstruyoUnAsimiladorQueNoSePuedeUsarPasados5Turnos() {

        //ARRANGE
        String mensaje = "Tu Asimilador ha sido destruido";
        Casillero casillero = new NodoDeGas();
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
    public void test17ConstruyoUnAccesoQueEstaraListoEn8Turnos() {

        //ARRANGE
        Casillero casillero = new Casillero(); //que debera tener energia o estar en rango
        Inventario inventario = new Inventario(300,300);
        Edificio acceso = new Acceso(casillero, inventario);
        
        //ACT
        for(int i=0; i<8; i++){
            acceso.pasarTurno();
        }

        //ASSERT
        assertDoesNotThrow(acceso.recibirDanio(5) );

    }

    @Test
    public void test18ConstruyoUnAccesoQueNoSePuedeUsarPasados7Turnos() {

        //ARRANGE
        String mensaje = "Tu Acceso ha sido destruido";
        Casillero casillero = new Casillero();
        Inventario inventario = new Inventario(300,300);
        Edificio acceso = new Acceso(casillero, inventario);
        
        //ACT
        for(int i=0; i<7; i++){
            acceso.pasarTurno();
        }
        Exception exception = assertThrows(Exception.class, () -> {
            acceso.recibirDanio(5);
        });

        //ASSERT
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    public void test19ConstruyoUnPuertoEstelarQueEstaraListoEn10Turnos() {

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
    public void test20ConstruyoUnPuertoEstelarQueNoSePuedeUsarPasados9Turnos() {

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
}