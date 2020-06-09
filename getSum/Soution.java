package getSum;
/*
* 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3
示例 2:

输入: a = -2, b = 3
输出: 1
通过次数29,663提交次数53,943

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-two-integers
*/

public class Soution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 当进位不为0时
            // 无进位累加值
            int temp = a ^ b;

            // 进位值
            int carry = (a & b) << 1;

            // a=无进位累加值 b=进位值
            a = temp;
            b = carry;
        }
        return a;
    }
}
