package no.hvl.data102.filmarkiv.klient;
import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.adt.*;
import java.util.Scanner;
public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        // legg inn en del forhåndsdefinerte filmer for å teste metodene
        // ..

        filmarkiv.addFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
        filmarkiv.addFilm(new Film(2, "Peter Jackson", "The Lord of the Rings: The Fellowship of the Ring", 2001, Sjanger.FANTASY, "New Line Cinema"));
        filmarkiv.addFilm(new Film(3, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.CRIME, "Miramax"));
        filmarkiv.addFilm(new Film(4, "George Lucas", "Star Wars: A New Hope", 1977, Sjanger.SCI_FI, "Lucasfilm"));
        filmarkiv.addFilm(new Film(5, "James Cameron", "Titanic", 1997, Sjanger.ROMANCE, "20th Century Fox"));
        filmarkiv.addFilm(new Film(6, "Ridley Scott", "Gladiator", 2000, Sjanger.DRAMA, "DreamWorks"));
        filmarkiv.addFilm(new Film(7, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ADVENTURE, "Universal Pictures"));
        filmarkiv.addFilm(new Film(8, "Stanley Kubrick", "The Shining", 1980, Sjanger.HORROR, "Warner Bros"));
        filmarkiv.addFilm(new Film(9, "Martin Scorsese", "The Wolf of Wall Street", 2013, Sjanger.COMEDY, "Paramount Pictures"));
        filmarkiv.addFilm(new Film(10, "Hayao Miyazaki", "Spirited Away", 2001, Sjanger.ANIMATION, "Studio Ghibli"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n--- Movie Archive Menu ---");
            System.out.println("1. Add a movie");
            System.out.println("2. Search by title");
            System.out.println("3. Search by producer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Film filmToAdd = tekstgr.lesFilm();
                    filmarkiv.addFilm(filmToAdd);
                    System.out.println("Your movie has been added!");
                    break;
                case 2:
                    searchByTitle(filmarkiv, scanner);
                    break;
                case 3:
                    searchByCreator(filmarkiv, scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }

    private void searchByTitle(FilmarkivADT filmarkiv, Scanner scanner) {
        System.out.print("Enter title substring: ");
        String titleSearch = scanner.nextLine();
        tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, titleSearch);
    }

    private void searchByCreator(FilmarkivADT filmarkiv, Scanner scanner) {
        System.out.print("Enter creator name: ");
        String creatorSearch = scanner.nextLine();
        tekstgr.skrivUtFilmProdusent(filmarkiv, creatorSearch);
    }
}
