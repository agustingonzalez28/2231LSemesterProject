package textReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The PositiveWordCounter Class has a method that takes an ArrayList of positive words and compares it to an ArrayList
 * of words to get a count of how many positive words appear
 */
public class PositiveWordCounter {
    /**
     * This method reads a .txt file with positive words, after skipping the documentation in the first 30 lines, and
     * compared it to the ArrayList taken as a parameter. Everytime a positive word appears in the ArrayList containing
     * article words, the int positiveWordCount is increased by 1.
     *
     * @param words ArrayList that stores all the words from a processed article
     * @return an int value that represents the number of positive words found in the ArrayList
     */
    public static int positiveWordCheck(ArrayList<String> words) {
        ArrayList<String> positiveWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/DataSets/positive-words.txt"))) {
            String word;

            // Read and process the file line by line
            int count=0;

            while ((word = br.readLine()) != null) {
                if (count<30){
                    count++;
                }else{
                    count++;
                    positiveWords.add(word);
                }
            }

            int positiveWordCount=0;
            for(int i=0;i<words.size();i++){
                for(int j=0;j<positiveWords.size();j++){
                    if(words.get(i).equals(positiveWords.get(j))){
                        positiveWordCount++;
                    }
                }
            }

            return positiveWordCount;

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return 0;
        }
    }

}
