package es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre;

import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Pieza;

public  abstract class MQueen extends Pieza {
    public MQueen(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }
    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements=MAlfil.getMovAsAlfil(this);
        nextMovements.addAll(MTorre.getMovAsTorre(this));

        return nextMovements;
    }
}