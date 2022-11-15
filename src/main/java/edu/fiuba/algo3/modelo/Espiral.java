package edu.fiuba.algo3.modelo;

public class Espiral extends EdificioZerg {

    public Espiral(Casillero casillero, Inventario inventario){
        super(casillero, inventario, 1300);
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public int turnosParaConstruir(){
        return 10;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!casillero.sonDelMismoTipoDeCasillero(new Moho())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(150,100)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        if(!inventario.tieneGuarida()){
            throw new UbicacionInvalida("Aun no se puede construir este edificio");
        }
        EdificioConcreto espiral = new Espiral(casillero, inventario);
        return new EdificioEnConstruccion(espiral, casillero, inventario);
    }

}
