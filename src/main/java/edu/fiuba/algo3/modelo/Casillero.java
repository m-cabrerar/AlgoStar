package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;

import java.util.*;

public class Casillero{
    private TipoCasillero tipoCasillero;
    private int energia;
    private int coordenadaX;
    private int coordenadaY;
    private boolean estaOcupado;
    private int turno;

    public Casillero(int unaCoordenadaX, int unaCoordenadaY) {
        this.energia = 0;
        this.coordenadaX = unaCoordenadaX;
        this.coordenadaY = unaCoordenadaY;
        this.turno = 0;
        this.estaOcupado = false;
        this.tipoCasillero = new CasilleroVacio();
    }
    public void setTipoCasillero(TipoCasillero unTipoCasilleroNuevo){
        tipoCasillero = unTipoCasilleroNuevo;
    }

    public boolean sonDelMismoTipoDeCasillero(Casillero unCasillero){
        return (this.suTipoDeCasillero().equals(unCasillero.suTipoDeCasillero()));
    }
    public String suTipoDeCasillero(){
        return tipoCasillero.nombreDelCasillero();
    }

    public boolean esDelTipo(TipoCasillero unTipoCasillero){
        return this.suTipoDeCasillero().equals(unTipoCasillero.nombreDelCasillero());}

    public boolean tieneEnergia(){
        return this.energia > 0;
    }
    public void energizar(){
        this.energia += 1;
    }

    public void desenergizar(){
        this.energia -= 1;
    }

    public void pasarTurno(int turnoActual, Mapa mapa){
        if(this.turno == turnoActual){ //ya la visite y/o la cambie
            return;
        }
        this.turno = turnoActual;
        List<Casillero> adyacentesVisitados = this.visitarAdyacentes(turnoActual,mapa);
        this.tipoCasillero.expandirMoho(adyacentesVisitados);
    }

    public int extraerMineral(int cantidad) {
        return this.tipoCasillero.extraerMineral(cantidad);
    }
    public int extraerGas(int cantidad) {
        return this.tipoCasillero.extraerGas(cantidad);
    }
    public boolean estaOcupado(){
        return this.estaOcupado;
    }

    public void ocupar() throws UbicacionInvalida {
        if(this.estaOcupado()){
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.estaOcupado = true;
    }

    public void desocupar(){
        this.estaOcupado = false;
    }
    public List<Casillero> visitarAdyacentes(int turnoActual, Mapa mapa){
        //Devuelve una lista con los adyacentes a la casilla que visita.
        List<Casillero> adyacentes = mapa.CasillerosAdyacentes(this.coordenadaX,this.coordenadaY);
        for (Casillero casillero : adyacentes) {
            casillero.turno = turnoActual;
        }
        return adyacentes;
    }
    //cosas para refactor------------------------------------
    public int posicionX(){
        return this.coordenadaX;
    }
    public int posicionY(){
        return this.coordenadaY;
    }

    public void energizarEnRango(int i) {
    }
}