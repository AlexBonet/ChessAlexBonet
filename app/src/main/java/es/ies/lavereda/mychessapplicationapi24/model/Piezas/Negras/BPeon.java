package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras;

import java.util.ArrayList;
import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MPeon;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

public class BPeon extends MPeon {
    public BPeon(Celda cell) {
        super(cell, ChessType.B_peon);
        place();
    }

    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements = new ArrayList<>();
        TableroChess board = celda.getTablero();
        Coordenada position = celda.getCoordenada();
        Coordenada aux;

        //Opciones
        //Avance 1
        aux=position.coorBot();
        if (canMoveTo(aux) && !esRival(aux))
            nextMovements.add(aux);

        //Avance 2
        if (position.getNum()==2) {
            aux = position.coorBot().coorBot();
            if (canMoveTo(aux))
                nextMovements .add(aux);
        }

        //KILL der
        aux=position.diagonalBotRight();
        if (!estaLibre(aux) && esRival(aux))
            nextMovements.add(aux);

        //KILL izq
        aux=position.diagonalBotLeft();
        if (!estaLibre(aux) && esRival(aux))
            nextMovements.add(aux);

        return nextMovements;
    }

    @Override
    protected void createReina() {
        TableroChess board= celda.getTablero();
        board.getStore4InBoard().remove(this);
        celda.setPieza(null);
        celda.setPieza(new BQueen(celda));
        board.getStore4InBoard().add(this);
    }
}
