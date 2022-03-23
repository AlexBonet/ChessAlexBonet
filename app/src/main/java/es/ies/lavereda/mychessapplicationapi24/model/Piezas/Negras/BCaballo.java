package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MCaballo;

public class BCaballo extends MCaballo {
    public BCaballo(Celda cell) {
        super(cell, ChessType.B_caballo);
        place();
    }
}
