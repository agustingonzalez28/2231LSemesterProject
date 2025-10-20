package textReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTxtFile {
    public ArrayList<String> words = new ArrayList<>();
    public ArrayList<String> uniqueWords = new ArrayList<>();
    public ArrayList<Integer> uniqueWordFrequency = new ArrayList<>();
    public int wordCount = 0;
    public int uniqueWordCount = 0;
    public String name;

    public ReadTxtFile(String name) {
        words = new ArrayList<>();
        uniqueWords = new ArrayList<>();
        uniqueWordFrequency = new ArrayList<>();
        wordCount = 0;
        uniqueWordCount = 0;
        this.name = name;
    }

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
            rankFrequency();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public int wordCounter() {
        return words.size();
    }

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