package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
public class Filmarkiv implements FilmarkivADT {
    private int numberOfDefinedElements = 0;
    private Film[] films;

    public Filmarkiv(int size) {
        this.films = new Film[size];
    }

    public Film findFilm(int nr) {
        for (int i = 0; i < numberOfDefinedElements; i++) {
            if (films[i].getFilmNr() == nr) return films[i];
        }
        return null;
    } 

    public void addFilm(Film myFilm) {
        if (numberOfDefinedElements == films.length) {
            Film[] newArr = new Film[films.length * 2];
            for (int i = 0; i < films.length; i++) {
                newArr[i] = films[i];
            }
            films = newArr;
        }

        films[numberOfDefinedElements] = myFilm;
        numberOfDefinedElements++;
    } 

    public boolean deleteFilm(int filmNr) {
        int indexOfFilm = Integer.MAX_VALUE;
        for (int i = 0; i < films.length; i++) {
            Film f = films[i];
            if (f.getFilmNr() == filmNr) {
                indexOfFilm = i;
                break;
            }
        }

        boolean wasDeleted = false;
        for (int currentIndex = indexOfFilm; currentIndex < numberOfDefinedElements - 1; currentIndex++) {
            int nextIndex = currentIndex + 1;
            films[currentIndex] = films[nextIndex];
            wasDeleted = true;
        }
        if (wasDeleted) {
            // films[numberOfDefinedElements--] = null;
            films[numberOfDefinedElements - 1] = null;
            numberOfDefinedElements--;
        }

        return wasDeleted;
    }

    public Film[] searchTitle(String delstreng) {
        int count = 0;
        for (int i = 0; i < numberOfDefinedElements; i++) {
            if (films[i].getTitle().equals(delstreng)) {
                count++;
            }
        }

        Film[] matchingFilms = new Film[count];
        int index = 0;

        for (int i = 0; i < numberOfDefinedElements; i++) {
            if (films[i].getTitle().equals(delstreng)) {
                matchingFilms[index++] = films[i];
            }
        }

        return matchingFilms;
    } 

    public Film[] searchCreator(String delstreng) {
        int count = 0;
        for (int i = 0; i < numberOfDefinedElements; i++) {
            if (films[i].getCreator().equals(delstreng)) {
                count++;
            }
        }

        Film[] matchingFilms = new Film[count];
        int index = 0;

        for (int i = 0; i < numberOfDefinedElements; i++) {
            if (films[i].getCreator().equals(delstreng)) {
                matchingFilms[index++] = films[i];
            }
        }

        return matchingFilms;
    }

    public int numFilmsGenre(Sjanger genre) {
        int count = 0;
        for (int i = 0; i < numberOfDefinedElements; i++) {
            if (films[i].getGenre() == genre) count++;
        }
        return count;
    }

    public int numFilms() {
        return numberOfDefinedElements;
    }
}
