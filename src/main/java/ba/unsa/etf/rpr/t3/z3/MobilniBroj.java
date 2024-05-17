package ba.unsa.etf.rpr.t3.z3;

import java.util.Objects;

/*
* Mobile phone number class
* @author Faruk Zahiragic
 */
public class MobilniBroj extends  TelefonskiBroj {
    private int mobilnaMreza;
    private String mobilniBroj;
    MobilniBroj(int mobilnaMreza, String mobilniBroj) {
        this.mobilnaMreza = mobilnaMreza;
        this.mobilniBroj = mobilniBroj;
    }
    @Override
    public String ispisi() {
        return "0" + mobilnaMreza + "/" + mobilniBroj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, mobilniBroj);
    }
}
