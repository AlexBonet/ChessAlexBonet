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

    public Celda(Context context,AttributeSet attrs, TableroChess tablero, Coordenada coordenada){
        super(context,attrs);

//        DisplayMetrics displayMetrics=new DisplayMetrics();
//        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
////        int padding=(int) (displayMetrics.density * 16);
//        int padding=(int) getResources().getDimension(R.dimen.board_padding) * 2;
//        int width = displayMetrics.widthPixels-padding;

//        int size = (width) / 10;
//
//        setMaxHeight(size);
//        setMaxWidth(size);
//        setMinimumHeight(size);
//        setMinimumWidth(size);

        this.tablero=tablero;
        this.coordenada=coordenada;
        if(((coordenada.getLetter()-'A')+coordenada.getNum())%2==0)
            originalColor= ColorCelda.BLACK_Cell;
        else
            originalColor= ColorCelda.WHITE_Cell;

        this.color=originalColor;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int padding = (int) (displayMetrics.density * 16);
        int padding = (int)(getResources().getDimension(R.dimen.board_padding) * 2);
        int width = displayMetrics.widthPixels - padding;
        getResources().getDimension(R.dimen.board_padding);

        int size = (width) / 10;

        setMinimumWidth(size);
        setMinimumHeight(size);
        setMaxHeight(size);
        setMaxWidth(size);

        setBackgroundColor(getResources().getColor(color.getAttribute(),getContext().getTheme()));

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
        //Establecer imagen en la celda
        if (pieza != null) {
            setImageResource(pieza.getChessType().getForma());
            setPadding(0, 0, 0, 0);
            setScaleType(ScaleType.FIT_CENTER);
            setAdjustViewBounds(true);

        } else {
            setImageResource(0);
        }

    }
    public void setColor(ColorCelda color) {
        this.color = color;
    }

    public void resetColor(){
        color=originalColor;
        setBackgroundColor(getResources().getColor(color.getAttribute(),getContext().getTheme()));
        setAdjustViewBounds(true);
    }

//    public Pieza containsPiece(){
//        return
//    }

    @Override
    public String toString() {
        return coordenada.toString();
    }

    /**
     * Enumerador de Colores
     */
    public enum ColorCelda{
        WHITE_Cell(R.color.fondoCeldaClaro),
        BLACK_Cell(R.color.fondoCeldaOscura),
        BLACK(R.color.black),
        WHITE(R.color.white),

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
