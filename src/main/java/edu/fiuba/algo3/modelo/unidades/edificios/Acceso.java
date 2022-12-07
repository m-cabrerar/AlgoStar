package edu.fiuba.algo3.modelo.unidades.edificios;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.moviles.Dragon;
import edu.fiuba.algo3.modelo.unidades.moviles.Zealot;

public class Acceso extends EdificioProtoss {

    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 150;
    private static int TURNOS_PARA_CONSTRUIR = 8;
    private static int VIDA = 500;
    private static int ESCUDO = 500;
    private static final int NIVEL_DE_CONSTRUCCION = 1;
    private static final int NIVEL_DE_CONSTRUCCION_REQUERIDO = 0;
    private boolean estaEvolucionando;
    private UnidadEnCreacion unidadEnCreacion;
    public Acceso(Casillero unCasillero, Inventario unInventario) {
        super(unCasillero, unInventario, VIDA, ESCUDO);
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO, COSTO_MINERAL);
        this.estaEvolucionando = false;
        this.unidadEnCreacion = null;
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
    }

    public void pasarTurno() {
        super.pasarTurno();
        if(estaEvolucionando){
            unidadEnCreacion.pasarTurno();
            this.estaEvolucionando = unidadEnCreacion.estaListo();
            //acaba habria que chequear que si el casillero que da al obtener adyacentes es nulo (porque no hay ninguno libre)
        }
    }

    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario){
        if(!casillero.tieneEnergia()){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(NIVEL_DE_CONSTRUCCION_REQUERIDO)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Acceso acceso = new Acceso(casillero, inventario);
        return new EdificioEnConstruccion(acceso, casillero, inventario);
    }
    public static int getNivelDeConstruccionRequerido(){
        return NIVEL_DE_CONSTRUCCION_REQUERIDO;
    }

    public void engendrarZealot(){
        Zealot zealot = new Zealot(inventario);
        this.unidadEnCreacion = new UnidadEnCreacion(this.casillero.obtenerAdyacente(), this.inventario, zealot);
        this.estaEvolucionando = true;
    }

    public void engendrarDragon(){
        Dragon dragon = new Dragon(inventario);
        this.unidadEnCreacion = new UnidadEnCreacion(this.casillero.obtenerAdyacente(), this.inventario, dragon);
        this.estaEvolucionando = true;
    }


}
