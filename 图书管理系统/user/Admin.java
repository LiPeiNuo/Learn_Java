package package_bookmanager.book.user;

import package_bookmanager.book.operation.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        super(name);
        operations = new IOperation[]{
                new ExitOperation(),
                 new FindOperation(),
                 new AddOperation(),
                 new DelOperation(),
                 new PrintAllOperation()
        };
    }

    @Override
     public int menu() {
        System.out.println("-------------");
        System.out.println("1、查找书籍");
        System.out.println("2、增加书籍");
        System.out.println("3、删除书籍");
        System.out.println("4、打印所有信息");
        System.out.println("0、退出");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
