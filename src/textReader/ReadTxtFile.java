package textReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ReadTxtFile {
    public ArrayList<String> words = new ArrayList<>();
    public int wordCount = 0;
    public int uniqueWordCount = 0;
    public String name;

    public ReadTxtFile(String name) {
        words = new ArrayList<>();
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
            uniqueWordCount = uniqueWordCounter();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    public int wordCounter() {
        return words.size();
    }

    public int uniqueWordCounter() {
        Set<Integer> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.hashCode());
        }
        return uniqueWords.size();
    }

    public void wordFrequency(){
        Map<String, Integer> wordFrequency = new HashMap<>();
        for(String word: words){
            if(!(wordFrequency.containsKey(word))){
                wordFrequency.put(word, 1);
            }else{
                wordFrequency.put(word, wordFrequency.get(word)+1);
            }
        }
        System.out.println(wordFrequency.size());
        System.out.println(wordFrequency);
    }

    public static void printArticle(ReadTxtFile article) {
        for(String word : article.words) {
            System.out.println(word);
        }
    }


}