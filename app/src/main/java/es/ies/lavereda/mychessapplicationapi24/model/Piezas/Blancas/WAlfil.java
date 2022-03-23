package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MAlfil;

public class WAlfil extends MAlfil {

    public WAlfil(Celda cell) {
        super(cell, ChessType.W_alfil);
        place();
    }
}
