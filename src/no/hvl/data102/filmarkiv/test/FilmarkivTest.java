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

    @Test 
    public void testAddFilm() {
        Filmarkiv test = new Filmarkiv(2);
        Film film1 = new Film(3, "Film3", "Director3", 1980, Sjanger.ACTION, "Studio3");
        test.addFilm(film1);
        assertEquals(1, test.numFilms());
    }

    @Test 
    public void testFindFilm() {
        Filmarkiv test = new Filmarkiv(2);
        Film film1 = new Film(4, "Film4", "Director4", 1990, Sjanger.DRAMA, "Studio4");
        test.addFilm(film1);
        assertNotNull(test.findFilm(4));
        assertNull(test.findFilm(5));
    }

    @Test 
    public void testFilmarkiv2() {
        Filmarkiv2 test = new Filmarkiv2();
        Film film1 = new Film(6, "Awesome Film", "Director6", 2010, Sjanger.COMEDY, "Studio6");
        test.addFilm(film1);
        assertEquals(1, test.numFilms());
        assertNotNull(test.findFilm(6));
    }
}
