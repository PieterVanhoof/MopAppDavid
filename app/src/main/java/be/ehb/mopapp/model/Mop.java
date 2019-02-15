package be.ehb.mopapp.model;

/**
 * Created by ontlener on 14/02/2019. ;)
 */
public class Mop {

    private String mop, clou;

    public Mop() {
    }

    public Mop(String mop, String clou) {
        this.mop = mop;
        this.clou = clou;
    }

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public String getClou() {
        return clou;
    }

    public void setClou(String clou) {
        this.clou = clou;
    }

    @Override
    public String toString() {
        return "Mop{" +
                "mop='" + mop + '\'' +
                ", clou='" + clou + '\'' +
                '}';
    }
}
