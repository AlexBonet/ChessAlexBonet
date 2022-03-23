package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MKing;

public class WKing extends MKing {
    public WKing(Celda cell) {
        super(cell, ChessType.W_king);
        place();
    }

}
