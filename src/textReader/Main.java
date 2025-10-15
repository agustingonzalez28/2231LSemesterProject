package textReader;

public class Main {

    public static void main(String[] args) {
        ReadTxtFile article1 = new ReadTxtFile("Article 1");
        article1.ReadFile("src/DataSets/BasketballArticles/Dr.JosephPark.txt");

        ReadTxtFile article2 = new ReadTxtFile("Article 2");
        article2.ReadFile("src/DataSets/BasketballArticles/NBA_players_seem_to_tear_their_Achilles.txt");

        ReadTxtFile article3 = new ReadTxtFile("Article 3");
        article3.ReadFile("src/DataSets/BasketballArticles/Tyrese_Haliburton_Is_7th_NBA_Player_This.txt");

        ReadTxtFile article4 = new ReadTxtFile("Article 4");
        article4.ReadFile("src/DataSets/BasketballArticles/Why_all_the_Achilles_injuries_in_the_NBA.txt");

        ReadTxtFile article5 = new ReadTxtFile("Article 5");
        article5.ReadFile("src/DataSets/BaseballArticles/BASEBALL:_Taking_a_Swing_With _Steroids.txt");

        ReadTxtFile article6 = new ReadTxtFile("Article 6");
        article6.ReadFile("src/DataSets/BaseballArticles/Contextualization_of_a_Shifting_Perspective_Regarding_the_Steroid_Era.txt");

        ReadTxtFile article7 = new ReadTxtFile("Article 7");
        article7.ReadFile("src/DataSets/BaseballArticles/Ringworm?_Tatis’s_Explanations_Stretch_C.txt");

        ReadTxtFile article8 = new ReadTxtFile("Article 8");
        article8.ReadFile("src/DataSets/HipHopArticles/IconCollectiveHipHopArticle.txt");

        ReadTxtFile article9 = new ReadTxtFile("Article 9");
        article9.ReadFile("src/DataSets/HipHopArticles/TimelineCarnegieHallHipHopArticle.txt");

        ReadTxtFile article10 = new ReadTxtFile("Article 10");
        article10.ReadFile("src/DataSets/HipHopArticles/YellowbrickTheEvolutionofHipHopAJourney.txt");

        FileStats.printData(article1);
        FileStats.printData(article2);
        FileStats.printData(article3);
        FileStats.printData(article4);
        FileStats.printData(article5);
        FileStats.printData(article6);
        FileStats.printData(article7);
        FileStats.printData(article8);
        FileStats.printData(article9);
        FileStats.printData(article10);
    }

}
