package edu.fiuba.algo3.modelo;

abstract class EdificioConcreto implements Edificio {
    private int vida;
    private Casillero casilleroCompatible;
    abstract public void pasarTurno();

    public void recibirDanio(int danio) {
        vida -= danio;
    }
    public EdificioEnConstruiccion construir(Casillero casillero,Inventario inventario) {
        if (!this.tieneMateriales(inventario)) {
            throw new Exception("Materiales insuficientes");
        }
        if (!this.tieneCorrelativas(inventario)) {
            throw new Exception("Correlativas insuficientes");
        }
        if (!casillero.puedeConstruir(this)) {
            throw new Exception("Ubicacion invalida");

        }
        //alt:
        if(casillero.sonDelMismoTipoDeCasillero(casilleroCompatible)){
            throw new Exception("Ubicacion invalida");
        }
        //fin alt.

        this.consumirMateriales(inventario);
        return new EdificioEnConstruiccion(this, casillero, inventario);
    }


}
