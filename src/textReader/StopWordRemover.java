package textReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StopWordRemover {
    public static void removeStopWords(ArrayList<String> words) throws FileNotFoundException {
        Set<String> stopWords = new HashSet<>();
        File obj = new File("src/DataSets/stopwords.txt");
        Scanner Reader = new Scanner(obj);
        while(Reader.hasNext()){
            String word = Reader.next();
            stopWords.add(word);
        }
        Reader.close();
        words.removeAll(stopWords);
    }

}

