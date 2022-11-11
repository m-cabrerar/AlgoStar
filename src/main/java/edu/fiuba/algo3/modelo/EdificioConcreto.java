package edu.fiuba.algo3.modelo;

abstract class EdificioConcreto implements Edificio {
    private int vida;

    abstract public void pasarTurno();

    public void recibirDanio(int danio) {
        vida -= danio;
    }
    public EdificioEnConstruiccion construir(casillero, inventario) {
        if (!this.tieneMateriales(inventario)) {
            throw new Exception("Materiales insuficientes");
        }
        if (!this.tieneCorrelativas(inventario)) {
            throw new Exception("Correlativas insuficientes");
        }
        if (!casillero.puedeConstruir(this)) {
            throw new Exception("Ubicacion invalida");
        }
        this.consumirMateriales(inventario);
        return new EdificioEnConstruiccion(this, casillero, inventario);
    }
}
