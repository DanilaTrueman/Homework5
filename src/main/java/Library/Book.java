package Library;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private int year;
    private String description;

    public Book(int id, String title, String genre, String author, int year, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }
}