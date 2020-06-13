package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        //使用size获取键值对的个数
        System.out.println(map.size());

        //使用isEmpty查看是否为空
        System.out.println(map.isEmpty());

        //存放键值对
        map.put("及时雨","宋江");
        map.put("nuonuo", "haha");
        map.put("peipei","hehe");

        //使用get方法根据key查找对应的value
        //如果key不存在，则返回null
        //getOrDefault,如果key不存在则返回默认值
        System.out.println(map.get("nuonuo"));
        System.out.println(map.get("lipeinuo"));
        System.out.println(map.getOrDefault("行者", "武松"));

        //通过containskey和containsvalue来查看某个值是否存在
        //containskey 执行效率高  containsValue的效率底
        System.out.println(map.containsKey("peipei"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());

        //for each遍历map中的所有键值对
        //map.entrySet能获取到所有键值对
        //map中元素顺序和插入顺序无关
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
