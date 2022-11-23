package edu.fiuba.algo3.modelo;

public class Jugador {
    private final String nombre;
    private final String color;
    private final String raza;
    private final Inventario inventario;

    public Jugador(String nombre_, String color_ , String raza_){
        nombre = nombre_;
        color = color_;
        raza = raza_;
        inventario = new Inventario();
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
}
