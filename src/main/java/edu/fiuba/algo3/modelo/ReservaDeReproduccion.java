package edu.fiuba.algo3.modelo;

public class ReservaDeReproduccion extends EdificioZerg {

    public ReservaDeReproduccion(Casillero casillero, Inventario inventario){
        super(casillero, inventario,1000);
    }
    public void pasarTurno(){
        super.pasarTurno();
    }
    public int turnosParaConstruir(){
        return 12;
    }
    public static EdificioEnConstruccion construir(Casillero casillero, Inventario inventario) throws UbicacionInvalida, RecursosInsuficientes {
        // hacer checkeos de casilla y materiales
        if(!casillero.sonDelMismoTipoDeCasillero(new Moho())){
            throw new UbicacionInvalida("Ubicacion invalida");
        }
        if(!inventario.tieneRecursos(150,0)){
            throw new RecursosInsuficientes("No tiene recursos");
        }
        EdificioConcreto reserva = new ReservaDeReproduccion(casillero, inventario);
        return new EdificioEnConstruccion(reserva, casillero, inventario);
    }
}

