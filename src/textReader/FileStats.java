package textReader;

import java.util.HashSet;
import java.util.Set;

public class FileStats {

    public static void printData(ReadTxtFile article){
        System.out.println(article.name + " Statistics");
        System.out.println("Word Count: "+article.wordCount);
        System.out.println("Unique Word Count: " + article.uniqueWordCount);
    }

    public static void printWordFrequency(ReadTxtFile article){
        article.wordFrequency();
    }

}
