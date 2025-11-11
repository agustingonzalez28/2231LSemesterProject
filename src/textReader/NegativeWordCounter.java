package textReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The NegativeWordCounter Class has a method that takes an ArrayList of negative words and compares it to an ArrayList
 * of words to get a count of how many negative words appear
 */
public class NegativeWordCounter {
    /**
     * This method reads a .txt file with negative words, after skipping the documentation in the first 31 lines, and
     * compared it to the ArrayList taken as a parameter. Everytime a negative word appears in the ArrayList containing
     * article words, the int negativeWordCount is increased by 1.
     *
     * @param words ArrayList that stores all the words from a processed article
     * @return an int value that represents the number of negative words found in the ArrayList
     */
    public static int negativeWordCheck(ArrayList<String> words) {
        ArrayList<String> negativeWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/DataSets/negative-words.txt"))) {
            String word;

            // Read and process the file line by line
            int count=0;

            while ((word = br.readLine()) != null) {
                if (count<31){
                    count++;
                }else{
                    count++;
                    negativeWords.add(word);
                }
            }

            int negativeWordCount=0;
            for(int i=0;i<words.size();i++){
                for(int j=0;j<negativeWords.size();j++){
                    if(words.get(i).equalsIgnoreCase(negativeWords.get(j))){
                        negativeWordCount++;
                    }
                }
            }

            return negativeWordCount;



        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return 0;
        }
    }

}
