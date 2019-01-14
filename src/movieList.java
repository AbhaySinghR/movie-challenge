import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class movieList {
    private ArrayList <String> movies;
    public movieList(String pathname) {
        movies = new ArrayList();
        File file = new File(pathname);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            System.exit(0);
        }
    }
    /*

     */

    public String getRandomMovie() {
        int movieIndex = (int) (Math.random() * movies.size());
        return movies.get(movieIndex);
    }
}