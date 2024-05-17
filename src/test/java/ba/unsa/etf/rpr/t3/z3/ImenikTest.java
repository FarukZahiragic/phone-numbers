package ba.unsa.etf.rpr.t3.z3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
//import org.mockito.Mockito;

class ImenikTest {

    @Test
    void testMockExternal() throws BrojcaniException {
        Imenik phonebook = Mockito.mock(Imenik.class);
        phonebook.dodaj("Mujo", new FiksniBroj(Grad.SAMAC, "123-456"));
        String numbers = phonebook.naSlovo('M');
        Mockito.when(phonebook.dajBroj("Mujo")).thenReturn("Nema nista");
        assertEquals(phonebook.dajBroj("Mujo"), "Nema nista");
    }

    @Test
    void testMockInternal() throws BrojcaniException {
        HashMap<String, TelefonskiBroj> mapa = Mockito.mock(HashMap.class);
        Imenik imenik = new Imenik();
        imenik.dodaj("Mujo", new FiksniBroj(Grad.SAMAC, "123-456"));
        String numbers = imenik.naSlovo('M');
        Mockito.when(mapa.get("Mujo")).thenReturn(new FiksniBroj(Grad.MOSTAR, "123-456"));
        imenik.setImenik(mapa);

        String br = imenik.dajBroj("Mujo");
        assertNotEquals(br, "033/123-456");
        assertEquals(br, "036/123-456");
    }

    @Test
    void naSlovo() throws BrojcaniException {
        Imenik phonebook = new Imenik();
        phonebook.dodaj("Mujo", new FiksniBroj(Grad.SAMAC, "123-456"));
        String numbers = phonebook.naSlovo('M');
        assertEquals("1. Mujo - 054/123-456" + System.lineSeparator(), numbers);
    }

    @Test
    void izGrada() throws BrojcaniException{
        Imenik phonebook = new Imenik();
        phonebook.dodaj("Mujo", new FiksniBroj(Grad.SAMAC, "123-456"));
        Set<String> users = phonebook.izGrada(Grad.SAMAC);
        assertTrue(users.contains("Mujo"));
    }

    @Test
    void izNeispravnogGradaBrojevi() throws BrojcaniException {
        Imenik phonebook = new Imenik();
        phonebook.dodaj("Mujo", new FiksniBroj(Grad.SAMAC, "123-456"));
        assertThrows(BrojcaniException.class, () -> phonebook.izGradaBrojevi(null), "Pozivni broj nije validan.");
    }
}