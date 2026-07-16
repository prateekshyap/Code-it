package library;

import java.util.HashMap;

class Library {
    HashMap<String, Book> bookShelf;

    Library() {
        bookShelf = new HashMap<>();
    }

    HashMap<String, Boolean> addDefaultBooks() {
        bookShelf.put("B1", new Book("B1", "Physics"));
        bookShelf.put("B2", new Book("B2", "Mathematics"));
        bookShelf.put("B3", new Book("B3", "English"));
        bookShelf.put("B4", new Book("B4", "Social Studies"));
        bookShelf.put("B5", new Book("B5", "Chemistry"));
        bookShelf.put("B6", new Book("B6", "Biology"));
        bookShelf.put("B7", new Book("B7", "Architecture"));
        bookShelf.put("B8", new Book("B8", "Psychology"));
        bookShelf.put("B9", new Book("B9", "Political Science"));
        bookShelf.put("B10", new Book("B10", "Economics"));

        HashMap<String, Boolean> bookShelfDetails = new HashMap<>();
        bookShelfDetails.put("B1", true);
        bookShelfDetails.put("B2", true);
        bookShelfDetails.put("B3", true);
        bookShelfDetails.put("B4", true);
        bookShelfDetails.put("B5", true);
        bookShelfDetails.put("B6", true);
        bookShelfDetails.put("B7", true);
        bookShelfDetails.put("B8", true);
        bookShelfDetails.put("B9", true);
        bookShelfDetails.put("B10", true);

        return bookShelfDetails;
    }

    HashMap<String, Boolean> addBooks(String[][] books) {
        HashMap<String, Boolean> bookShelfDetails = new HashMap<>();
        for (String[] book : books) {
            bookShelf.put(book[0], new Book(book[0], book[1]));
            bookShelfDetails.put(book[0], true);
        }
        return bookShelfDetails;
    }

    public void addBook(Book book) {
        bookShelf.put(book.getId(), book);
    }

    public Book removeBook(String bookId) {
        Book book = bookShelf.get(bookId);
        bookShelf.remove(bookId);
        return book;
    }

    public Book getBook(String bookId) {
        return bookShelf.getOrDefault(bookId, null);
    }
}
