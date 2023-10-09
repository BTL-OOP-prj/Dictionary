package main_dict;

import main_dict.Word;

public class WordsManager {

    /**
     * TrieNode.
     */
    static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isWord;
        private Word word;

        /**
         * Constructor.
         */
        public TrieNode() {
            isWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

        /**
         * getChildren.
         */
        public TrieNode[] getChildren() {
            return children;
        }

        /**
         * isWord Getter.
         */
        public boolean isWord() {
            return isWord;
        }

        /**
         * isWord Setter.
         */
        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }

        /**
         * word Getter.
         */
        public Word getWord() {
            return word;
        }

        /**
         * word Setter.
         */
        public void setWord(Word word) {
            this.word = word;
        }
    }

    static TrieNode root = new TrieNode();

    /**
     * normalizeWord.
     */
    static Word normalizeWord(Word word) {
        Word newWord = new Word(word.getContent(), word.getType(), word.getMeaning(), word.getExample());
        newWord.setContent(newWord.getContent().toLowerCase());
        newWord.setType(newWord.getType().toLowerCase());
        newWord.setMeaning(newWord.getMeaning().toLowerCase());
        newWord.setExample(newWord.getExample().toLowerCase());
        return newWord;
    }

    /**
     * insertWord.
     */
    static void insertWord(Word raw_word) {
        Word word = normalizeWord(raw_word);
        TrieNode current = root;
        for (int i = 0; i < word.getContent().length(); i++) {
            char c = word.getContent().charAt(i);
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setWord(raw_word);
        current.setIsWord(true);
    }

    /**
     * searchWord.
     * 
     * @param Content String
     * @return Word or null
     */
    static Word searchWord(String raw_Content) {
        String Content = raw_Content.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < Content.length(); i++) {
            char c = Content.charAt(i);
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                return null;
            }
            current = current.getChildren()[index];
        }
        if (current.isWord()) {
            return current.getWord();
        }
        return null;
    }

    /**
     * Suggestions.
     */
    static void suggestions(TrieNode current, String prefix) {
        if (current.isWord()) {
            System.out.println(current.getWord().getContent());
        }
        if (isEmpty(current)) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (current.getChildren()[i] != null) {
                suggestions(current.getChildren()[i], prefix + (char) (i + 'a'));
            }
        }
    }

    /**
     * isEmpty.
     */
    static boolean isEmpty(TrieNode current) {
        for (int i = 0; i < 26; i++) {
            if (current.getChildren()[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * deleteWord.
     */
    public void deleteWord(TrieNode current, String Content, int depth) {
        if (current == null) {
            return;
        }

        if (depth == Content.length() - 1) {
            if (!current.isWord()) {
                return;
            }
            current.setIsWord(false);
            if (isEmpty(current)) {
                current = null;
            }
            return;
        }

        int index = Content.charAt(depth) - 'a';
        deleteWord(current.getChildren()[index], Content, depth + 1);

        if (isEmpty(current) && current.isWord() == false) {
            current = null;
        }
    }

    /**
     * main.
     */
    // public static void main(String[] args) {
    //     WordsManager.init();

    //     Word word = new Word("Hello", "Noun", "Xin chao", "Hello World");
    //     WordsManager.insertWord(word);
    //     Word word2 = searchWord("Hello");
    //     System.out.println(word2.getContent());
    //     System.out.println(word2.getType());
    //     System.out.println(word2.getMeaning());
    //     System.out.println(word2.getExample());
    //     WordsManager.insertWord(new Word("Hello", "Noun", "Xin chao", "Hello World"));
    //     WordsManager.insertWord(new Word("Hello", "Noun", "Xin chao", "Hello World"));
    //     WordsManager.insertWord(new Word("Hello", "Noun", "Xin chao", "Hello World"));
    //     WordsManager.suggestions(root, "Hel");
    // }
}

