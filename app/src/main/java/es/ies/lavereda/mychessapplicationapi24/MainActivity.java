package es.ies.lavereda.mychessapplicationapi24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.Toast;

import es.ies.lavereda.mychessapplicationapi24.model.Celda;
import es.ies.lavereda.mychessapplicationapi24.model.TableroChess;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableroChess board=findViewById(R.id.board);
        board.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Celda celda=(Celda) view;
        Toast.makeText(this, "Click en " + celda, Toast.LENGTH_SHORT).show();
    }
}