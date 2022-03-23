package es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre;

import java.util.ArrayList;
import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Pieza;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

public abstract class MCaballo extends Pieza {
    public MCaballo(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements = new ArrayList<>();
        TableroChess board = celda.getTablero();
        Coordenada position = celda.getCoordenada();
        Coordenada aux;


        //TopTopLeft
        aux = position.coorTop().diagonalTopLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //TopTopRight
        aux = position.coorTop().diagonalTopRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //BotBotLeft
        aux = position.coorBot().diagonalBotLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //BotBotRight
        aux = position.coorBot().diagonalBotRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //LeftLeftTop
        aux = position.coorLeft().diagonalTopLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //LeftLeftBot
        aux = position.coorLeft().diagonalBotLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //RightRightBot
        aux = position.coorRigth().diagonalBotRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //RightRightTop
        aux = position.coorRigth().diagonalTopRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        return nextMovements;
    }
}