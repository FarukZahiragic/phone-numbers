package ba.unsa.etf.rpr.t3.z3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws BrojcaniException {
        Imenik imenik = new Imenik();
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite ime: ");
        String ime = ulaz.nextLine();
        FiksniBroj broj = new FiksniBroj(Grad.izPozivnog("033"), "123-773");
        MobilniBroj mobilniBroj = new MobilniBroj(62, "553-756");
        MedunarodniBroj internacionalniBroj = new MedunarodniBroj("+387", "9213-173");
        imenik.dodaj("Mujo", broj);
        imenik.dodaj("Suljo", broj);
        imenik.dodaj("Fata", broj);
        System.out.println(broj.getGrad() + " " + broj.hashCode() + " " +  broj.ispisi());
        System.out.println(mobilniBroj.hashCode() + " " +  mobilniBroj.ispisi());
        System.out.println(internacionalniBroj.hashCode() + " " +  internacionalniBroj.ispisi());

        Imenik phoneBook = new Imenik();
        HashMap<String, TelefonskiBroj> phoneBookImenik = phoneBook.getImenik();
        phoneBook.setImenik(phoneBookImenik);
        phoneBook.dodaj(ime, broj);
        System.out.println(phoneBook.dajIme(broj) + " " + phoneBook.naSlovo('F') + " " + phoneBook.dajBroj("Faruk"));
        Set<String> users = phoneBook.izGrada(Grad.SARAJEVO);
        Set<TelefonskiBroj> userNumbers = phoneBook.izGradaBrojevi(Grad.SARAJEVO);
    }
}