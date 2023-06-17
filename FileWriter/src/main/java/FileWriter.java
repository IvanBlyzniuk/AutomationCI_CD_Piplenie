import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class FileWriter {

    public void writeToFile(String fileName, Map<String, ArrayList<WordCounter.FileData>> index, ArrayList<File> files)
            throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (String word : index.keySet()) {
            printWriter.print(word + " : ");
            for (WordCounter.FileData data : index.get(word)) {
                printWriter.print(files.get(data.fileId).getName() + " - " + data.count + " | ");
            }
            printWriter.println();
        }
        printWriter.close();
        fileOutputStream.close();
        return;
    }
}
