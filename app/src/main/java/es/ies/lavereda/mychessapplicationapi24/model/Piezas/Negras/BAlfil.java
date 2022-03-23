package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MAlfil;

public class BAlfil extends MAlfil {
    public BAlfil(Celda cell) {
        super(cell, ChessType.B_alfil);
        place();
    }
}