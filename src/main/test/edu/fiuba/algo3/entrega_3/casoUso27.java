package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.moviles.Mutalisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class casoUso27 {
    /* Verificar el comportamiento y condiciones de evolucion del Devorador*/
    @Test
    public void Test01NoSePuedeEvolucionarDevoradorSinRecursosSuficientes(){
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarGas(100);
        inventario.agregarSuministro(4);
        Mutalisco muta = new Mutalisco(inventario);
        //ACT && ASSERT
        assertThrows(RecursosInsuficientes.class, () -> muta.evolucionarADevorador());
    }

    @Test
    public void Test02SePuedeEvolucionarDevoradorConRecursosSuficientes(){
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarSuministro(4);
        inventario.agregarGas(200);
        inventario.agregarMineral(200);
        Mutalisco muta = new Mutalisco(inventario);
        Casillero casilleroMock = mock(Casillero.class);
        muta.ubicarEn(casilleroMock);
        //ACT
        muta.evolucionarADevorador();
        muta.pasarTurno();
        muta.pasarTurno();
        muta.pasarTurno();
        muta.pasarTurno();
        //ASSERT
        assertThrows(Exception.class, () -> muta.evolucionarADevorador());
    }

    @Test
    public void Test03SePuedeEvolucionarAGuardianConRecursosSuficientes(){
        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarSuministro(4);
        inventario.agregarGas(200);
        inventario.agregarMineral(200);
        Mutalisco muta = new Mutalisco(inventario);
        Casillero casilleroMock = mock(Casillero.class);
        muta.ubicarEn(casilleroMock);
        //ACT
        muta.evolucionarAGuardian();
        muta.pasarTurno();
        muta.pasarTurno();
        muta.pasarTurno();
        muta.pasarTurno();
        //ASSERT
        assertThrows(UnidadYaEvolucionada.class, () -> muta.evolucionarAGuardian());
    }
}
