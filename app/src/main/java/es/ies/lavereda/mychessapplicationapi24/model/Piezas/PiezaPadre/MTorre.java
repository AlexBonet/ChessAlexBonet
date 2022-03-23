package es.ies.lavereda.mychessapplicationapi24.model.Piezas.PiezaPadre;

import java.util.ArrayList;
import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ChessType;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Pieza;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

public abstract class MTorre extends Pieza {
    public MTorre(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    @Override
    public List<Coordenada> getNextMove() {
        return getMovAsTorre(this);

    }
    public static List<Coordenada> getMovAsTorre(Pieza p){
        List<Coordenada> nextMovements=new ArrayList<>();
        TableroChess board =p.getCelda().getTablero();
        Coordenada position0=p.getCelda().getCoordenada();
        Coordenada position=p.getCelda().getCoordenada();
        Coordenada aux;

        //Left
        aux=position0.coorLeft();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.coorLeft();
        }
        if (board.containsPieceAt(aux) && MAlfil.esRival(aux,p))
            nextMovements.add(aux);


        //Right
        aux=position0.coorRigth();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.coorRigth();
        }
        if (board.containsPieceAt(aux) && MAlfil.esRival(aux,p))
            nextMovements.add(aux);

        //Top
        aux=position0.coorTop();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.coorTop();
        }
        if (board.containsPieceAt(aux) && MAlfil.esRival(aux,p))
            nextMovements.add(aux);

        //Bot
        aux=position0.coorBot();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.coorBot();
        }
        if (board.containsPieceAt(aux) && MAlfil.esRival(aux,p))
            nextMovements.add(aux);

        return nextMovements;
    }
}
