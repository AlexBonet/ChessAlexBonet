package es.ies.lavereda.mychessapplicationapi24.model;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageButton;

import es.ies.lavereda.mychessapplicationapi24.R;

public class Celda extends androidx.appcompat.widget.AppCompatImageButton {
    private Coordenada coordenada;
    private ColorCelda color;
    private ColorCelda originalColor;
    private Pieza pieza;
    private TableroChess tablero;

    public Celda(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Celda(Context context) {
        super(context);
    }

    public Celda(Context context, TableroChess tablero, Coordenada coordenada){
        super(context);

        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int padding=(int) (displayMetrics.density * 16);
        int width = displayMetrics.widthPixels-padding;

        int size = (width) / 10;

        setMaxHeight(size);
        setMaxWidth(size);
        setMinimumHeight(size);
        setMinimumWidth(size);

        this.tablero=tablero;
        this.coordenada=coordenada;
        if(((coordenada.getLetter()-'A')+coordenada.getNum())%2==0)
            originalColor= ColorCelda.BLACK_Cell;
        else
            originalColor= ColorCelda.WHITE_Cell;

        color=originalColor;

    }


    public Pieza getPieza() {
        return pieza;
    }
    public ColorCelda getColor() {
        return color;
    }
    public TableroChess getTablero() {
        return tablero;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    public void setColor(ColorCelda color) {
        this.color = color;
    }

    public void resetColor(){
        this.setColor(originalColor);
    }

    /**
     * Enumerador de Colores
     */
    public enum ColorCelda{
        WHITE_Cell(R.color.white),
        BLACK_Cell(R.color.black),
        BLACK(R.color.black),

        HIGHLIGHT_MOV_WHITE(R.color.white_hightlight_move),
        HIGHLIGHT_MOV_BLACK(R.color.black_hightlight_move),

        HIGHLIGHT_King_JAQUE(R.color.hightlight_jaque),

        HIGHLIGHT_SELECT_WHITE(R.color.hightlight_selection),
        HIGHLIGHT_SELECT_BLACK(R.color.hightlight_selection),

        HIGHLIGHT_KILL_WHITE(R.color.white_hightlight_kill),
        HIGHLIGHT_KILL_BLACK(R.color.black_hightlight_kill);

        private int color;
        ColorCelda(int color){
            this.color=color;
        }
        public int getAttribute(){
            return color;
        }
    }


}
