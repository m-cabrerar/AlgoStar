package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Pilon extends EdificioProtoss {
    private static int SUMINISTRA = 5;
    public Pilon(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 300, 300);
        inventario.agregarSuministro(SUMINISTRA);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    int turnosParaConstruir() {
        return 5;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        EdificioConcreto pilon = new Pilon(casillero, inventario);
        if (!casillero.esDelTipo(new CasilleroVacio())) {
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if (!inventario.tieneRecursos(0, 100)) {
            throw new RecursosInsuficientes("No tiene recursos");
        }
        casillero.energizarEnRango(5);
        return new EdificioEnConstruccion(pilon, casillero, inventario);
    }

    @Override
    public void recibirDanio(int danio) throws EstaDestruido{
        super.recibirDanio(danio);
        if (this.estaDestruido()){
            this.inventario.perderSuministro(SUMINISTRA);
        }
    }
}