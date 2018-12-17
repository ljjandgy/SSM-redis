package com.example.springredis.algorithm;

/**
 * 获取反转数
 */
public class Reverse {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //判断整数的上限
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            //判断整数（int的数据）的下限
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;//新增一位数
        }
        return rev;
    }

}
