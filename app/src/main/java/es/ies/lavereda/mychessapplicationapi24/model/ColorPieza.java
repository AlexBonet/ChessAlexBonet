package es.ies.lavereda.mychessapplicationapi24.model;



public enum ColorPieza {
    WHITE, BLACK;

    public ColorPieza next(){
//        return ColorPieza.values()[((ordinal()+1)%ColorPieza.values().length)]; //
        if (ordinal()==0)
            return BLACK;
        else
            return WHITE;
    }
}
