package package_bookmanager.book;

public class BookList {
    private Book[] books = new Book[100];
    private int size;

    public BookList() {
        books[0] = new Book("金瓶梅", "001", "兰陵笑笑生", 100, "古典小说", false);
        books[1] = new Book("水浒传", "002", "施耐庵", 100, "古典名著", false);
        books[2] = new Book("西游记", "003", "吴承恩", 100, "古典名著", false);
        size = 3;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void setBooks(int index, Book book) {
        books[index] = book;
    }

}
