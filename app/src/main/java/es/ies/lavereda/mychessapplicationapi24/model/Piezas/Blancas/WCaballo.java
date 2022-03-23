package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MCaballo;

public class WCaballo extends MCaballo {
    public WCaballo(Celda cell) {
        super(cell, ChessType.W_caballo);
        place();
    }

}
