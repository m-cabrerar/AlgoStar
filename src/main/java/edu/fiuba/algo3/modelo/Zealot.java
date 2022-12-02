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

    private Danio danio;
    private Visibilidad visibilidad;
    private int unidadesDestruidas;

    public Zealot(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO, COSTO_SUMINISTRO);
        danio = new Danio(DANIO_AIRE, DANIO_TIERRA);
        superficie = new Tierra();
        visibilidad = new Visible();
        unidadesDestruidas = 0;
    }
    public void recibirDanio(Danio danioRecibido) throws EstaDestruido {
        Danio danioARecibir = visibilidad.danioARecibir(danioRecibido);
        try {
            super.recibirDanio(danioARecibir);
        } catch (Exception EstaDestruido){
            throw new EstaDestruido("Unidad destruida");
        }
    }
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    public void atacar(Unidad unidadAAtacar){
        try{
            super.atacar(unidadAAtacar, RANGO_DE_ATAQUE, danio);
            this.visibilizar();
        } catch (Exception EstaDestruido){
            unidadesDestruidas+=1;
        }
    }
    private void invisibilizar(){
        this.visibilidad = new Invisible();
    }
    private void visibilizar(){
        visibilidad = new Visible();
    }
    public void pasarTurno(){
        if(unidadesDestruidas>=3){
            this.invisibilizar();
        }
        if(casillero.casilleroQuitaInvisibilidad()){
            this.visibilizar();
        }
    }

    @Override
    public void ubicarEn(Casillero casillero){
        this.casillero = casillero;
        casillero.ocupar(this);
    }
}
