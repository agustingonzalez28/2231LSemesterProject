package textReader;

public class Main {

    public static void main(String[] args) {
        ReadTxtFile article1 = new ReadTxtFile("Article 1");
        article1.ReadFile("src/DataSets/BasketballArticles/Dr.JosephPark.txt");

        ReadTxtFile article2 = new ReadTxtFile("Article 2");
        article2.ReadFile("src/DataSets/BasketballArticles/NBA_players_seem_to_tear_their_Achilles.txt");

//        FileStats.printArticle(article1);
        FileStats.printData(article1);
        //FileStats.printData(article2);
        FileStats.printWordFrequency(article1);
        //FileStats.printWordFrequency(article2);
    }

}
