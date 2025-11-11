package textReader;

/**
 * The FileStats Class serves as a pretty print for all ReadTxtFile object fields.
 */
public class FileStats {

    /**
     * This method prints the fields of a ReadTxtFile object in one place with relevant context for interpreting the
     * data.
     *
     * @param article A ReadTxtFile object that contains all relevant information from an article
     */
    public static void printData(ReadTxtFile article){
        System.out.println(article.name + " Statistics");
        System.out.println("Word Count: "+article.wordCount);
        System.out.println("Unique Word Count: " + article.uniqueWordCount);
        System.out.println("Negative Word Count: " + article.negativeWordCount);
        System.out.println("Positive Word Count: " + article.positiveWordCount);
        System.out.println("Attitude Score: " + article.attitudeScore);
        System.out.println("Richness Score: " + article.richness+"/100");
        System.out.println("Top 5 Most Used Words");
        for (int i =0; i < 5; i++) {
            System.out.println(article.uniqueWords.get(i)+": "+article.uniqueWordFrequency.get(i));
        }
        System.out.println();
    }
}