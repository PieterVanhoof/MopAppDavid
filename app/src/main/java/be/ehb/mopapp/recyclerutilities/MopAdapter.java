package be.ehb.mopapp.recyclerutilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import be.ehb.mopapp.R;
import be.ehb.mopapp.model.Mop;

/**
 * Created by ontlener on 14/02/2019. ;)
 */
public class MopAdapter extends RecyclerView.Adapter<MopAdapter.MopViewHolder> {

    //viewholder pattern
    //klasse die verwijzingen bijhoud naar elementen in layout
    //klasse enkel hier nodig, -> inner class
    public class MopViewHolder extends RecyclerView.ViewHolder{
        //verwijzingen naar elementen in layout
        public final TextView tvMop, tvClou;

        public MopViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            tvMop = itemView.findViewById(R.id.tv_mop);
            tvClou = itemView.findViewById(R.id.tv_clou);
        }
    }

    private ArrayList<Mop> items;

    public MopAdapter(ArrayList<Mop> items) {
        this.items = items;
    }

    //hoe ziet de rij eruit
    @NonNull
    @Override
    public MopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //viewgroep, waarbinnen wordt alles getekend
        Context context = viewGroup.getContext();
        //binnen die context effectief layout.xml omzetten naar iets in het scherm
        View cardRijView = LayoutInflater.from(context).inflate(R.layout.mop_card, viewGroup, false);
        //nieuwe viewholder op basis van de getekende layout
        return new MopViewHolder(cardRijView);
    }

    //rijen opvullen
    @Override
    public void onBindViewHolder(@NonNull MopViewHolder mopViewHolder, int i) {

        Mop mopVoorDeRij = items.get(i);

        mopViewHolder.tvMop.setText( mopVoorDeRij.getMop() );
        mopViewHolder.tvClou.setText( mopVoorDeRij.getClou() );
    }

    //hoeveel rijen tekenen?
    @Override
    public int getItemCount() {
        return items.size();
    }


}
