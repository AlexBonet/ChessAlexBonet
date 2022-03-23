package es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Pieza;

public abstract class MPeon  extends Pieza{
    public MPeon(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    public boolean moveTo(Coordenada c){
        super.moveTo(c);
        if (c.getNum()==1 || c.getNum()==8){
            createReina();
            return  true;
        }else
            return false;
    }

    protected abstract void createReina();
}
