package textReader;

import java.util.*;

public class FileStats {

    public static void printData(ReadTxtFile article){
        System.out.println(article.name + " Statistics");
        System.out.println("Word Count: "+article.wordCount);
        System.out.println("Unique Word Count: " + article.uniqueWordCount);
        System.out.println("Top 5 Most Used Words");
        for (int i =0; i < 5; i++) {
            System.out.println(article.uniqueWords.get(i)+": "+article.uniqueWordFrequency.get(i));
        }
        System.out.println();
    }
}
