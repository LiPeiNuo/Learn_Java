package package_bookmanager.book.operation;

import package_bookmanager.book.Book;
import package_bookmanager.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的序号");
        String id = scanner.next();
        int i = 0;
        for(; i <bookList.getSize();i++){

            Book book = bookList.getBook(i);
            if(book.getId().equals(id)){
                break;
            }
        }
        if(i>= bookList.getSize()){
            return;
        }
        Book lastBoook = bookList.getBook(bookList.getSize()-1);
        bookList.setBooks(i, lastBoook);
        bookList.setSize(bookList.getSize()-1);
    }
}
