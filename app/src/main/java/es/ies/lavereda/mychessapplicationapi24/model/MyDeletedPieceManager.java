package es.ies.lavereda.mychessapplicationapi24.model;

import java.util.ArrayList;
import java.util.List;

public class MyDeletedPieceManager implements IDeletePieceManager {
    private List<Pieza> piezaList;
    private DeletedPanel blackPanel;
    private DeletedPanel whitePanel;

    public MyDeletedPieceManager(DeletedPanel whitePanel, DeletedPanel blackPanel){
        piezaList=new ArrayList<>();
        this.whitePanel=whitePanel;
        this.blackPanel=blackPanel;

    }

    @Override
    public void add(Pieza p) {
        if (p.getColor()==ColorPieza.WHITE)
            whitePanel.add(p);
        else
            blackPanel.add(p);
    }

    @Override
    public void remove(Pieza p) {
    }
}
