import java.util.*;

class Book {
    private String title;
    private int copies;

    public Book(String title, int copies) {
        this.title = title;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public int getCopies() {
        return copies;
    }

    public void decreaseCopies() {
        if (copies > 0) {
            copies--;
        }
    }

    public void increaseCopies() {
        copies++;
    }
}

class User {
    private String username;
    private List<Book> borrowedBooks;

    public User(String username) {
        this.username = username;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 2) {
            borrowedBooks.add(book);
            book.decreaseCopies();
        } else {
            System.out.println("Borrow limit reached..");
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.increaseCopies();
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book.getTitle() + " - Copies: " + book.getCopies());
            }
        }
    }
}

public class Library_Management_System {
    public static void main(String[] args) {
        Library library = new Library();

        // Name of the books and the number of copies of books
        Book book1 = new Book("Animal Farm", 3);
        Book book2 = new Book("The Giving Tree", 2);
        Book book3 = new Book("The Little Prince", 1);

        // Adding books into the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        User u = new User("abcd"); // Name of the user

        // displaying BorrowBook
        u.borrowBook(book1);
        u.borrowBook(book2);
        
        System.out.println();

        System.out.println(u.getUsername() + "'s borrowed books:");
        for (Book borrowedBook : u.getBorrowedBooks()) {
            System.out.println(borrowedBook.getTitle());
        }
        
        System.out.println();

        // Books in the library after borrowed
        library.displayBooks();

        u.returnBook(book1);
        
        System.out.println();

        System.out.println(u.getUsername() + "'s borrowed books after returning one book:");

        // Borrowed books after returning book
        library.displayBooks();
    }
}
