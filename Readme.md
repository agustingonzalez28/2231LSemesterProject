# CPSC2231L - Programming Workshop Semester Project

By: Agustin Gonzalez & Obiako Nwakile\
Last Updated: 10/26/2025

## Introduction

This project is program for analyzing articles stored in text files. It includes all the files that are necessary to make the java project work in analyzing the articles stored in .txt files. This program takes the articles, removes the stop words, counts the remaining word count, identifies how many unique words appear in the articles and ranks them based on frequency.<br><br>It has two folders, DataSets and textReader, and all the files in those folders can be accesed from within the code.
Below is descriptions of all the files in our project.

## Data Set Information

This program would work with any articles that are stored in text files. The program pulls directly from a specific file path input when creating `ReadTxtFile(String name)` objects. The "DataSets" folder in the program is preloaded with 10 articles related to each of the 3 following topics:

- Steroids in Baseball (3 articles)
- History of Hip-Hop (3 articles)
- Achilles Tears in Basketball (4 articles)

In addition, there is also a text file with all the stop words that need to be removed from the articles. This file is accessed through the use of a Scanner in the StopWordRemover Class.

## textReader Package Information

This is the main package for this program, in its current state. It includes 4 .java files storing java classes. These classes are needed to process the text files, collecting the words and analyzing them. The 4 classes are:

- ReadTxtFile Class
- FileStats Class
- StopWordRemover Class
- Main Class

#### Imported Java Classes:

We imported 6 Java Classes necessary for processing the words from the text file and collecting them for analysis.

- java.io.File
- java.io.FileNotFoundException
- java.util.ArrayList
- java.util.Set
- java.util.HashSet
- java.util.Scanner

### ReadTxtFile Class

This class includes all of the methods necessary for reading the txt files stored in the "data sets" folder.

#### The ReadTxtFile Class has 6 fields:

These are the instance variables we used for storing the information collected from the articles.

- words: public ArrayList containing Strings
- uniqueWords: public ArrayList containing Strings
- uniqueWordFrequency: public ArrayList containing Integers
- wordCount: public variable storing an int values
- uniqueWordCount: public variable storing an int value
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

### Main Class

#### Key Features

- Objects for each article are created and calls `printData(ReadTxtFile article)` from FileStats Class to print information for each article.
