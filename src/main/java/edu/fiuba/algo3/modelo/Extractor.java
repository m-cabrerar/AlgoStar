package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.ExtractorError;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public class Extractor extends EdificioZerg {
    private int zanganosTrabajando;
    public Extractor(Casillero casillero, Inventario inventario){
        super(casillero, inventario, 750);
        this.zanganosTrabajando = 0;
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public int turnosParaConstruir(){
        return 6;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!casillero.esDelTipo(new NodoGas())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(100, 0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        EdificioConcreto extractor = new Extractor(casillero, inventario);
        return new EdificioEnConstruccion(extractor, casillero, inventario);
    }
    public void extraerGas(Inventario inventario) throws ExtractorError {
        if (zanganosTrabajando > 0) {
            inventario.agregarGas(10 * zanganosTrabajando);
        } else {
            throw new ExtractorError("El extractor no tiene zanganos trabajando");
        }
    }
    public void agregarZangano() throws ExtractorError {
        if(zanganosTrabajando < 3) {
            this.zanganosTrabajando += 1;
        } else {
            throw new ExtractorError("El extractor ya tiene 3 zanganos trabajando");
        }
    }
}
