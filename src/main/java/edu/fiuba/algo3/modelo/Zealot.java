package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.exceptions.*;

public class Zealot extends UnidadMovilProtoss {

    private static int VIDA_MAXIMA = 100;
    private static int ESCUDO_MAXIMO = 60;
    private static int DANIO_AIRE = 0;
    private static int DANIO_TIERRA = 8;
    private static int RANGO_DE_ATAQUE = 1;
    private static int COSTO_MINERAL = 100;
    private static int COSTO_GASEOSO = 0;
    private static int TURNOS_PARA_CONSTRUIR = 4;
    private static int COSTO_SUMINISTRO = 2;
    private boolean esVisible;

    public Zealot(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO, COSTO_SUMINISTRO);
        esVisible = true;
    }
    public void recibirDanio(int danio) throws UnidadInvisible,EstaDestruido {
        if(!esVisible){
            throw new UnidadInvisible("La unidad está destruida");
        }
        if (estaDestruida()){
            throw new EstaDestruido("La unidad está destruida");
        }
        vida -= danio;
        if (estaDestruida()){
            casilleroActual.desocupar();
            this.inventario.perderSuministro(COSTO_SUMINISTRO);
        }
    }
    @Override
    int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }
    public void atacar(UnidadMovil unidadAAtacar){
        if(!this.tieneEnRangoA(unidadAAtacar, RANGO_DE_ATAQUE)){
            throw new AtaqueFueraDeRango("El ataque está fuera de rango");
        }
        if(!esVisible) {
            this.esVisible = true;
        }
        if (unidadAAtacar.esVoladora()){
            unidadAAtacar.recibirDanio(DANIO_AIRE);
        }
        else{
            unidadAAtacar.recibirDanio(DANIO_TIERRA);
        }
    }
    public void volverseInvisible(){
        this.esVisible = false;
    }

    public void pasarTurno(){
        if(casilleroActual.tengoEnRangoAmoSupremo(inventario)){
            this.esVisible = true;
        }
    }
}
