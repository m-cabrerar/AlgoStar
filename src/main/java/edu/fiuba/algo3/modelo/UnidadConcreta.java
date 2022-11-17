package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

public abstract class UnidadConcreta implements Unidad{
    protected int vida;
    protected Casillero casillero;

    public UnidadConcreta(Casillero unCasillero, Inventario unInventario, int vidaInicial) throws UbicacionInvalida {
        this.casillero = unCasillero;
        unCasillero.ocupar();
        unInventario.agregar(this);
        this.vida = vidaInicial;
    }
    abstract int turnosParaConstruir();
    protected boolean estaDestruido() {
        return vida <= 0;
    }

    public void recibirDanio(int danioTierra, int danioAire) throws EstaDestruido {
        if (estaDestruido()){
            throw new EstaDestruido("Esta unidad fue destruida");
        }
        vida -= danioTierra;
        if (estaDestruido()){
            casillero.desocupar();
        }
    }
    public boolean puedeVolar(){
        return false;
    }

    public void atacar(Unidad unidadAAtacar,int danioAire, int danioTierra){

        unidadAAtacar.recibirDanio(danioTierra,danioAire);
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
