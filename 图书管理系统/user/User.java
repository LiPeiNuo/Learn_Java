package package_bookmanager.book.user;

import package_bookmanager.book.BookList;
import package_bookmanager.book.operation.IOperation;

abstract public class User {
    protected String name;
    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }

    abstract public int menu();


    public  void doOperation(int choice, BookList bookList){
        operations[choice].work(bookList);
    }
}
