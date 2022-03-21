package es.ies.lavereda.mychessapplicationapi24.model;

import es.ies.lavereda.mychessapplicationapi24.R;

public enum ChessType {
    B_king(R.mipmap.ic_n_rey,ColorPieza.BLACK),
    B_queen(R.mipmap.ic_n_reina,ColorPieza.BLACK),
    B_alfil(R.mipmap.ic_n_alfil,ColorPieza.BLACK),
    B_caballo(R.mipmap.ic_n_caballo,ColorPieza.BLACK),
    B_torre(R.mipmap.ic_n_torre,ColorPieza.BLACK),
    B_peon(R.mipmap.ic_n_peon,ColorPieza.BLACK),
    W_king(R.mipmap.ic_b_rey,ColorPieza.WHITE),
    W_queen(R.mipmap.ic_b_reina,ColorPieza.WHITE),
    W_alfil(R.mipmap.ic_b_alfil,ColorPieza.WHITE),
    W_caballo(R.mipmap.ic_b_caballo,ColorPieza.WHITE),
    W_torre(R.mipmap.ic_b_torre,ColorPieza.WHITE),
    W_peon(R.mipmap.ic_b_pawn,ColorPieza.WHITE);

    private int forma;
    private ColorPieza color;

    ChessType(int forma, ColorPieza color){
        this.forma=forma;
        this.color=color;
    }

    public int getForma(){
        return forma;
    }
    public ColorPieza getColor(){
        return color;
    }

    @Override
    public String toString() {
        return forma+color.toString();
    }
}
