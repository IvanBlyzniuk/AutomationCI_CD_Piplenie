import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

    public static final boolean TESTS_PASS = true;

    private Map<String, ArrayList<FileData>> index;
    private ArrayList<File> files;

    public WordCounter(String folderName) {
        index = new TreeMap<>();
        files = new ArrayList<>();
        File inputFolder = new File(folderName);

        files.addAll(
                Arrays.stream(inputFolder.listFiles())
                        .filter(f -> f.isFile())
                        .toList()
        );
        FileParser parser = new FileParser();
        for (int i = 0; i < files.size(); i++) {
            try {
                for (String word : parser.GetAllWords(files.get(i))) {
                    addWord(word, i);
                }

            } catch (IOException e) {
                System.out.println("Could not read file: " + files.get(i).getName());
            }
        }
    }

    private void addWord(String word, int fileId) {
        ArrayList<FileData> datas = index.get(word);
        if (datas == null) {
            datas = new ArrayList<>();
            index.put(word, datas);
        }
        FileData lastData = null;
        if(!datas.isEmpty())
            lastData = datas.get(datas.size() - 1);
        if (lastData != null && lastData.fileId == fileId) {
            lastData.count++;
        } else {
            FileData newData = new FileData(fileId,1);
            datas.add(newData);
        }
    }

    public static class FileData {
        public int fileId;
        public int count;

        public FileData(int fileId, int count) {
            this.fileId = fileId;
            this.count = count;
        }
    }

    public Map<String, ArrayList<FileData>> getIndex() {
        return index;
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}
