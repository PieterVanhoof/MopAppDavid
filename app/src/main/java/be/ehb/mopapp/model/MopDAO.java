package be.ehb.mopapp.model;

import java.util.ArrayList;

/**
 * Created by ontlener on 14/02/2019. ;)
 */
public class MopDAO {
    private static final MopDAO ourInstance = new MopDAO();
    private ArrayList<Mop> mopLijst = new ArrayList<>();

    public static MopDAO getInstance() {
        return ourInstance;
    }

    private MopDAO() {
        mopLijst.add( new Mop("Het is oud en het vliegt", "Een bejaardelaar") );
        mopLijst.add( new Mop("het is rood en vliegt door de klas", "Een ongestelde vraag"));
        mopLijst.add( new Mop("Het is geel en weegt niet veel", "Lichtgeel") );
        mopLijst.add( new Mop("Het is oranje en als het regent is het weg", "De mannen van de gemeente") );
        mopLijst.add( new Mop("Het is zwart en als het uit de boom valt is uw stoof kapot", "uw stoof") );
    }

    public ArrayList<Mop> getMopLijst() {
        return mopLijst;
    }
}
