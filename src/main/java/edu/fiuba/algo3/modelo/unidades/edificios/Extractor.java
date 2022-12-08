package edu.fiuba.algo3.modelo.unidades.edificios;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;

public class Extractor extends EdificioZerg {

    private static int COSTO_GASEOSO = 0;
    private static int COSTO_MINERAL = 100;
    private static int TURNOS_PARA_CONSTRUIR = 6;
    private static final int NIVEL_DE_CONSTRUCCION = 0;
    private static final int NIVEL_DE_CONSTRUCCION_REQUERIDO = 0;
    private int zanganosTrabajando;
    private static int VIDA = 750;
    public Extractor(Casillero casillero, Inventario inventario){
        super(casillero, inventario, VIDA);
        this.zanganosTrabajando = 0;
        casillero.ocupar(this);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
    }
    public void ubicarEnInventario(){
        inventario.subirNivelConstruccion(NIVEL_DE_CONSTRUCCION);
    }

    public void pasarTurno(){
        super.pasarTurno();
        extraerGas();
    }
    public int turnosParaConstruir(){
        return TURNOS_PARA_CONSTRUIR;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!inventario.tieneRecursos(COSTO_GASEOSO, COSTO_MINERAL)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Extractor extractor = new Extractor(casillero, inventario);
        return new EdificioEnConstruccion(extractor, casillero, inventario);
    }
    public int extraerGas() {
        int cantidad = zanganosTrabajando * 10;
        casillero.extraerGas(cantidad);
        this.inventario.agregarGas(cantidad);
        return cantidad;
    }
    public void agregarZangano() throws ExtractorError {
        if(zanganosTrabajando < 3) {
            this.zanganosTrabajando += 1;
        } else {
            throw new ExtractorError("El extractor ya tiene 3\n zanganos trabajando");
        }
    }
    public static int getNivelDeConstruccionRequerido() {
        return NIVEL_DE_CONSTRUCCION_REQUERIDO;
    }
}
