package ba.unsa.etf.rpr.t3.z3;

/*
* International number class
* @author Faruk Zahiragic
 */

import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj {
    private String drzava;
    private String broj;
    MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return drzava + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }
}
