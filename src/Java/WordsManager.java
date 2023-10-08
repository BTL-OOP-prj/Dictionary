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

    static TrieNode root;

    /**
     * Constructor.
     */
    static WordsManager() {
        root = new TrieNode();
    }

    /**
     * normalizeWord.
     */
    static void normalizeWord(Word word) {
        word.setContent(word.getContent().toLowerCase());
        word.setType(word.getType().toLowerCase());
        word.setMeaning(word.getMeaning().toLowerCase());
        word.setExample(word.getExample().toLowerCase());
    }

    /**
     * insertWord.
     */
    static void insertWord(Word word) {
        normalizeWord(word);
        TrieNode current = root;
        for (int i = 0; i < word.getContent().length(); i++) {
            char c = word.getContent().charAt(i);
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setWord(word);
        current.setIsWord(true);
    }

    /**
     * searchWord.
     * 
     * @param Content String
     * @return Word or null
     */
    static Word searchWord(String Content) {
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
            System.out.println(prefix);
        }
        if (isEmpty(current)) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (current.getChildren()[i] != null) {
                suggestions(current.getChildren()[i], prefix + (char) (i + 'a'));
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

        if (depth == Content.length()) {
            if (!current.isWord()) {
                return;
            }
            current.setIsWord(false);
            if (isEmpty(current)) {
                current = null;
            }
            return;
        }

        int index = Content.charAt(index) - 'a';
        deleteWord(current.getChildren()[index], Content, depth + 1);

        if (isEmpty(current) && current.isWord() == false) {
            current = null;
        }
    }
}

