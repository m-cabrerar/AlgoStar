package edu.fiuba.algo3.modelo;

public class EdificioEnConstruccion implements Edificio {
    private Edificio vaASer;
    private Casillero casillero;
    private int turnosRestantes;
    private Inventario inventario;

    public EdificioEnConstruccion(Edificio vaASer, Casillero casillero, Inventario inventario) {
        this.vaASer = vaASer;
        this.casillero = casillero;
        this.turnosRestantes = vaASer.turnosParaConstruir();
        casillero.ocupar();
    }

    public void pasarTurno() {
        turnosRestantes--;
    }

    public void recibirDanio(int danio) {
        casilla.desocupar();
    }
}
