package library;

import user.User;

import java.util.HashMap;

public class Register {
    HashMap<String, Book> issuedBooks;
    HashMap<String, Book> returnedBooks;

    public Register() {
        issuedBooks = new HashMap<>();
        returnedBooks = new HashMap<>();
    }

    public void addIssueRecord(User user, Book book) {
        issuedBooks.put(user.getId(), book);
    }

    public void addReturnRecord(User user, Book book) {
        returnedBooks.put(user.getId(), book);
    }

    public boolean containsIssueRecord(String userId, String bookId) {
//        System.out.println("Inside contains issue record");
//        System.out.println(issuedBooks.get(userId));
        if (!issuedBooks.containsKey(userId)) return false;
        Book book = issuedBooks.get(userId);
        if (!book.getId().equals(bookId)) return false;
        return true;
    }

    public String containsIssueRecord(String userId) {
        if (!issuedBooks.containsKey(userId)) return "";
        Book book = issuedBooks.get(userId);
        return book.getId();
    }

    public boolean containsReturnRecord(String userId, String bookId) {
        if (!returnedBooks.containsKey(userId)) return false;
        Book book = returnedBooks.get(userId);
        if (!book.getId().equals(bookId)) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(issuedBooks);
        buffer.append("\n");
        buffer.append(returnedBooks);
        buffer.append("\n");
        return buffer.toString();
    }
}
