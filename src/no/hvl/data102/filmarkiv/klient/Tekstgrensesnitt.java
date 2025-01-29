package no.hvl.data102.filmarkiv.klient;
import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.adt.*;
import java.util.Scanner;
public class Tekstgrensesnitt {
    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie number: ");
        int nr = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter creator (director): ");
        String creator = scanner.nextLine();

        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();

        System.out.print("Enter release year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter genre \n(ACTION, ADVENTURE, ANIMATION, COMEDY, CRIME, DRAMA, FANTASY, HORROR, ROMANCE, ROMCOM, SCI_FI): ");
        String genreInput = scanner.nextLine();
        Sjanger genre = Sjanger.fromString(genreInput);

        System.out.print("Enter production company: ");
        String company = scanner.nextLine();

        return new Film(nr, creator, title, year, genre, company);
    }
    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println(film.toString());
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] matchingMovies = arkiv.searchTitle(delstreng);
        if (matchingMovies.length == 0) {
            System.out.println("No matching films!");
        }
        for (Film f : matchingMovies) {
           System.out.println(f.toString()); 
        }

    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        // TODO
        Film[]matchingMovies = arkiv.searchCreator(delstreng);
        if (matchingMovies.length == 0) {
            System.out.println("No matching films!");
        }

        for (Film f : matchingMovies) {
            System.out.println(f.toString());
        }
    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("There are " + arkiv.numFilms() + " movies!");

        for (Sjanger genre : Sjanger.values()) {
            System.out.println("There are " + arkiv.numFilmsGenre(genre) + " " + genre + " movies!");
        }
    }
    // osv ... andre metoder
    //
    public void slettFilm(FilmarkivADT arkiv, String tittel) {
        Film[] matches = arkiv.searchTitle(tittel);  
        if (matches.length == 0) {
            System.out.println("The movie is not in the archive!");
            return;
        }

        Film f = matches[0];
        System.out.println(f.getTitle() + " was found, delete it? (y/N): ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().toLowerCase() == "y") {
            arkiv.deleteFilm(f.getFilmNr());
            System.out.println("It was deleted!");
        }
        else {
            System.out.println("It was not deleted!");
        }

    }
    
}
