package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MQueen;

public class BQueen extends MQueen {
    public BQueen(Celda cell) {
        super(cell, ChessType.B_queen);
        place();
    }
}