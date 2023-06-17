import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileParser {


    public ArrayList<String> GetAllWords(File file) throws IOException {
        ArrayList<String> words = new ArrayList<>();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String curLine = "";
        while (bufferedReader.ready()) {
            curLine = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(curLine, " \n.,;:\t!?{}()\"");
            while(tokenizer.hasMoreElements()){
                words.add(tokenizer.nextToken());
            }
        }

        bufferedReader.close();
        fileReader.close();

        return words;
    }


}
