package es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas;

import java.util.ArrayList;
import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre.MPeon;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

public class WPeon extends MPeon {
    public WPeon(Celda cell) {
        super(cell, ChessType.W_peon);
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
        aux=position.coorTop();
        if (canMoveTo(aux) && !esRival(aux))
            nextMovements.add(aux);

        //Avance 2
        if (position.getNum()==7) {
            aux = position.coorTop().coorTop();
            if (canMoveTo(aux))
                nextMovements.add(aux);
        }

        //KILL der
        aux=position.diagonalTopRight();
        if (!estaLibre(aux) && esRival(aux))
            nextMovements.add(aux);

        //KILL izq
        aux=position.diagonalTopLeft();
        if (!estaLibre(aux) && esRival(aux))
            nextMovements.add(aux);

        return nextMovements;
    }

    @Override
    protected void createReina() {
        TableroChess board= celda.getTablero();
        board.getStore4InBoard().remove(this);
        celda.setPieza(null);
        celda.setPieza(new WQueen(celda));
//        board.getStore4InBoard().add(this);
    }
}
