package pattern.builder;

public class Book {

    private long id;
    private String title;
    private String subTitle;
    private String author;
    private String translator;
    private String publisher;
    private int price;

    public Book(long id, String title, String subTitle, String author, String translator, String publisher, int price) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.translator = translator;
        this.publisher = publisher;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getTranslator() {
        return translator;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }
}
