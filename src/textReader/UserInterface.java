package textReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The UserInterface Class prints an interface in the console that allows end users to access method for
 * this program.
 */
public class UserInterface {
    /**
     * This method prints the interface necessary for a user to use the program. Has different options
     * and calls the necessary methods for the program to present those options to the user.
     */
    public static void gui() throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Welcome to TextReader!");
            System.out.println("Please select an option:");
            System.out.println("1. Search a Topic");
            System.out.println("2. Add a Topic");
            System.out.println("3. Add an Article");
            System.out.println("4. Close the TextReader");
            System.out.print("Choose option: ");

            if(kb.hasNextLine()){
                int option = kb.nextInt();
                kb.nextLine();

                if (option == 1) {
                    System.out.println();
                    System.out.println("You selected option " + option);
                    System.out.print("Please enter the topic name: ");
                    String topicName = kb.nextLine();
                    option1(topicName);
                    System.out.println();
                } else if (option == 2) {
                    System.out.println("You selected option " + option);
                    System.out.print("Please enter the topic name: ");
                    String newTopicName = kb.nextLine();
                    option2(newTopicName);
                    System.out.println();
                } else if (option == 3) {
                    System.out.println("You selected option " + option);
                    option3();
                    System.out.println();
                } else if (option == 4) {
                    System.out.println("You selected option " + option);
                    System.out.println("Thank you for using TextReader!");
                    run = false;
                } else {
                    System.out.println("Please select a valid option!");
                }
            }else{
                String invalidInput = kb.nextLine();
                System.out.println("Error: Invalid input '" + invalidInput + "'. Please enter a number (1-4).");
            }

        }


    }

    /**
     * This method prints out data related to the topic input by users who chose
     * the first option in the gui() method.
     *
     * @param topicName A String that is the name of topic the user wants to access
     */
    public static void option1(String topicName) {
        ArticleComparer foundTopic = TopicManager.getTopicByName(topicName);

        if (foundTopic != null) {
            System.out.println("--- Topic Found: " + topicName.toUpperCase() + " ---");
            foundTopic.rankByLexicon();
            foundTopic.rankByRichness();
        } else {
            System.out.println("Error: Topic '" + topicName + "' not found in the system.");
        }
    }

    /**
     * This method allows users to add topics when they choose option 2 in the gui() method
     *
     * @param newTopicName A String that is the name of a new topic the user would like to add and analyze
     */
    public static void option2(String newTopicName) throws FileNotFoundException {
        ArrayList<ReadTxtFile> newArticles=new ArrayList<>();
        ArticleComparer newTopic=new ArticleComparer( newArticles);
        TopicManager.registerTopic(newTopicName, newTopic);
        Scanner kb = new Scanner(System.in);

        int decision = 1;
        while (decision == 1) {
            System.out.println("Would you like to add articles to this topic? Type 1 if yes, 2 if no");

            String choiceInput = kb.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                choice = 0;
            }

            if (choice == 2) {
                decision = 2;
            } else if (choice == 1) {
                System.out.print("Please enter article name: ");
                String articleName = kb.nextLine();
                System.out.println();
                try{
                    ReadTxtFile newFile = new ReadTxtFile(articleName);
                    System.out.print("Please enter the file path: ");
                    String path = kb.nextLine();
                    newFile.ReadFile(path);
                    System.out.println();
                    if (newFile.wordCount > 0) {
                        newTopic.addRelatedArticles(newFile);
                        System.out.println("Article added successfully.");
                    } else {
                        System.out.println("Article NOT added to topic. The file was not found or was empty.");
                    }
                }catch (FileNotFoundException e){
                    System.out.println("Error: Article NOT added to topic. File not found.");
                }


            } else {
                System.out.println("Error! Please choose a valid option!");
            }
        }
    }

    /**
     * This method prints out prompts and scanners for users who chose the third option in the gui() method
     * to add articles to the data set and existing topics.
     */
    public static void option3() throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please select an option:");
        System.out.println("1. Add Article to DataSet");
        System.out.println("2. Add an Article to existing topic");
        int choice = kb.nextInt();
        kb.nextLine();
        if (choice == 1) {
            System.out.print("Please enter the path of article to be added: ");
            String path = kb.nextLine();
            FileMover.fileMover(path);
        } else if (choice == 2) {
            System.out.println("Please enter the topic name for the article to be added to: ");
            String topicName = kb.nextLine();
            ArticleComparer foundTopic = TopicManager.getTopicByName(topicName);
            System.out.print("Please enter article name:");
            String articleName = kb.nextLine();
            System.out.println();
            ReadTxtFile newFile = new ReadTxtFile(articleName);
            System.out.println("Please enter the file path");
            String path = kb.nextLine();
            newFile.ReadFile(path);
            System.out.println();
            foundTopic.addRelatedArticles(newFile);
            System.out.println("If file exists, Article added successfully.");
        } else {
            System.out.println("Error! Please choose a valid option!");
        }
    }
}
