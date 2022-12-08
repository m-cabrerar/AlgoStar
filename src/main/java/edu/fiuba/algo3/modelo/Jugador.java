package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.unidades.edificios.Criadero;
import edu.fiuba.algo3.modelo.unidades.edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.moviles.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.edificios.Pilon;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Jugador {
    private /*final*/ String nombre;
    private  String color;
    private  String raza;
    private final Inventario inventario;
    public Jugador(String nombre, String color, String raza) {
        this.inventario = new Inventario();
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }
    public static boolean nombreValido(String nombre_, Jugador[] jugadores){
        if (nombre_.length() < 6){
            return false;
        }
        for (Jugador jugador : jugadores) {
            if (jugador != null && jugador.nombre.equals(nombre_)) {
                return false;
            }
        }
        return true;
    }

    public static boolean colorValido(String color_, Jugador[] jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador != null && jugador.color.equals(color_)) {
                return false;
            }
        }
        return true;
    }

    public static boolean razaValida(String raza_, Jugador[] jugadores){
        if (!raza_.equals("Protoss") && !raza_.equals("Zerg")) {
            return false;
        }
        for (Jugador jugador : jugadores) {
            if (jugador != null && jugador.raza.equals(raza_)) {
                return false;
            }
        }
        return true;
    }

    public boolean tieneEdificios(){
       return inventario.tieneEdificios();
    }

    public String getNombreYRaza(){
       return nombre + " " + raza;
    }

    //todo: como hacer para no explotar de metodos, por ahora para tdd
    public void construirPilon(Casillero unCasillero){
        Unidad pilon = new Pilon(unCasillero, inventario);
    }
    public void construirExtractor(Casillero unCasillero){
        Unidad extractor = new Extractor(unCasillero, inventario);
    }
    public void crearHidralisco(){
        Hidralisco hidralisco = new Hidralisco(inventario);
    }
    public void pasarTurno(){
        inventario.pasarTurno();
    }
    public Inventario getInventario(){
        return inventario;
    }

    public String getColor() {
        return color;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRaza() {
        return raza;
    }

    public EdificioEnConstruccion crearBase(Casillero casillero) {
        if (raza.equals("Protoss")){
            inventario.agregarMineral(100);
            return Pilon.construir(casillero, inventario);
        }
        inventario.agregarMineral(200);
        return Criadero.construir(casillero, inventario);
    }
}
