package no.hvl.data102.filmarkiv.test;
import no.hvl.data102.filmarkiv.impl.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class FilmarkivTest {
    @Test 
    public void testOne() {
        Filmarkiv test = new Filmarkiv(3);
        Film film1 = new Film(1, "KulFilm", "Kubric", 1969, Sjanger.HORROR, "Cool film inc");
        Film film2 = new Film(2, "KulFilm1", "Kubric1", 1970, Sjanger.ROMCOM, "Cool film inc");
        test.addFilm(film1);
        test.addFilm(film2);
        assertEquals(1, test.numFilmsGenre(Sjanger.HORROR));
        test.deleteFilm(2);
    }
}
