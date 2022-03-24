package es.ies.lavereda.mychessapplicationapi24;

import android.graphics.Color;

import es.ies.lavereda.mychessapplicationapi24.model.ColorPieza;

public interface IFinishGame {
    public void finish(ColorPieza winner, ColorPieza loser);
}
