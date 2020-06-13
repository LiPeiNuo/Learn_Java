package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        //这行代码进行了向上转型，实际new的对象时ArrayList，使用collection类型的引用来保存了这个对象
        //创建Collection
        Collection<String> collection = new ArrayList<>();
        collection.add("wo");
        collection.add("shi");
        collection.add("nuonuo");

        //使用size（）方法
        System.out.println(collection.size());

        //使用isEmpty（）
        System.out.println(collection.isEmpty());
        Object[] array = collection.toArray();


        System.out.println(Arrays.toString(array));


        //使用for循环遍历集合中的元素
        for(String s : collection){
            System.out.println(s);
        }

        //使用contains方法
        System.out.println(collection.contains("nuonuo"));

        //使用remove删除元素
        collection.remove("shi");

        //使用clear清空所有元素
        collection.clear();



        //使用for循环遍历集合中的元素
        for(String s : collection){
            System.out.println(s);
        }

    }
}
