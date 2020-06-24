package edu.slovak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
    @author Vladyslav Zavada KHNUE
    @version 1.0

    Classname Main

    Laboratory work 1:
    1. Find the longest word in the above text.
    2. Count the LINES where the word "Harry" is met.
    3. Take  the array of distinct words from Harry Potter . Create an array of hashes.
    4. Count the intersections of hashes.

*/
public class Main {

    public static void main(String[] args) throws IOException {

        // get text from the file
        String text = new String(Files.readAllBytes(Paths.get("D:\\harry.txt")));
        // Cleaning the text from punctuation marks
        String[] allWords = text
                .toLowerCase()
                .replaceAll("[\\s\\.\\?\\!,\\-\":;]+", " ")
                .split("\\s+");

        String longestWord = "";

        // find the longest word
        for (String word : allWords) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("The longest word in the text: " + longestWord);

        String[] lines = text.split("\n");
        int linesWithHarry = 0;

        // find number of lines with word "Harry"
        for (String line : lines) {
            if (line.contains("Harry")) {
                linesWithHarry++;
            }
        }

        System.out.println("Number of lines where the word Harry is met: " + linesWithHarry);
        String uniqueWords = "";
        String wordsWithIntersections = "";
        String hashesString = "";


        for (String word : allWords) {
            if (uniqueWords.contains(word) && !wordsWithIntersections.contains(word)) {
                wordsWithIntersections += word + " ";
            } else if (!uniqueWords.contains(word)) {
                uniqueWords += word + " "; // add words to uniqueWords if it's first occurrence
                hashesString += word.hashCode() + " ";
            }
        }

        String[] uniqueWordsArray = uniqueWords.split(" ");
        String[] hashesArray = hashesString.split(" ");

        System.out.println("Array of distinct words: ");
        for (String word : uniqueWordsArray) {
            System.out.println(word);
        }

        System.out.println("Array of distinct words hashes: ");
        for (String hash : hashesArray) {
            System.out.println(hash);
        }

        int countWords = wordsWithIntersections.split(" ").length;

        System.out.println("Number of words with intersections: " + countWords);

    }
}