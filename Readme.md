# CPSC2231L - Programming Workshop Semester Project

By: Agustin Gonzalez & Obiako Nwakile\
Last Updated: 10/20/2025

## Introduction

This project is program for analyzing articles stored in text files. It includes all the files that are necessary to make the java project work in analyzing the articles stored in .txt files. This program takes the articles, removes the stop words, counts the remaining word count, identifies how many unique words appear in the articles and ranks them based on frequency.<br><br>It has two folders, DataSets and textReader, and all the files in those folders can be accesed from within the code.
Below is descriptions of all the files in our project.

## Data Set Information

This program would work with any articles that are stored in text files. The program pulls directly from a specific file path input when creating `ReadTxtFile(String name)` objects. The "DataSets" folder in the program is preloaded with 10 articles related to each of the 3 following topics:

- Steroids in Baseball (3 articles)
- History of Hip-Hop (3 articles)
- Achilles Tears in Basketball (4 articles)

In addition, there is also a text file with all the stop words that need to be removed from the articles. This file is accessed through the use of a Scanner in the StopWordRemover Class. There are also 3 files, lexicon_scores.txt, negative-words.txt, and positive-words.txt, information used to validate the attitude of the articles.In this folder you can also find an empty folder called NewArticles where articles added by the user will be stored.

## textReader Package Information

This is the main package for this program, in its current state. It includes 11 .java files storing java classes. These classes are needed to process the text files, collecting the words and analyzing them. The 11 classes are:

- ReadTxtFile Class
- FileStats Class
- StopWordRemover Class
- NegativeWordCounter Class
- PositiveWordCounter Class
- WordAttitudeChecker Class
- ArticleComparer Class
- FileMover Class
- UserInterface Class
- TopicManager Class
- Main Class

#### Imported Java Classes:

We imported 14 Java Classes necessary for processing the words from the text file and collecting them for analysis.

- java.io.File
- java.io.FileNotFoundException
- java.io.BufferedReader;
- java.io.FileReader;
- java.io.IOException;
- java.util.ArrayList
- java.util.Set
- java.util.HashSet
- java.util.Scanner
- java.util.HashMap
- java.util.Map
- java.nio.Files
- java.nio.Paths
- java.nio.Path

### ReadTxtFile Class

This class includes all of the methods necessary for reading the txt files stored in the "data sets" folder.

#### The ReadTxtFile Class has 10 fields:

These are the instance variables we used for storing the information collected from the articles.

- words: public ArrayList containing Strings
- uniqueWords: public ArrayList containing Strings
- uniqueWordFrequency: public ArrayList containing Integers
- wordCount: public variable storing an int values
- uniqueWordCount: public variable storing an int value
- positiveWordCount: public variable storing an int value
- negativeWordCount: public variable storing an int value
- attitudeScore: public variable storing an int value
- richness: public variable storing an int value
- name: public variable storing a String value

uniqueWords and uniqueWordFrequency are parallel ArrayLists with the a word in one ArrayList and the amount of times it appears in the corresponding index position of the other list.

#### Key Features

- Collects data and measures stats from text files after they are processed.
- Makes calls to StopWordRemover class to remove stop words when converting articles into ArrayLists.

#### Methods

- `ReadFile(String filePath)` - Takes file from a specific file path and converts text into ArrayList, while removing stop words and collecting stats in the process.
- `wordCounter()` - Returns amount of words in article after
- `UniqeWordCounter()` - Traverses word ArrayList, and updates uniqueWords and uniqueWordFrequency ArrayLists, updating them with each word and how many times each word appears respectively. Returns how many unique words there are.
- `rankFrequency()` - Traverses uniqueWords and uniqueWordFrequency rearranging ArrayList based on descending order of word usage.

### FileStats Class

#### Key Features

- Takes a ReadTxtFile object and prints all the related information.

#### Key Methods

- `printData(ReadTxtFile article)` - Prints with context, object name, word count, number of unique words, and the 5 most used words in the article.

### StopWordRemover Class

#### Key Features

- Reads a text file containing stop words and converts it into a HashSet.
- Is used by ReadTxtFile class to remove stop words from words ArrayList.

#### Key Methods

- `removeStopWords(ArrayList<String> words)` - When called creates a HashSet and removes every word in that HashSet from an ArrayList of Strings.

### NegativeWordCounter Class

#### Key Features

- Reads a text file containing negative words and converts it into an ArrayList.
- Compares ArrayList of words to negative words and returns a count of how many exist in the article.

#### Key Methods

- `negativeWordCheck(ArrayList<String> words)` - When called creates an ArrayList and compares it to words, returning a count of how many times they appear in words.

### PositiveWordCounter Class

#### Key Features

- Reads a text file containing positive words and converts it into an ArrayList.
- Compares ArrayList of words to positive words and returns a count of how many exist in the article.

#### Key Methods

- `positiveWordCheck(ArrayList<String> words)` - When called creates an ArrayList and compares it to words, returning a count of how many times they appear in words.

### WordAttitudeChecker Class

#### Key Features

- Reads a text file containing words and their lexicon score and makes parallel ArrayLists, skipping over words without a score.
- Compares parallel ArrayLists with ArrayList containing article words and calculates an attitude score.

#### Key Methods

- `AttitudeCalculator(ArrayList<String> words)` - When called creates two ArrayLists and compares them to words, returning a sum that represents article's lexicon sxore

### ArticleComparer Class

#### Key Features

- Groups ReadTxtFile objects by topic to be compared based on richness and attitude scores.

#### Key Methods

- `addRelatedArticles(ReadTxtFile article)` - When called, adds article to ArrayList of ReadTxtFile objects.
- `rankByLexicon()` - When called, organizes list based on lexicon score of each article and prints the list.
- `rankByRichness()` - When called, organizes list based on richness of each article and prints the list.

### FileMover Class

#### Key Features

- Takes a file from a directory input by the user and moves it to the "NewArticles" folder in the "DataSets" folder.

#### Key Methods

- `fileMover(String filePath)` - When called, takes file from specified directory and movies it to "src/DataSets/NewArticles" folder.

### UserInterface Class

#### Key Features

- Prints a user interface in the console for the end user to analyze existing articles and add articles of their own.

#### Key Methods

- `gui()` - When called, populates console with prompts for user to use program.

### TopicManager Class

#### The TopicManager Class has 1 field:

This is the instance variable we used for storing Strings and ArticleComparers in a HashMap

- topicRegistry: public static final HashMap containing Strings and ArticleComparers.

#### Key Features

- Keeps track of all article topics to make finding ArticleComparer objects possible when user inputs a related String.

#### Key Methods

- `registerTopic(String name, ArticleComparer topic)` - When called, takes a String and an ArticleComparer, storing them in topicRegistry so that topics can be accessed through a user input String.
- `getTopicByName(String name)` - When called, returns the ArticleComparer associated with the input String name.

### Main Class

#### Key Features

- Objects for each article are created and calls `gui()` from UserInterface Class to generate user interface in the console so end users can use the program.

### UML Class Diagram

![UML Class Diagram](/Milestone%203%20UML%20Diagram.png "UML Class Diagram")
