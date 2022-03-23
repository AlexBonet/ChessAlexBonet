package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MKing;

public class BKing extends MKing {
    public BKing(Celda cell) {
        super(cell, ChessType.B_king);
        place();
    }
}

