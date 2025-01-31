package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    public void addFilm(Film myFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(myFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }

    public Film findFilm(int nr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getFilmNr() == nr) return current.data;
            current = current.neste;
        }
        return null;
    }

    public boolean deleteFilm(int filmNr) {
        if (start == null) return false;
        
        if (start.data.getFilmNr() == filmNr) {
            start = start.neste;
            antall--;
            return true;
        }

        LinearNode<Film> current = start;
        while (current.neste != null) {
            if (current.neste.data.getFilmNr() == filmNr) {
                current.neste = current.neste.neste;
                antall--;
                return true;
            }
            current = current.neste;
        }
        return false;
    }

    public Film[] searchTitle(String delstreng) {
        return searchHelper(delstreng, true);
    }

    public Film[] searchCreator(String delstreng) {
        return searchHelper(delstreng, false);
    }

    private Film[] searchHelper(String delstreng, boolean isTitle) {
        int count = 0;
        LinearNode<Film> current = start;
        while (current != null) {
            if ((isTitle && current.data.getTitle().toLowerCase().contains(delstreng.toLowerCase())) ||
                (!isTitle && current.data.getCreator().toLowerCase().contains(delstreng.toLowerCase()))) {
                count++;
            }
            current = current.neste;
        }

        Film[] matchingFilms = new Film[count];
        int index = 0;
        current = start;
        while (current != null) {
            if ((isTitle && current.data.getTitle().toLowerCase().contains(delstreng.toLowerCase())) ||
                (!isTitle && current.data.getCreator().toLowerCase().contains(delstreng.toLowerCase()))) {
                matchingFilms[index++] = current.data;
            }
            current = current.neste;
        }
        return matchingFilms;
    }

    public int numFilmsGenre(Sjanger genre) {
        int count = 0;
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getGenre() == genre) count++;
            current = current.neste;
        }
        return count;
    }

    public int numFilms() {
        return antall;
    }
}
