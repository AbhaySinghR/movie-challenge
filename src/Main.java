
public class Main {

    public static void main(String[] args) {

      Game game=new Game("movies.txt");
      //object of public class game in public class   main

       System.out.println("Welcome to the GUESS THE MOVIE CHALLENGE  ");
       System.out.println("this time you'll be completing a game where the player gets to guess the movie name given the" +
               " number of letters in it (pretty much like hangman but with movies!)");
       System.out.println("The rules are simple, the computer randomly picks a movie title, and shows you how many " +
               "letters it's made up of. Your goal is to try to figure out the movie by guessing one letter at a time.");
       System.out.println("If a letter is indeed in the title the computer will reveal its correct position in the word," +
               " if not, you lose a point. If you lose 10 points, game over!");
       System.out.println("BUT the more correct letters you guess the more obvious the movie becomes and at a certain " +
               "point you should be able to figure it out.");
       System.out.println("The program will randomly pick a movie title from a text file that contains a large list " +
               "of movies.");
       System.out.println("Once the computer picks a random title, it will display underscores \"_\" in place of the " +
               "real letters, thereby only giving away the number of letters in the movie title.");
      while(!game.gameEnded())
      {
          System.out.println("You are guessing :"+ game.getHMovieTitle());
          System.out.println("You have guessed("+ game.getWrongLetters().length()/2 + ") wrong letters:"
                  + game.getWrongLetters());
          game.guessLetter();
      }
      if(game.WonGame())
      {
          System.out.println("You Win");
      }
      else {
          System.out.println("You Lost!!");
          System.out.println("You have guessed (" + game.getWrongLetters().length() / 2 + ") wrong letters:" +
                  game.getWrongLetters());

          System.out.println("Better Luck Next Time!");
      }
    }

}
