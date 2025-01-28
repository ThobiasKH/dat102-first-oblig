package no.hvl.data102.filmarkiv.impl; 
import java.util.Objects;
// 1.1
public class Film {
    private int filmNr;
    private String creator;
    private String title;
    private int releaseYear;
    private Sjanger genre;
    private String company;

    public Film() {

    }

    public Film(int nr, String creator, String title, int year, Sjanger genre, String company) {
        this.filmNr = nr;
        this.creator = creator;
        this.title = title;
        this.releaseYear = year;
        this.genre = genre;
        this.company = company;
    }

    public int getFilmNr() {
        return filmNr;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }
    
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Sjanger getGenre() {
        return genre;
    }

    public void setGenre(Sjanger genre) {
        this.genre = genre;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean equals(Film film) {
        return this.filmNr == film.getFilmNr();
    }

    @Override 
    public int hashCode() {
        return Objects.hash(title, releaseYear, creator, filmNr, genre, company);
    }
}

