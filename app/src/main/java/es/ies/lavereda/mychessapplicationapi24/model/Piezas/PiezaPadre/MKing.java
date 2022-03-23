package es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre;

import java.util.ArrayList;
import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Pieza;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

public abstract class MKing  extends Pieza {
    public MKing(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements = new ArrayList<>();
        TableroChess board=celda.getTablero();
        Coordenada position=celda.getCoordenada(); //mi cordena
        Coordenada aux;                            //coordena a la que vamos

        //Top
        aux=position.coorTop();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //Bot
        aux=position.coorBot();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //Left
        aux=position.coorLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //Right
        aux=position.coorRigth();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //TopLeft
        aux=position.diagonalTopLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //TopRight
        aux=position.diagonalTopRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //BotLeft
        aux=position.diagonalBotLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //BotRight
        aux=position.diagonalBotRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        return nextMovements;
    }

}
