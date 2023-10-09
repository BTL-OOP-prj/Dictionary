package main_dict;

import java.io.*;
import java.util.Scanner;
import main_dict.Word;
import main_dict.WordsManager;

public class dbToManager {

    /**
     * split.
     */
    public static String[] split(String str, String delimiter) {
        String[] result = new String[4];
        int index = str.indexOf(delimiter);
        //check content
        if (index == -1) {
            result[0] = "";
        }
        else {
            result[0] = str.substring(0, index);
            str = str.substring(index + 1);
        }
        //check type
        index = str.indexOf(delimiter);
        if (index == -1) {
            result[1] = "";
        }
        else {
            result[1] = str.substring(0, index);
            str = str.substring(index + 1);
        }
        //check meaning
        index = str.indexOf(delimiter);
        if (index == -1) {
            result[2] = "";
        }
        else {
            result[2] = str.substring(0, index);
            str = str.substring(index + 1);
        }
        //check example
        index = str.indexOf(delimiter);
        if (index == -1) {
            result[3] = "";
        }
        else {
            result[3] = str.substring(0, index);
            str = str.substring(index + 1);
        }
        return result;
    }

    /**
     * Scan the database and add all words to the manager.
     */
    public static void scan(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            sc.nextLine();
            sc.useDelimiter(",|\n");
            while (sc.hasNextLine()) {
                String curLine = sc.nextLine();
                String[] curWord = split(curLine, ",");
                String Content = curWord[0];
                String Type = curWord[1];
                String Meaning = curWord[2];
                String Example = curWord[3];
                if (Content.indexOf(" ") != -1 || Content.indexOf("-") != -1 || Content.indexOf("'") != -1 ||
                    Content.indexOf(".") != -1 || Content.indexOf(",") != -1 || Content.indexOf("?") != -1 ||
                    Content.indexOf("!") != -1 || Content.indexOf(":") != -1 || Content.indexOf(";") != -1 ||
                    Content.indexOf("\"") != -1 || Content.indexOf("(") != -1 || Content.indexOf(")") != -1 ||
                    Content.indexOf("[") != -1 || Content.indexOf("]") != -1 || Content.indexOf("{") != -1 ||
                    Content.indexOf("}") != -1 || Content.indexOf("/") != -1 || Content.indexOf("\\") != -1 ||
                    Content.indexOf("<") != -1 || Content.indexOf(">") != -1 || Content.indexOf("|") != -1 ||
                    Content.indexOf("*") != -1 || Content.indexOf("&") != -1 || Content.indexOf("^") != -1 ||
                    Content.indexOf("%") != -1 || Content.indexOf("$") != -1 || Content.indexOf("#") != -1 ||
                    Content.indexOf("@") != -1 || Content.indexOf("~") != -1 || Content.indexOf("`") != -1 ||
                    Content.indexOf("+") != -1 || Content.indexOf("=") != -1 || Content.indexOf("-") != -1 ||
                    Content.indexOf("_") != -1 || Content.indexOf("0") != -1 || Content.indexOf("1") != -1 ||
                    Content.indexOf("2") != -1 || Content.indexOf("3") != -1 || Content.indexOf("4") != -1 ||
                    Content.indexOf("5") != -1 || Content.indexOf("6") != -1 || Content.indexOf("7") != -1 ||
                    Content.indexOf("8") != -1 || Content.indexOf("9") != -1) {
                    continue;
                }
                Word word = new Word(Content, Type, Meaning, Example);
                WordsManager.insertWord(word);
                // System.out.println(word.toString());
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        scan("E:/Dictionary/src/DB/Eng.csv");
        WordsManager.suggestions("al");
    }

}