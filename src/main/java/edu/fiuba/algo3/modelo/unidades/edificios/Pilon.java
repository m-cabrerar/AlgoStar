package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;

public class Pilon extends EdificioProtoss {

<<<<<<< Updated upstream
=======
    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 100;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
>>>>>>> Stashed changes
    private static int SUMINISTRA = 5;
    public Pilon(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, 300, 300);
        inventario.agregarSuministro(SUMINISTRA);
        casillero.ocupar(this);
<<<<<<< Updated upstream
        inventario.subirNivelConstruccion(0);
=======
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
        inventario.agregarSuministro(SUMINISTRA);
>>>>>>> Stashed changes
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public int turnosParaConstruir() {
        return 5;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        if (!inventario.tieneRecursos(0, 100)) {
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Pilon pilon = new Pilon(casillero, inventario);
        casillero.energizarEnRango(5);
        return new EdificioEnConstruccion(pilon, casillero, inventario);
    }

    public void recibirDanio(Danio danio) throws EstaDestruido{
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.inventario.perderSuministro(SUMINISTRA);
            throw new EstaDestruido("unidad destruida");
        }
    }


}