package edu.fiuba.algo3.modelo;

abstract class EdificioConcreto implements Edificio {
    protected int vida;
    protected TipoCasillero casillero;
    public EdificioConcreto(TipoCasillero unCasillero, Inventario unInventario, int vidaInicial){
        this.casillero = unCasillero;
        unCasillero.ocupar();
        unInventario.agregar(this);
        this.vida = vidaInicial;
    }
    abstract int turnosParaConstruir();
    protected boolean estaDestruido() {
        return vida <= 0;
    }
    public void recibirDanio(int danio) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("El edificio está destruido");
        }
        vida -= danio;
        if (estaDestruido()){
            casillero.desocupar();
        }
    }
    private void consumirMateriales(Inventario inventario) {
    }
    private boolean tieneCorrelativas(Inventario inventario) {
        return true;
    }
    private boolean tieneMateriales(Inventario inventario) {
        return true;
    }

}
