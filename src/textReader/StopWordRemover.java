package textReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The StopWordRemover Class reads a file with a list of stop words and removes them from an ArrayList of Strings input
 * into its method.
 */
public class StopWordRemover {
    /**
     * This method takes an ArrayList of Strings and removes all stop words from it. After a HashSet with all the stop
     * words is created, it removes each one from the ArrayList.
     * @param words ArrayList of Strings
     * @throws FileNotFoundException if stop words file is not found
     */
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
