package edu.fiuba.algo3.modelo.casillero;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.unidades.*;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;

import java.util.*;

public class Casillero{
    private TipoCasillero tipoCasillero;
    private int energia;

    private boolean quitarInvisibilidad;
    private int coordenadaX;
    private int coordenadaY;
    private boolean estaOcupado;
    int turno;
    private Mapa mapa;

    public Casillero(int unaCoordenadaX, int unaCoordenadaY,Mapa mapa) {
        this.energia = 0;
        this.coordenadaX = unaCoordenadaX;
        this.coordenadaY = unaCoordenadaY;
        this.estaOcupado = false;
        this.tipoCasillero = new CasilleroVacio();
        this.mapa = mapa;
        this.turno = 0;
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
    public void dejarSinEnergia(){this.energia = 0;}

    public void pasarTurno(int turnoActual){
        if(this.turno == turnoActual){
            return;
        }
        List<Casillero> adyacentesVisitados = mapa.CasillerosAdyacentes(this.coordenadaX,this.coordenadaY);
        (this.tipoCasillero).expandirMoho(adyacentesVisitados, turnoActual);
        this.quitarInvisibilidad = false;
    }


    public void volverseMoho(int turnoDeExpansion){
        (this.tipoCasillero).volverseMoho(this, turnoDeExpansion);
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
    //cosas para refactor------------------------------------
    public int posicionX(){
        return this.coordenadaX;
    }
    public int posicionY(){
        return this.coordenadaY;
    }

    public void energizarEnRango(int i) {
        this.mapa.energizar(this.coordenadaX,this.coordenadaY,i);
    }


    //PARA CONOCER RANGO DE ATAQUES
    public boolean tieneEnRango(Unidad unidadAAtacar, int rango){
        List<Casillero> casilleros = mapa.casillerosEnRango(coordenadaX,coordenadaY,rango);
        //si el casillero de unidadAAtacar esta en la lista de casilleros, entonces esta en rango
        if(unidadAAtacar.estaPorAca(casilleros)){
            return true;
        }
        return false;
    }

    //PARA LA UBICACION DE UNIDADES CREADAS
    public Casillero obtenerAdyacente(){
        List<Casillero> casilleros = mapa.casillerosEnRango(coordenadaX, coordenadaY,3);
        List<Casillero> casillerosLibres = new ArrayList<>();
        for(Casillero casillero : casilleros){
            if(!casillero.estaOcupado() && (!(casillero.getTipo() instanceof CasilleroEspacial))){
                casillerosLibres.add(casillero);
            }
        }
        return casillerosLibres.get(0);
    }

    //MANEJO DE UNIDAD INVISIBLE
    public List<Casillero> obtenerAdyacentes(){
        return mapa.CasillerosAdyacentes(coordenadaX, coordenadaY);
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

    public void ocupar(ReservaDeReproduccion reserva){
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(reserva);
        this.estaOcupado = true;
    }

    public void ocupar(Guarida guarida){
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(guarida);
        this.estaOcupado = true;
    }

    public void ocupar(Espiral espiral){
        if (this.estaOcupado()) {
            throw new UbicacionInvalida("Casillero Ocupado");
        }
        this.tipoCasillero.ocupar(espiral);
        this.estaOcupado = true;
    }

}