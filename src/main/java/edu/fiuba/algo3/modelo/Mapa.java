package edu.fiuba.algo3.modelo;
import java.util.*;

public class Mapa {
    public int anchoMapa;
    public int altoMapa;
    private List<List<Casillero>> tableroActual;
    private int tiempoVida;
    public Mapa( int alto, int ancho){
        this.anchoMapa = ancho;
        this.altoMapa = alto;
        this.tableroActual = crearTablero(alto,ancho);
        this.tiempoVida = 0;
    }

    private List<List<Casillero>> crearTablero(int alto, int ancho){
            List<List<Casillero>> tablero = new ArrayList<>();
            for (int i = 0; i < ancho; i++)  {
                tablero.add(new ArrayList<>());
                for (int j = 0; j < alto; j++) {
                    tablero.get(i).add(new Casillero(i,j));
                }
            }
        return tablero;
        }

    public void cambiarTipoCasilla(int x, int y, TipoCasillero tipoCasillero){
        obtenerCasillero(x,y).setTipoCasillero(tipoCasillero);
    }

    public List<Casillero> CasillerosAdyacentes(int x,int y){
        if (!this.enRango(x,y)){
            return null;
        }
        List<Casillero> adyacentes = new ArrayList<>();
        if (this.enRango(x-1,y)){adyacentes.add(obtenerCasillero(x-1,y));}
        if (this.enRango(x+1,y)){adyacentes.add(obtenerCasillero(x+1,y));}
        if (this.enRango(x,y-1)){adyacentes.add(obtenerCasillero(x,y-1));}
        if (this.enRango(x,y+1)){adyacentes.add(obtenerCasillero(x,y+1));}
        return adyacentes;
    }
    public List<Casillero> casillerosEnRango(int xInicial,int yInicial, int rango){
        List<Casillero> casillerosEnRango = new ArrayList<>();
        casillerosEnRango.add(obtenerCasillero(xInicial,yInicial));

        for (int i = 0; i < rango; i++) {
            for (ListIterator<Casillero> casilleros = casillerosEnRango.listIterator(); casilleros.hasNext();) {
                Casillero casillero = casilleros.next();
                int x = casillero.posicionX();
                int y = casillero.posicionY();
                if (this.enRango(x-1,y) && !casillerosEnRango.contains(obtenerCasillero(x-1,y))){
                    casilleros.add(obtenerCasillero(x-1,y));}

                if (this.enRango(x+1,y) && !casillerosEnRango.contains(obtenerCasillero(x+1,y))){
                    casilleros.add(obtenerCasillero(x+1,y));}

                if (this.enRango(x,y-1) && !casillerosEnRango.contains(obtenerCasillero(x,y-1))){
                    casilleros.add(obtenerCasillero(x,y-1));}

                if (this.enRango(x,y+1) && !casillerosEnRango.contains(obtenerCasillero(x, y+1))){
                    casilleros.add(obtenerCasillero(x,y+1));}
            }
        }
        return casillerosEnRango;
    }

    public boolean enRango(int x, int y){
        ///Devuelve true si no se exceden las medidas del mapa
        return ((0 <= x) && (x < this.anchoMapa)) && ((0 <= y) && (y < this.altoMapa));
    }
    public void pasarTurno(){
        this.tiempoVida += 1;
        for (List<Casillero> listaCasilleros : this.tableroActual){
            for (Casillero casillero : listaCasilleros){
                casillero.pasarTurno(tiempoVida,this);
            }
        }
    }

    public void energizar(int x, int y ,int rango) {
        List<Casillero> casillerosEnRango = casillerosEnRango(x, y, rango);
        for(Casillero casillero : casillerosEnRango) {
            casillero.energizar();
        }
    }
    public void desenergizar(int x, int y ,int rango){
        List<Casillero> casillerosEnRango = casillerosEnRango(x,y,rango);
        for (Casillero casillero : casillerosEnRango) {
            casillero.desenergizar();
        }
    }

    public Casillero obtenerCasillero(int x, int y){
        return this.tableroActual.get(x).get(y);
    }
}