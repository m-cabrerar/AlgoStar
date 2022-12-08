package edu.fiuba.algo3.modelo.unidades.edificios;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class EdificioEnConstruccion implements Unidad {
    private EdificioConcreto vaASer;
    private Casillero casillero;
    private int turnosRestantes;
    private boolean destruido;
    private Inventario inventario;
    private boolean enInventario;

    public EdificioEnConstruccion(EdificioConcreto vaASer, Casillero casillero, Inventario inventario) {
        this.vaASer = vaASer;
        this.casillero = casillero;
        this.turnosRestantes = vaASer.turnosParaConstruir();
        this.destruido = false;
        inventario.agregarEdificio(this);
        this.inventario = inventario;
        enInventario = false;
    }

    public boolean estaListo() {
        return turnosRestantes <= 0;
    }
    public void pasarTurno() {
        if (estaListo()) {
            vaASer.pasarTurno();
        } else {
            turnosRestantes--;
        }
        if (estaListo() && !enInventario ){
            vaASer.ubicarEnInventario();
            enInventario = true;
        }
    }

    public void recibirDanio(Danio danio) throws EstaDestruido {
        if (destruido){
            throw new EstaDestruido("El edificio está destruido");
        }
        if (!estaListo()) {
            casillero.desocupar();
            inventario.edificioAEliminar(this);
            destruido = true;
        } else try {
            vaASer.recibirDanio(danio);
        } catch (Exception EstaDestruido){
            inventario.edificioAEliminar(this);
        }
    }

    public boolean estaPorAca(List<Casillero> casilleros){
        return casilleros.contains(casillero);
    }

    public Integer[] obtenerPosicion() {
        return vaASer.obtenerPosicion();
    }

    public Unidad getConstruido() {
        return vaASer;
    }
    public int turnosParaConstruir() {
        return turnosRestantes;
    }

    public int getVida() {
        if (estaListo()) {
            return vaASer.getVida();
        } else {
            return 1;
        }
    }
    public int getVidaMaxima() {
        if (estaListo()) {
            return vaASer.getVidaMaxima();
        } else {
            return 1;
        }
    }
    public boolean estaDestruido() {
        return destruido;
    }
}
