package es.ies.lavereda.mychessapplicationapi24.model;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import es.ies.lavereda.mychessapplicationapi24.R;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas.WAlfil;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas.WCaballo;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas.WKing;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas.WPeon;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas.WQueen;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Blancas.WTorre;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras.BAlfil;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras.BCaballo;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras.BKing;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras.BPeon;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras.BQueen;
import es.ies.lavereda.mychessapplicationapi24.model.Piezas.Negras.BTorre;

public class TableroChess extends TableLayout {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Map<Coordenada,Celda> celdas;
    private IDeletePieceManager store4InBoard;
    private IDeletePieceManager store4Deleted;
    private List<Pieza> whitePiezas;
    private List<Pieza> blackPiezas;

    public TableroChess(Context context, AttributeSet attrs) {
        super(context, attrs);

        celdas=new HashMap<>();
        store4InBoard = new  MyDeletedPiecemanager();
        store4Deleted = new MyDeletedPiecemanager();
        whitePiezas=new LinkedList<>();
        blackPiezas=new LinkedList<>();

        Coordenada c;
        Celda cell;
        TableRow tableRow;

        initializeCells();
        LOGGER.finest("Board created.");
        placePieces();
    }

    public IDeletePieceManager getStore4InBoard() {
        return store4InBoard;
    }

    public IDeletePieceManager getStore4Deleted() {
        return store4Deleted;
    }

    private void initializeCells() {
        Coordenada coordinate;
        Celda cell;
        TableRow tableRow;

        tableRow = new TableRow(getContext());
        tableRow.addView(getNewLabel(""));
        for(int i='A';i<='H';i++)
            tableRow.addView(getNewLabel(String.valueOf((char)i)));
        tableRow.addView(getNewLabel(""));
        addView(tableRow);

        for (int row = 0; row <8; row++) {
            tableRow = new TableRow(getContext());
            tableRow.addView(getNewLabel(String.valueOf(row)));
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordenada((char) ('A' + col), 1 + row);
                cell = new Celda(getContext(),null,this, coordinate);

                celdas.put(coordinate, cell);
                tableRow.addView(cell);
            }
            tableRow.addView(getNewLabel(String.valueOf(row)));

            addView(tableRow);
        }

