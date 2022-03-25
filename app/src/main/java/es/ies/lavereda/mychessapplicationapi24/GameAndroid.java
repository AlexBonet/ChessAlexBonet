package es.ies.lavereda.mychessapplicationapi24;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ColorPieza;
import es.ies.lavereda.mychessapplicationapi24.model.Coordenada;
import es.ies.lavereda.mychessapplicationapi24.model.Pieza;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;


public class GameAndroid implements View.OnClickListener {
    private Context context;
    private TableroChess board;
    private ColorPieza turno;
    private Pieza piezaSeleccionada;

    public GameAndroid(Context context, TableroChess board){
        this.context=context;
        this.board=board;
        this.turno=ColorPieza.WHITE;
    }

    public GameAndroid(Context context, TableroChess board,IFinishGame iFinishGame){
        this.context=context;
        this.board=board;
        this.turno=ColorPieza.WHITE;
//        elegirCelda(board,turno);
    }

    @Override
    public void onClick(View view) {
//        Toast.makeText(view.getContext(), "Click en: " + ((Celda) view).getCoordenada().toString(), Toast.LENGTH_SHORT).show();

        Celda celda=(Celda) view;

        if (piezaSeleccionada==null){
            if (board.getCellAt(celda.getCoordenada())==null)
                Toast.makeText(context, "CELDA VACIA", Toast.LENGTH_SHORT).show();
            else if (!celda.getPieza().getColor().equals(turno))
                Toast.makeText(context, "PIEZA DEL RIVAl", Toast.LENGTH_SHORT).show();
            else if (celda.getPieza().getNextMove().size()==0)
                Toast.makeText(context, "PIEZA SIN MOVIMIENTOS", Toast.LENGTH_SHORT).show();
            else {
                piezaSeleccionada= celda.getPieza();

            }
        }else {
            boolean moved=piezaSeleccionada.moveTo(celda.getCoordenada());

            if (moved){
                board.resetColorBoard();
                turno=turno.next();
                piezaSeleccionada=null;
            }
        }


    }

    public void elegirCelda(View view, ColorPieza turno){
        Coordenada c;   //Coordenada a la que nos vamos a mover
        boolean vacia = false;  //booleano para salir del bucle
        List<Coordenada> nextMove = new LinkedList<>(); // Posibles siguientes movientos de la pieza
        do {
            //TODO? si tindriem que dirli al jugador que es el seu turno y que pille
            c = new Coordenada(((Celda) view).getCoordenada().getLetter(),
                    ((Celda) view).getCoordenada().getNum());  //Inicializa la coordenada con los valores pasados anteriormente

            if (board.getCellAt(c).getPieza() == null) {  //Comprueba que no este vacia la celda
                Toast.makeText(view.getContext(), "ERROR", Toast.LENGTH_SHORT).show();//celda vacia
                vacia = true;
            } else if (turno == ColorPieza.WHITE && board.getCellAt(c).getPieza().getColor() == ColorPieza.WHITE) {    //comprobar de quien es el turno

                nextMove.addAll(board.getCellAt(c).getPieza().getNextMove());       //añade a la lista los movimientos

                if (nextMove.size() > 0) {         //si la se puede mover, enseña el tablero con las celdas coloreadas
                    board.hightLightSelect(c);
                    vacia = false;
                } else {
                    if (board.getCellAt(c).getPieza() != null) //si hay una pieza que no puede moverse
                        Toast.makeText(view.getContext(), "ERROR", Toast.LENGTH_SHORT).show();//no puede moverse
                }

            } else if (turno == ColorPieza.BLACK && board.getCellAt(c).getPieza().getColor() == ColorPieza.BLACK) {

                nextMove.addAll(board.getCellAt(c).getPieza().getNextMove());

                if (nextMove.size() > 0) {
                    board.hightLightSelect(c);
                    vacia = false;
                } else {
                    if (board.getCellAt(c).getPieza() != null)
                        Toast.makeText(view.getContext(), "ERROR", Toast.LENGTH_SHORT).show();//no puede moverse
                }

            } else
                Toast.makeText(view.getContext(), "ERROR", Toast.LENGTH_SHORT).show();//es del rival

        } while (nextMove.size() == 0 || vacia);
//        eligeNextMove(c, nextMove);

    }

}
