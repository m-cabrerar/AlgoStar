package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;

public class Pilon extends EdificioProtoss {

    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 100;
    private static int VIDA = 300;
    private static int ESCUDO = 300;
    private static int TURNOS_PARA_CONSTRUIR = 5;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    private static final int NIVEL_DE_CONSTRUCCION_REQUERIDO = 0;
    private static int SUMINISTRA = 5;
    public Pilon(Casillero casillero, Inventario inventario) {
        super(casillero, inventario, VIDA, ESCUDO);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
        inventario.agregarSuministro(SUMINISTRA);
        casillero.energizarEnRango(5);
    }

    public void pasarTurno() {
        super.pasarTurno();
    }

    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) {
        if (!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)) {
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Pilon pilon = new Pilon(casillero, inventario);
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
    public static int getNivelDeConstruccionRequerido() {
        return NIVEL_DE_CONSTRUCCION_REQUERIDO;
    }

}