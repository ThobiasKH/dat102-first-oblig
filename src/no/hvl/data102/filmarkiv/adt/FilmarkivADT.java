//1.2
package no.hvl.data102.filmarkiv.adt;
import no.hvl.data102.filmarkiv.impl.*;
public interface FilmarkivADT {
/**
* Hente en film med gitt nr fra arkivet
* @param nr nummer på film som skal hentes.
* @return film med gitt nr. Om nr ikke finnes, returneres null.
*/
Film findFilm(int nr);
/**
* Legger til en ny film.
* @param nyFilm
*/
void addFilm(Film nyFilm);
/**
* Sletter en fil med gitt nr
* @param filmnr nr på film som skal slettes
* @return true dersom filmen ble slettet, false ellers
*/
boolean deleteFilm(int filmnr);
/**
* Søker og henter Filmer med en gitt delstreng i tittelen.
* @param delstreng som må være i tittel
* @return tabell med filmer som har delstreng i tittel
*/
Film[] searchTitle(String delstreng);
/**
* Søker og henter filmer med en gitt delstreng i filmprodusent
* @param delstreng
* @return
*/
Film[] searchCreator(String delstreng);
/**
* Finner antall filmer med gitt sjanger
* @param sjanger
* @return antall filmer av gitt sjanger.
*/
int numFilmsGenre(Sjanger sjanger);
/**
* @return antall filmer i arkivet
*/
int numFilms();
}
