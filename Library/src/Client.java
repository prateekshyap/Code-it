import library.LibraryManager;

class Request {
    String userId, userName, contact, bookId;
    Request(String userId, String userName, String contact, String bookId) {
        this.bookId = bookId;
        this.contact = contact;
        this.userId = userId;
        this.userName = userName;
    }
}

public class Client {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        Request[] issueList = new Request[5];
        issueList[0] = new Request("john1", "John D", "982163892", "B2");
        issueList[1] = new Request("john2", "John B", "18989368", "B6");
        issueList[2] = new Request("ayden", "Ayden H", "289893", "B4");
        issueList[3] = new Request("john1", "John D", "982163892", "B1");
        issueList[4] = new Request("john2", "John B", "18989368", "B4");


        for (Request userDetails: issueList) {
            boolean isBookIssued = libraryManager.issueBook(userDetails.userId, userDetails.userName,
                    userDetails.contact, userDetails.bookId);
            System.out.println(isBookIssued ?
                    userDetails.bookId+" issued for "+userDetails.userName
                    : userDetails.bookId+" not issued for "+userDetails.userName);
        }

        System.out.println(libraryManager);

        Request[] returnList = new Request[3];
        returnList[0] = new Request("john1", "John D", "982163892", "B2");
        returnList[1] = new Request("john2", "John B", "18989368", "B6");
        returnList[2] = new Request("ayden", "Ayden H", "289893", "B4");

        for (Request userDetails: returnList) {
            boolean isBookReturned = libraryManager.returnBook(userDetails.userId, userDetails.userName,
                    userDetails.contact, userDetails.bookId);
            System.out.println(isBookReturned ?
                    userDetails.userId+" returned "+userDetails.bookId
                    : userDetails.userId+" could not return "+userDetails.bookId);
        }

        System.out.println(libraryManager);
    }
}
