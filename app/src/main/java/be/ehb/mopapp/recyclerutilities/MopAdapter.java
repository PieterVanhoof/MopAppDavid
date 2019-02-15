package be.ehb.mopapp.recyclerutilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.mopapp.R;
import be.ehb.mopapp.model.Mop;

/**
 * Created by ontlener on 14/02/2019. ;)
 */
public class MopAdapter extends RecyclerView.Adapter<MopAdapter.MopViewHolder> implements Filterable {


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

    private ArrayList<Mop> items, filteredItems;

    public MopAdapter(ArrayList<Mop> items) {
        this.items = items;
        this.filteredItems = items;
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

        Mop mopVoorDeRij = filteredItems.get(i);

        mopViewHolder.tvMop.setText( mopVoorDeRij.getMop() );
        mopViewHolder.tvClou.setText( mopVoorDeRij.getClou() );
    }

    //hoeveel rijen tekenen?
    @Override
    public int getItemCount() {
        return filteredItems.size();
    }

    @Override
    public Filter getFilter() {
        //anonymous class
        return new Filter() {
            //door de data gaan en enkele items uit de lijsten filteren
            //resultatenset opbouwen
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                //wat is er getypt
                String zoekterm = constraint.toString();

                //is er niets getypt, toon alles
                if (zoekterm.isEmpty()){
                    filteredItems = items;
                }else{
                    //is er iets getypt, overloop alle items en kijk na of zoekterm in moppen voorkomen
                    ArrayList<Mop> tempList = new ArrayList<>();
                    for( Mop m : items ){
                        if(m.getMop().contains(zoekterm) || m.getClou().contains(zoekterm) ){
                            //geldig, toevoegen aan lijst
                            tempList.add(m);
                        }
                    }
                    filteredItems = tempList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredItems;
                return filterResults;
            }

            //resultatenset komt binnen, gebruiken om lijst te updaten met wat overblijft na het filteren
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredItems = (ArrayList<Mop>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
