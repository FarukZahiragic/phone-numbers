package ba.unsa.etf.rpr.t3.z3;
import java.util.Objects;

/*
* Landline phone number class
* @author Faruk Zahiragic
 */

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;
    FiksniBroj(Grad grad, String broj) throws BrojcaniException {
        if(null == grad) throw new BrojcaniException("Pozivni broj nije validan.");
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return grad.getPozivniBroj() + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    public Grad getGrad() {
        return grad;
    }
}
