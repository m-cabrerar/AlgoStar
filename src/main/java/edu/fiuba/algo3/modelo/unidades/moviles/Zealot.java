package edu.fiuba.algo3.modelo.unidades.moviles;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.unidades.Danio;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.Unidad;

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

    private Visibilidad visibilidad;
    private int unidadesDestruidas;

    public Zealot(Inventario inventario){
        super(inventario, COSTO_MINERAL, COSTO_GASEOSO, VIDA_MAXIMA, ESCUDO_MAXIMO, COSTO_SUMINISTRO);
        inventario.pagarMateriales(COSTO_GASEOSO,COSTO_MINERAL);
        superficie = new Tierra();
        visibilidad = new Visible();
        unidadesDestruidas = 0;
        this.rangoDeAtaque = RANGO_DE_ATAQUE;
        this.danio = new Danio(DANIO_AIRE,DANIO_TIERRA);
    }
    public void recibirDanio(Danio danio) throws EstaDestruido {
        Danio danioARecibir = visibilidad.danioARecibir(danio);
        try {
            super.recibirDanio(danioARecibir);
        } catch (Exception EstaDestruido){
            this.inventario.unidadAEliminar(this);
            this.inventario.devolverSuministrosUnidad(COSTO_SUMINISTRO);
            throw new EstaDestruido("Unidad destruida");
        }
    }
    public int turnosParaConstruir() {
        return TURNOS_PARA_CONSTRUIR;
    }

    private void invisibilizar(){
        this.visibilidad = new Invisible();
    }
    private void visibilizar(){
        this.visibilidad = new Visible();
    }
    public void pasarTurno(){
        super.pasarTurno();
        if(unidadesDestruidas>=3){
            this.invisibilizar();
        }
        if(casillero.casilleroQuitaInvisibilidad()){
            this.visibilizar();
        }
    }

    @Override
    public void ubicarEn(Casillero casillero){
        super.ubicarEn(casillero);
    }

    @Override
    public void atacar(Unidad unidadAAtacar) {
        if(!this.esVisible()){
            this.visibilizar();
            unidadesDestruidas=0;
        }
        super.atacar(unidadAAtacar);
        if (unidadAAtacar.estaDestruido()){
            unidadesDestruidas++;
        }
    }

    public boolean esVisible(){
        return visibilidad.esVisible();
    }
}