        tableRow = new TableRow(getContext());
        tableRow.addView(getNewLabel(""));
        for(int i='A';i<='H';i++)
            tableRow.addView(getNewLabel(String.valueOf((char)i)));
        tableRow.addView(getNewLabel(""));
        addView(tableRow);
    }

    public TextView getNewLabel(String characters) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int padding = (int) (displayMetrics.density * 16);
        int padding = (int)(getResources().getDimension(R.dimen.board_padding) * 2);
        int width = displayMetrics.widthPixels - padding;

        TextView textView = new TextView(getContext());
        textView.setText(characters);
        textView.setBackgroundColor(getResources().getColor(R.color.label_border_color,getContext().getTheme()));
        textView.setTextColor(getResources().getColor(R.color.white,getContext().getTheme()));
        textView.setGravity(Gravity.CENTER);
        textView.setWidth(width / 10);
        textView.setHeight(width / 10);
        return textView;
    }
    /**
     * Colocar Piezas
     */
    private void placePieces() {
        for (int i=0; i<8;i++) {
            new BPeon(getCellAt(new Coordenada((char)('A'+i),2)));
            new WPeon(getCellAt(new Coordenada((char)('A'+i),7)));
        }
        blackPiezas.add(new BCaballo(getCellAt(new Coordenada('B',1))));
        blackPiezas.add(new BCaballo(getCellAt(new Coordenada('G',1))));
        whitePiezas.add(new WCaballo(getCellAt(new Coordenada('B',8))));
        whitePiezas.add(new WCaballo(getCellAt(new Coordenada('G',8))));

        blackPiezas.add(new BTorre(getCellAt(new Coordenada('A',1))));
        blackPiezas.add(new BTorre(getCellAt(new Coordenada('H',1))));
        whitePiezas.add(new WTorre(getCellAt(new Coordenada('A',8))));
        whitePiezas.add(new WTorre(getCellAt(new Coordenada('H',8))));

        blackPiezas.add(new BAlfil(getCellAt(new Coordenada('C',1))));
        blackPiezas.add(new BAlfil(getCellAt(new Coordenada('F',1))));
        whitePiezas.add(new WAlfil(getCellAt(new Coordenada('C',8))));
        whitePiezas.add(new WAlfil(getCellAt(new Coordenada('F',8))));

        blackPiezas.add(new BQueen(getCellAt(new Coordenada('D',1))));
        whitePiezas.add(new WQueen(getCellAt(new Coordenada('D',8))));

        blackPiezas.add(new BKing(getCellAt(new Coordenada('E',1))));
        whitePiezas.add(new WKing(getCellAt(new Coordenada('E',8))));
    }

    /**
     * Comprueba que la celda existe
     * @param coordinate
     * @return si la celda está o no
     */
    public boolean containsCellAt(Coordenada coordinate){
        return celdas.containsKey(coordinate);
    }

    /**
     * Comprueba si hay algo en la celda
     * @param coordenada
     * @return
     */
    public boolean containsPieceAt(Coordenada coordenada){
        Celda celda=getCellAt(coordenada);
        if (celda==null)return false;
        return (celda.getPieza()!=null);
    }

    /**
     * Obten la Celda de una Coordenada
     * @param coordenada
     * @return celda
     */
    public Celda getCellAt(Coordenada coordenada){
        return celdas.get(coordenada);
    }

    public Collection<Celda> getCeldas(){
        return celdas.values();
    }

    public boolean estaLibre(Coordenada aux){
        return this.containsCellAt(aux) && !this.containsPieceAt(aux);
    }
    public boolean esRival(Coordenada aux, Pieza p){
        return (this.containsCellAt(aux) &&
                this.containsPieceAt(aux) &&
                this.getCellAt(aux).getPieza().getColor()!=p.getCelda().getPieza().getColor());
    }

    /**
     * Colorear
     */
    public void hightLight(List<Coordenada> cordenadas){
        TableroChess board = this;
        int i=0;
        while (i<cordenadas.size()) {
            Coordenada aux=cordenadas.get(i);
            if (estaLibre(aux)) {
                if (getCellAt(aux).getColor() == Celda.ColorCelda.BLACK_Cell)
                    getCellAt(aux).setColor(Celda.ColorCelda.HIGHLIGHT_MOV_BLACK);
                else
                    getCellAt(aux).setColor(Celda.ColorCelda.HIGHLIGHT_MOV_WHITE);
            } else if (!estaLibre(aux)) {
                if (getCellAt(aux).getColor() == Celda.ColorCelda.BLACK_Cell)
                    getCellAt(aux).setColor(Celda.ColorCelda.HIGHLIGHT_KILL_BLACK);
                else
                    getCellAt(aux).setColor(Celda.ColorCelda.HIGHLIGHT_KILL_WHITE);
            }
            i++;
        }
    }
    public void hightLightSelect(Coordenada c){
        if (getCellAt(c).getColor()== Celda.ColorCelda.BLACK_Cell)
            getCellAt(c).setColor(Celda.ColorCelda.HIGHLIGHT_SELECT_BLACK);
        else
            getCellAt(c).setColor(Celda.ColorCelda.HIGHLIGHT_SELECT_WHITE);
    }

    /**
     * idea de que pinte de color la celda del rey cuando esté en jaque
     */
    public void hightLightEnJaque(){
        List<Celda> list=new LinkedList<>(celdas.values());
        Iterator<Celda> iterator = list.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().getPieza().getChessType()==ChessType.W_king)
                getCellAt(iterator.next().getCoordenada()).setColor(Celda.ColorCelda.HIGHLIGHT_King_JAQUE);
        }
        while (iterator.hasNext()){
            if(iterator.next().getPieza().getChessType()==ChessType.B_king)
                getCellAt(iterator.next().getCoordenada()).setColor(Celda.ColorCelda.HIGHLIGHT_King_JAQUE);
        }
    }

    public void resetColorBoard(){
        for (Celda celda:celdas.values())
            celda.resetColor();
    }

    /**
     * Pone en una lista todas las piezas del color
     * @return lista con piezas del color
     */
    public List<Pieza> getBlackPiezas() {
        List<Pieza> piezas=new ArrayList<>();
        for (Celda cell:celdas.values())
            if (cell.getPieza()!=null && cell.getPieza().getColor()==ColorPieza.BLACK){
                piezas.add(cell.getPieza());
            }
        return piezas;
    }
    public List<Pieza> getWhitePiezas() {
        List<Pieza> piezas=new ArrayList<>();
        for (Celda cell:celdas.values())
            if (cell.getPieza()!=null && cell.getPieza().getColor()==ColorPieza.WHITE){
                piezas.add(cell.getPieza());
            }
        return piezas;
    }

    /**
     * Detectar jaque
     * @param color color de la pieza ribal
     * @return si el rei esta o no en jaque
     */
    public boolean estaEnJaque(ColorPieza color){

        Set<Coordenada> piezasCoords = getCeldas().stream()
                .filter(c -> c.getPieza() != null
                        && c.getPieza().getColor() == color.next())
                .map(c-> c.getPieza())
                .flatMap(pieza -> pieza.getNextMove()
                        .stream())
                .collect(Collectors.toSet());

        Optional<Coordenada> king;

        if(color == ColorPieza.BLACK){

            king = getCeldas().stream()
                    .filter(c -> c.getPieza() != null
                            && c.getPieza().getColor() == color
                            && c.getPieza().getChessType() == ChessType.B_king)
                    .map(c -> c.getCoordenada()).findFirst();
        }else{

            king = getCeldas().stream()
                    .filter(c -> c.getPieza() != null
                            && c.getPieza().getColor() == color
                            && c.getPieza().getChessType() == ChessType.W_king)
                    .map(c -> c.getCoordenada()).findFirst();
        }

        if(piezasCoords.contains(king.get())){
            return true;
        }

        return false;
    }




}
