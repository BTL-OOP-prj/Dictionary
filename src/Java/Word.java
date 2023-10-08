public class Word {
    private String Content;
    private String Type;
    private String Meaning;
    private String Example;

    /**
     * Constructor.
     */
    public Word(String Content, String Type, String Meaning, String Example) {
        this.Content = Content;
        this.Type = Type;
        this.Meaning = Meaning;
        this.Example = Example;
    }

    /**
     * Content Getter.
     */
    public String getContent() {
        return Content;
    }

    /**
     * Content Setter.
     */
    public void setContent(String Content) {
        this.Content = Content;
    }

    /**
     * Type Getter.
     */
    public String getType() {
        return Type;
    }

    /**
     * Type Setter.
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * Meaning Getter.
     */
    public String getMeaning() {
        return Meaning;
    }

    /**
     * Meaning Setter.
     */
    public void setMeaning(String Meaning) {
        this.Meaning = Meaning;
    }

    /**
     * Example Getter.
     */
    public String getExample() {
        return Example;
    }

    /**
     * Example Setter.
     */
    public void setExample(String Example) {
        this.Example = Example;
    }
}