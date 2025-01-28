package no.hvl.data102.filmarkiv.impl; 
public class Film {
    private int filmNr;
    private String creator;
    private String title;
    private int releaseYear;
    // private enum genre;
    private String company;

    public Film() {

    }

    public Film(int nr, String creator, String title, int year, 
        //enum genre, 
        String company) {
        this.filmNr = nr;
        this.creator = creator;
        this.title = title;
        this.releaseYear = year;
        //this.genre = genre;
        this.company = company;
    }

}
