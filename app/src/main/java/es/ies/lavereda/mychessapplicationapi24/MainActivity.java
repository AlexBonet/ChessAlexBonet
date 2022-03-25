package es.ies.lavereda.mychessapplicationapi24;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.Toast;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.ColorPieza;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

/**
 * @author ALEX BONET
 *
 * TODO:
 *  1.- Poner los elementos gradicos con los id
 *  2.- interfaz para terminar el juego
 *  3.- añadir al game el tablero de les eliminades
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,IFinishGame {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableroChess board=findViewById(R.id.board);
        GameAndroid game=new GameAndroid(getApplicationContext(),board);


        board.setOnClickListener(game);
    }

    @Override
    public void onClick(View view) {
        Celda celda=(Celda) view;
//        Toast.makeText(this, "Click en " + celda, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish(ColorPieza winner, ColorPieza loser) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);


    }
}