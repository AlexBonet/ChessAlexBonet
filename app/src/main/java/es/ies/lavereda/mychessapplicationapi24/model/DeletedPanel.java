package es.ies.lavereda.mychessapplicationapi24.model;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.GridLayout;
import android.widget.ImageView;

import es.ies.lavereda.mychessapplicationapi24.R;

public class DeletedPanel extends GridLayout {

    public DeletedPanel(Context context) {
        super(context);
        setColumnCount(8);
        setRowCount(2);
    }

    public DeletedPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setColumnCount(8);
        setRowCount(2);
    }

    public DeletedPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setColumnCount(8);
        setRowCount(2);
    }

    public void add(Pieza p){
        ImageView imageView=new ImageView(getContext());
        imageView.setImageResource(p.getChessType().getForma());
        addView(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int padding=(int) (getResources().getDimension(R.dimen.board_padding)*2);
        int width= displayMetrics.widthPixels-padding;



    }

}
