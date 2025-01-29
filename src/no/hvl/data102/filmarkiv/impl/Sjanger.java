package no.hvl.data102.filmarkiv.impl; 
public enum Sjanger {
    HORROR,
    ROMCOM,
    ACTION,
    CRIME,
    SCI_FI,
    ROMANCE,
    DRAMA,
    ADVENTURE,
    COMEDY,
    ANIMATION,
    FANTASY
    ;

    public static Sjanger fromString(String genre) {
        try {
            return Sjanger.valueOf(genre.toUpperCase());
        }   
        catch (IllegalArgumentException e) {
            return null; 
        }
    }
}
