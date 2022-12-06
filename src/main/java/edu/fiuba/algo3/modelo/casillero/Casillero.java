package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.Asimilador;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

import java.util.*;

public class Casillero{
    private TipoCasillero tipoCasillero;
    private int energia;

    private boolean quitarInvisibilidad;
    private int coordenadaX;
    private int coordenadaY;
    private boolean estaOcupado;
    private int turno;
    private Mapa mapa;

    public Casillero(int unaCoordenadaX, int unaCoordenadaY,Mapa mapa) {
        this.energia = 0;
        this.coordenadaX = unaCoordenadaX;
        this.coordenadaY = unaCoordenadaY;
        this.turno = 0;
        this.estaOcupado = false;
        this.tipoCasillero = new CasilleroVacio();
        this.mapa = mapa;
        this.quitarInvisibilidad = false;
    }

    public void setTipoCasillero(TipoCasillero unTipoCasilleroNuevo){
        tipoCasillero = unTipoCasilleroNuevo;
    }
    public TipoCasillero getTipo(){
        return tipoCasillero;
    }
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
        if(this.turno == turnoActual){ //ya la visite en este turno
            return;
        }
        this.turno = turnoActual;
        List<Casillero> adyacentesVisitados = this.visitarAdyacentes(turnoActual,mapa);
        this.tipoCasillero.expandirMoho(adyacentesVisitados);
        this.quitarInvisibilidad = false;
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

    public void desocupar() {
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

    public boolean tieneEnRango(Unidad unidadAAtacar, int rango){
        List<Casillero> casilleros = mapa.casillerosEnRango(coordenadaX,coordenadaY,rango);
        //si el casillero de unidadAAtacar esta en la lista de casilleros, entonces esta en rango
        for (Casillero casillero : casilleros) {
            if(unidadAAtacar.estaPorAca(casilleros)){
                return true;
            }
        }
        return false;
    }

    public Casillero obtenerAdyacente(){
        List<Casillero> casilleros = mapa.CasillerosAdyacentes(coordenadaX, coordenadaY);
        for(Casillero casillero : casilleros){
            if(!casillero.estaOcupado()){
                return casillero;
            }
        }
        return null;
    }
    public void quitarInvisibilidadEnRango(int rango){
        List<Casillero> casilleros = mapa.casillerosEnRango(coordenadaX,coordenadaY,rango);
        //si el casillero de unidadAAtacar esta en la lista de casilleros, entonces esta en rango
        for (Casillero casillero : casilleros) {
            casillero.quitarInvisibilidad();
        }
        this.quitarInvisibilidad();
    }

    public void quitarInvisibilidad(){
        this.quitarInvisibilidad = true;
    }

    public boolean casilleroQuitaInvisibilidad(){
        return this.quitarInvisibilidad;
    }


    //METODOS PARA DOUBLE DISPATCH ---------------------------------------------------------------
    public void ocupar(Unidad unidad){
        if(this.estaOcupado()){
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(unidad);
        this.estaOcupado = true;
    }
    public void ocupar(UnidadMovil unidad){
        if(this.estaOcupado()){
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(unidad);
        this.estaOcupado = true;
    }
    public void ocupar(Extractor extractor) {
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(extractor);
        this.estaOcupado = true;
    }
    public void ocupar(Asimilador asimilador){
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(asimilador);
        this.estaOcupado = true;
    }

    public void ocupar(NexoMineral nexo){
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(nexo);
        this.estaOcupado = true;
    }

    public void ocupar(Criadero criadero){
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(criadero);
        this.estaOcupado = true;
    }
}