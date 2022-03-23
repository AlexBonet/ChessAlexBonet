package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MTorre;

public class BTorre extends MTorre {
    public BTorre(Celda cell) {
        super(cell, ChessType.B_torre);
        place();
    }
}