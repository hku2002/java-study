package pattern.builder;

public class BookBuilder {

    private long id;
    private String title;
    private String subTitle;
    private String author;
    private String translator;
    private String publisher;
    private int price;

    public BookBuilder id(long id) {
        this.id = id;
        return this;
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder subTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder translator(String translator) {
        this.translator = translator;
        return this;
    }

    public BookBuilder publisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookBuilder price(int price) {
        this.price = price;
        return this;
    }

    public Book build() {
        return new Book(id, title, subTitle, author, translator, publisher, price);
    }
}
