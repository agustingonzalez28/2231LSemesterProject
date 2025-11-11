package textReader;

import java.util.ArrayList;

/**
 * The ArticleComparer Class groups ReadTxtFile objects together in an ArrayList and compares them based on stats.
 * <p>
 * The ArticleComparer object holds an ArrayList that can hold ReadTxtFile objects. The methods within this class
 * add ReadTxtFile objects to the ArrayList of articles and rank the articles with a topic by lexicon score and
 * richness.
 */
public class ArticleComparer {
    /**
     * An ArrayList that stores the ReadTxtFiles that hold the words and statistics from the processed article.
     */
    ArrayList<ReadTxtFile> relatedArticles=new ArrayList<>();

    /**
     * This is a constructor that creates an ArticleComparer object that has an ArrayList of ReadTxtFiles
     * @param topic takes an ArrayList with the name of the topic and replaces it with relatedArticles
     */
    public ArticleComparer(ArrayList<ReadTxtFile> topic) {
        relatedArticles = topic;
    }

    /**
     * This method adds a ReadTxtFile to the ArrayList of other objects to compare it to.
     * @param article
     */
    public void addRelatedArticles(ReadTxtFile article) {
        relatedArticles.add(article);
    }

    /**
     * This method adds the attitude scores of all the elements to another ArrayList that is parallel to the relatedArticles
     * ArrayList and organizes them based on rank from highest to lowest score. The method also prints a list displaying
     * the ranks in order.
     */
    public void rankByLexicon(){
        ArrayList<Integer> attitude=new ArrayList<>();
        for (ReadTxtFile article : relatedArticles) {
            attitude.add(article.attitudeScore);
        }

        for (int i = 0; i < relatedArticles.size() - 1; i++) {
            for (int j = 0; j < attitude.size() - i - 1; j++) {
                if (attitude.get(j) < attitude.get(j + 1)) {
                    // Swaps the frequency of each word
                    int tempScore = attitude.get(j);
                    attitude.set(j, attitude.get(j + 1));
                    attitude.set(j + 1, tempScore);

                    // Swap corresponding words that match frequency
                    ReadTxtFile tempArticle = relatedArticles.get(j);
                    relatedArticles.set(j, relatedArticles.get(j + 1));
                    relatedArticles.set(j + 1, tempArticle);
                }
            }
        }

        System.out.println("Related articles ranked by lexicon score from most positive to most negative:");
        for(int i=0;i<relatedArticles.size();i++){
            System.out.println((i+1)+". "+relatedArticles.get(i).name+": "+relatedArticles.get(i).attitudeScore);
        }
        System.out.println();
    }

    /**
     * This method adds the richness scores of all the elements to another ArrayList that is parallel to the relatedArticles
     * ArrayList and organizes them based on rank from highest to lowest score. The method also prints a list displaying
     * the ranks in order.
     */
    public void rankByRichness(){
        ArrayList<Integer> richness=new ArrayList<>();
        for (ReadTxtFile article : relatedArticles) {
            richness.add(article.richness);
        }

        for (int i = 0; i < relatedArticles.size() - 1; i++) {
            for (int j = 0; j < richness.size() - i - 1; j++) {
                if (richness.get(j) < richness.get(j + 1)) {
                    // Swaps the frequency of each word
                    int tempScore = richness.get(j);
                    richness.set(j, richness.get(j + 1));
                    richness.set(j + 1, tempScore);

                    // Swap corresponding words that match frequency
                    ReadTxtFile tempArticle = relatedArticles.get(j);
                    relatedArticles.set(j, relatedArticles.get(j + 1));
                    relatedArticles.set(j + 1, tempArticle);
                }
            }
        }

        System.out.println("Related articles ranked by vocabulary richness:");
        for(int i=0;i<relatedArticles.size();i++){
            System.out.println((i+1)+". "+relatedArticles.get(i).name+": "+relatedArticles.get(i).richness+"/100");
        }
        System.out.println();
    }

}
