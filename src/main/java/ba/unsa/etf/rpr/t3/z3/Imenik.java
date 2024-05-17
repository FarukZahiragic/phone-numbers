package ba.unsa.etf.rpr.t3.z3;

import java.util.*;

/*
* Phonebook class
*
* @author Faruk Zahiragic
 */

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik;

    public Imenik() {
        this.imenik = new HashMap<String, TelefonskiBroj>();
    }

    public HashMap<String, TelefonskiBroj> getImenik() {
        return imenik;
    }

    public void setImenik(HashMap<String, TelefonskiBroj> imenik) {
        this.imenik = imenik;
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        this.imenik.put(ime, broj);
    }
    public String dajBroj(String ime) {
        return imenik.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if(entry.getValue().ispisi().equals(broj.ispisi())) return entry.getKey();
        }
        return null;
    }

    public String naSlovo(char c) {
        StringBuilder builder = new StringBuilder();

        int counter = 1;
        for (String i : imenik.keySet()) {
            if(i.startsWith(String.valueOf(c)))
                builder.append(counter)
                        .append(". ")
                        .append(i)
                        .append(" - ")
                        .append(this.imenik.get(i).ispisi())
                        .append(System.lineSeparator()); // \n wasn't used because it would limit cross-platform capabilities
        }
        return builder.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> results = new TreeSet<String>(); // TreeSet automatically sorts elements
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if(jeLiIzGrada(entry.getValue(), g)) results.add(entry.getKey());
        }
    return results;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) throws BrojcaniException {
        if(g == null) throw new BrojcaniException("Pozivni broj nije validan.");
        Set<TelefonskiBroj> results = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if(jeLiIzGrada(entry.getValue(), g)) results.add(entry.getValue());
        }
        return results;
    }

    private boolean jeLiIzGrada(TelefonskiBroj broj, Grad g) { // utlity method
        if(broj instanceof FiksniBroj) {
            return g.equals(((FiksniBroj) broj).getGrad());
        }
        return false;
    }
}
