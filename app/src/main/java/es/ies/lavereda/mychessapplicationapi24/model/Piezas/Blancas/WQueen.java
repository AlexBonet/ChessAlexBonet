package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MQueen;

public class WQueen extends MQueen {
    public WQueen(Celda cell) {
        super(cell, ChessType.W_queen);
        place();
    }
}