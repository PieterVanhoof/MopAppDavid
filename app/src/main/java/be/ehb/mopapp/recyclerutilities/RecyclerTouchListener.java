package be.ehb.mopapp.recyclerutilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ontlener on 14/02/2019. ;)
 */
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    //nodig om in de activity te laten invullen
    public interface ClickListener {
        void onClick(View view, int position);
    }

    //listener is een verwijzing naar listener in de activity
    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, ClickListener clickListener){
        this.clickListener = clickListener;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

        //wat staat er op coordinaat x,y in de recycler
        //coordinaat van waar een vinger het scherm raakt
        View rij = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        //action, welk soort aanraking -> enkel down opvangen, vinger neer op het scherm
        if(rij != null && motionEvent.getAction() == MotionEvent.ACTION_UP){
            //methode uitvoeren, dit stuurt dan door naar activity
            clickListener.onClick(rij, recyclerView.getChildAdapterPosition(rij));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {
    }
}
