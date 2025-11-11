package textReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ReadTxtFile Class serves the purpose of taking a text file and processing the information.
 * <p>
 * This class uses its internal methods as well as methods from neighboring classes in the textReader package to process
 * the information in the text files. The important words and useful stats are stored in an object within this class
 * with many fields. This information can be used to get a better idea of the contents stored in the file and compare them
 * to related files.
 */

public class ReadTxtFile {
    /**
     * An ArrayList that stores all the words from an article when processed.
     */
    public ArrayList<String> words = new ArrayList<>();
    /**
     * An ArrayList that stores all the words from an article, with each word only being added to the ArrayList once,
     * regardless of usage.
     */
    public ArrayList<String> uniqueWords = new ArrayList<>();
    /**
     * This ArrayList serves in parallel with the 'uniqueWords' ArrayList, each element being the amount of times the
     * corresponding word appears in the 'uniqueWords' ArrayList appears in the article that was processed.
     */
    public ArrayList<Integer> uniqueWordFrequency = new ArrayList<>();
    /**
     * This field stores the word count of the article after all stop words are removed from the 'words' ArrayList
     */
    public int wordCount = 0;
    /**
     * This field stores the amount of different words in the article
     */
    public int uniqueWordCount = 0;
    /**
     * This field stores the number of words that appear in both the article and list of positive words stored in
     * 'positive-words.txt'
     */
    public int positiveWordCount = 0;
    /**
     * This field stores the number of words that appear in both the article and list of negative words stored in
     * 'negative-words.txt'
     */
    public int negativeWordCount = 0;
    /**
     * This field stores an integer value that represents the overall negativity or positivity of an article based on
     * the values words are assigned in the 'lexicon_score.txt' file.
     */
    public int attitudeScore=0;
    /**
     * This field stores a value for richness from 1-100 using a Type-Token Ratio where unique words is divided by the
     * word count multiplied by 100. Since answer is a decimal, multiplying by 100 makes it a percentage and when printed
     * is always printed over 100.
     */
    public int richness=0;
    /**
     * Stores a user assigned name they would like the object to use when referencing the article when printing statistics
     */
    public String name;

    /**
     * This is a constructor for making a ReadTxtObject. It is initialized with a name, but lacks values for all other
     * variables until after an article is read.
     * @param name String value for identifying object when printing values for user to use.
     */
    public ReadTxtFile(String name) {
        words = new ArrayList<>();
        uniqueWords = new ArrayList<>();
        uniqueWordFrequency = new ArrayList<>();
        wordCount = 0;
        uniqueWordCount = 0;
        positiveWordCount = 0;
        negativeWordCount = 0;
        attitudeScore=0;
        richness=0;
        this.name = name;
    }

    /**
     * Process an article and stores important information
     * <p>
     * This method reads a .txt file, removes stop words, counts total words and unique words, calculates richness,
     * ranks words based on usage, counts negative and positive words, calculates attitude, and assigns these values to
     * its fields with help of methods from other classes
     * @param filePath File path of article to be processed and assessed as part of ReadTxtFile object.
     * @see StopWordRemover Has method used to remove stop words from ArrayList with words.
     * @see WordAttitudeChecker Has method that calculates the attitude of article.
     * @see NegativeWordCounter Has method that counts the number of negative words in article.
     * @see PositiveWordCounter Has method that counts the number of positive words in article.
     */
    public void ReadFile(String filePath) {
        try{
            File obj = new File(filePath);
            Scanner Reader = new Scanner(obj);
            while(Reader.hasNext()){
                String word = Reader.next();
                word=word.strip().toLowerCase();
                word=word.replaceAll("[^a-zA-Z0-9]", "");
                if(word!=""){
                    words.add(word);
                }
            }

            Reader.close();
            StopWordRemover.removeStopWords(words);
            wordCount = wordCounter();
            uniqueWordCount = UniqueWordCounter();
            richness=(int)(((double)(uniqueWordCount)/wordCount)*100);
            rankFrequency();
            negativeWordCount=NegativeWordCounter.negativeWordCheck(words);
            positiveWordCount=PositiveWordCounter.positiveWordCheck(words);
            attitudeScore=WordAttitudeChecker.AttitudeCalculator(words);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    /**
     * This method counts the elements in 'words'
     * @return int value with the amount of elements in the 'words' ArrayList
     */
    public int wordCounter() {
        return words.size();
    }

    /**
     * This method traverses the 'words' ArrayList using an enhanced for-loop to count unique words
     * <p>
     * This method processes 'words' and uses the values to update the 'uniqueWords' and 'uniqueWordFrequency' ArrayLists
     * For every new word, if it is found in 'uniqueWords' it increments the corresponding value in 'uniqueWordFrequency'
     * representing how many times it appears. if the word is not found, it is added to 'uniqueWords' and a new corresponding
     * element with the value of 1 is added to 'uniqueWordFrequency'.
     * @return int value with the amount of different words found within the article
     */
    public int UniqueWordCounter() {
        for (String word : words) {
            int index = uniqueWords.indexOf(word); // -1 if it never occurs
            if (index != -1) { //
                // If the word exists in uniqueWords, increment the count
                uniqueWordFrequency.set(index, uniqueWordFrequency.get(index) + 1);
            } else {
                // If the word is not found, add it to uniqueWords and set its count to 1
                uniqueWords.add(word);
                uniqueWordFrequency.add(1);
            }
        }
        return uniqueWords.size();
    }

    /**
     * This method takes the 'uniqueWordFrequency' ArrayList and uses the values to organize it from the greatest value
     * to the least value. When rearranging the elements, it also rearranges the same elements in 'uniqueWords' as they
     * are parallel ArrayLists with corresponding values.
     */
    public void rankFrequency(){
        for (int i = 0; i < uniqueWordFrequency.size() - 1; i++) {
            for (int j = 0; j < uniqueWordFrequency.size() - i - 1; j++) {
                if (uniqueWordFrequency.get(j) < uniqueWordFrequency.get(j + 1)) {
                    // Swaps the frequency of each word
                    int tempCount = uniqueWordFrequency.get(j);
                    uniqueWordFrequency.set(j, uniqueWordFrequency.get(j + 1));
                    uniqueWordFrequency.set(j + 1, tempCount);

                    // Swap corresponding words that match frequency
                    String tempWord = uniqueWords.get(j);
                    uniqueWords.set(j, uniqueWords.get(j + 1));
                    uniqueWords.set(j + 1, tempWord);
                }
            }
        }
    }
}
