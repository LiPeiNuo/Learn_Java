package package_bookmanager.book;
import package_bookmanager.book.user.Admin;
import package_bookmanager.book.user.NormalUser;
import package_bookmanager.book.user.User;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args){
        BookList bookList = new BookList();
        User user = login();
        while(true){
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String name = scanner.next();
        System.out.println("请输入你的角色（1、普通用户    2、管理员）");
        int role = scanner.nextInt();
        if(role == 1){
            return new NormalUser(name);
        }
        return new Admin(name);

    }
}
