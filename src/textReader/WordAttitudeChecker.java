package textReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The WordAttitudeChecker Class reads a file that has a list of words with their corresponding lexicon values. It then
 * uses this information to calculate the attitude of the article.
 */
public class WordAttitudeChecker {
    /**
     * This method takes an ArrayList and compares it to two parallel ArrayLists, 'lexicon' and 'scores', to assign a
     * number value to each word that appears in the article. First, each line in 'lexicon_scores.txt' is read to
     * the 'lexicon' ArrayList. Each element, excluding 3 words that do not have scores so they get skipped, are added
     * to 'attitudeWords' after trimming the score from the end. This score is added to a parallel ArrayList called
     * 'scores'. If a word from the ArrayList used as a parameter is found in 'attitudeWords', the corresponding score
     * is added to the attitude score that is returned at the end of the methods runtime.
     *
     * @param words This is an Arraylist that has all the words from the processed article
     * @return an int value that represents the attitude score of the articles.
     * @throws FileNotFoundException if lexicon text file is not found
     */
    public static int AttitudeCalculator(ArrayList<String> words) throws FileNotFoundException {
        int attitudeScore=0;
        ArrayList<String> lexicon = new ArrayList<>();
        ArrayList<Double> scores = new ArrayList<>();
        ArrayList<String> attitudeWords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/DataSets/lexicon_scores.txt"))) {
            String word;

            while ((word = br.readLine()) != null) {
                lexicon.add(word);
            }

            br.close();

            for (int i =0; i < lexicon.size(); i++) {

                // Skips the 3 lines that do not have a score attached to their values
                if(i!=819){
                    if(i!=2424){
                        if(i!=5467){
                            attitudeWords.add(lexicon.get(i).substring(0,lexicon.get(i).length()-4).trim());
                            scores.add(Double.parseDouble(lexicon.get(i).substring(lexicon.get(i).length()-4).trim()));
                        }
                    }
                }
            }

//            System.out.println(attitudeWords.size());
//            System.out.println(attitudeWords.getLast());
//            System.out.println(scores);
//            System.out.println(scores.getLast());

            double tempScore=0;
            for (int i = 0; i < attitudeWords.size(); i++) {
                for (int j = 0; j < words.size(); j++) {
                    if(words.get(j).equalsIgnoreCase(attitudeWords.get(i))){
                        tempScore += scores.get(i);
                    }
                }
            }
            // scores are rounded to the int to prevent number with long decimals due to double approximations
            attitudeScore = (int) tempScore;
            return attitudeScore;




        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return 0;
        }


    }
}
