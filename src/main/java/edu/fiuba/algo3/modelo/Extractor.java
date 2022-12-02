package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.*;

public class Extractor extends EdificioZerg {
    private int zanganosTrabajando;
    private static int VIDA_MAXIMA = 750;
    public Extractor(Casillero casillero, Inventario inventario){
        super(casillero, inventario, VIDA_MAXIMA);
        this.zanganosTrabajando = 0;
        casillero.ocupar(this);
        inventario.subirNivelConstruccion(0);
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public int turnosParaConstruir(){
        return 6;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!inventario.tieneRecursos(100, 0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.puedeConstruir(0)){
            throw new CorrelativasInsuficientes("Aún no se puede contruir este edificio");
        }
        Extractor extractor = new Extractor(casillero, inventario);
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

    public void recibirDanio(Danio danio){
        try {
            super.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            this.casillero.desocupar();
        }
    }
}
