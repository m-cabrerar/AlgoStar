package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.exceptions.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoUso30 {
    //Verificar que alcanzado el limite máximo de 200 de suministros no se puedan construir
    //más unidades.
    @Test
    public void Contruyo200ZerlingsyFallaEnEl201() {

        //ARRANGE
        Inventario inventario = new Inventario();
        inventario.agregarGas(5025);
        inventario.agregarSuministro(200);

        for (int i = 0; i < 200; i++) {
            Zerling zerling = new Zerling(inventario);
        }
        inventario.agregarSuministro(2); //recargo el inventario para tener los suministros para el 201.

        //act & assert
        assertThrows(PoblacionMaximaAlcanzada.class, () -> new Zerling(inventario));
    }
}
