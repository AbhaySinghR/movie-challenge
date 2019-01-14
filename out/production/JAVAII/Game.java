import java.util.Scanner;
public class Game {

    private String movieToGuess;
    private int pointsLost;
    private String wrongLetters;
    private String rightLetters;
    private boolean gameWon;

    /*
    1>>>the trim() method in java deletes all the trailing or leading space in the movie title .
    2>>> With the help of RandomMovie a random movie is generated from a list of movies.
     */
    public Game(String pathname) {
        movieList MovieList = new movieList(pathname);
        movieToGuess = MovieList.getRandomMovie().trim();
        pointsLost = 0;
        rightLetters = "";
        wrongLetters = "";
        gameWon = false;
    }

    public String getHMovieTitle() {
        if(rightLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-Z']", "_");
        }
        else{
            return movieToGuess.replaceAll("[a-zA-Z'&&[^" + rightLetters +"]]", "_");
        }
    }

    public String getWrongLetters() {
        return wrongLetters;
    }


    public boolean WonGame() {
        return gameWon;
    }


    public boolean gameEnded() {
        if (pointsLost >= 10) {
            return true;
        }

        if(!getHMovieTitle().contains("_")) {
            gameWon = true;
            return true;
        }
        return false;
    }

    private String inputLetter(){

        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if(!letter.matches("[a-z]")&&(!letter.matches("'"))){
            System.out.println("That is not a letter.");
            System.out.println("You are guessing :"+ getHMovieTitle());
            return inputLetter();
        }
        else if(wrongLetters.contains(letter) || rightLetters.contains(letter)){
            System.out.println("You already guessed that letter.");
            System.out.println("You are guessing :"+ getHMovieTitle());
            return inputLetter();
        }
        else{
            return letter;
        }
    }

    public void guessLetter() {

        String guessedLetter = inputLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
        }
        else {
            pointsLost++;
            wrongLetters += " " + guessedLetter;
        }
    }
}

