package library;

public class Book {
    String id;
    String name;
    Book(String id) {
        this.id = id;
        this.name = "UNKNOWN";
    }
    Book(String id, String name) {
        this.id = id;
        this.name = name;
    }
    Book(String[] bookDetails) {
        this.id = bookDetails[0];
        this.name = bookDetails[1];
    }

    public String getId() { return this.id; }

    @Override
    public String toString() {
        return id+": "+name;
    }
}
