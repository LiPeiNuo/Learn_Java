package package_bookmanager.book.operation;

import package_bookmanager.book.Book;
import package_bookmanager.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅的编号");
        String id = scanner.next();
        for ( int i = 0; i<bookList.getSize();i++){
            Book book = bookList.getBook(i);
            if(!book.getId().equals(id)){
                continue;
            }
            if(book.getBorrow()){
                System.out.println("这本书已经被借走了");
                break;
            }
            book.setBorrow(true);
        }

    }
}
