package library;

import java.util.HashMap;

import user.AccountManager;
import user.User;

public class LibraryManager {
    Library library;
    HashMap<String, Boolean> booksList;
    AccountManager accountManager;
    Register register;

    public LibraryManager() {
        library = new Library();
        booksList = library.addDefaultBooks();
        accountManager = new AccountManager();
        register = new Register();
    }

    public LibraryManager(String[][] books) {
        library = new Library();
        booksList = library.addBooks(books);
        accountManager = new AccountManager();
        register = new Register();
    }

    public boolean addBook(String[] bookDetails) {
        if (booksList.containsKey(bookDetails[0])) return false;
        library.addBook(new Book(bookDetails));
        booksList.put(bookDetails[0], true);
        return true;
    }

    public boolean issueBook(String userId, String userName, String contact, String bookId) {
//        System.out.println(register.issuedBooks+" "+register.returnedBooks);
        User user = accountManager.getUser(userId, userName, contact);
        String issuedBookId = register.containsIssueRecord(userId);
        if (issuedBookId != "" && !register.containsReturnRecord(userId, issuedBookId)) return false;
        if (booksList.get(bookId)) {
            Book targetBook = library.getBook(bookId);
            register.addIssueRecord(user, targetBook);
            booksList.put(bookId, false);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(String userId, String userName, String contact, String bookId) {
//        System.out.println(register.issuedBooks+" "+register.returnedBooks);
//        System.out.println("Inside return book");
        if (!register.containsIssueRecord(userId, bookId)) return false;
        User user = accountManager.getUser(userId, userName, contact);
        Book targetBook = library.getBook(bookId);
        register.addReturnRecord(user, targetBook);
        booksList.put(bookId, true);
        return true;
    }

    @Override
    public String toString() {
        return register.toString();
    }
}
