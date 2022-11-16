package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.EstaDestruido;

public class EdificioEnConstruccion implements Edificio {
    private Edificio vaASer;
    private Casillero casillero;
    private int turnosRestantes;
    //private Inventario inventario;
    private boolean destruido;
    public EdificioEnConstruccion(EdificioConcreto vaASer, Casillero casillero, Inventario inventario) {
        this.vaASer = vaASer;
        this.casillero = casillero;
        this.turnosRestantes = vaASer.turnosParaConstruir();
        casillero.ocupar();
        this.destruido = false;
    }

    private boolean estaListo() {
        return turnosRestantes <= 0;
    }
    public void pasarTurno() {
        if (estaListo()) {
            vaASer.pasarTurno();
        } else {
            turnosRestantes--;
        }
    }

    public void recibirDanio(int danio) throws EstaDestruido {

        if (!estaListo()) {
            casillero.desocupar();
            destruido = true;
        } else {
            vaASer.recibirDanio(danio);
        }
        if (destruido){
            throw new EstaDestruido("El edificio esta destruido");
        }
    }
}