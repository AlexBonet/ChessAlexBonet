package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MTorre;

public class WTorre extends MTorre {
    public WTorre(Celda cell) {
        super(cell, ChessType.W_torre);
        place();
    }
}