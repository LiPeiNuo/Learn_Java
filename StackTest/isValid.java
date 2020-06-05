package StackTest;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
通过次数291,374提交次数698,688
在真实的面试中遇到过这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
*/

public class isValid {
    public static boolean isValid(String s) {
        Stack <Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c =='[' || c == '{'){
                stack.push(c);
            }
            else{
                if (stack.empty()){
                    return false;
                }
                char top = stack.pop();
                if((c != ')' && top == '(') || (c !=']' && top == ']') ||(c !='}' &&  top =='{') ){
                    return false;
                }
            }
        }
        return stack.empty();
    }


    public static boolean isValid_2(String s) {
        Stack<Character> stack = new Stack();
        Map<Character,Character> map = new HashMap();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c =='(' || c =='{' || c == '['){
                stack.push(c);
            }
            else{
                if (stack.empty()){
                    return false;
                }
                char top = stack.pop();
                if(map.get(top) !=c){
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
