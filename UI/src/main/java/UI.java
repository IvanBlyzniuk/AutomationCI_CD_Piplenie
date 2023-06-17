import java.io.IOException;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to WordCount program, please input folder name (leave empty for \"Input\"): ");
        String folderName = scanner.nextLine();
        if(folderName.equals(""))
            folderName = "Input";
        System.out.println("Starting scan...");
        WordCounter wordCounter = new WordCounter(folderName);
        System.out.println("Scan finished, input filename for output: ");
        String filename = scanner.nextLine();
        FileWriter fileWriter = new FileWriter();
        try{
            fileWriter.writeToFile(filename, wordCounter.getIndex(), wordCounter.getFiles());
        }catch (IOException e){
            System.out.println("An error occurred while trying to write data to file!");
        }

    }
}
