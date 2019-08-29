package com.gmyboy.supportdemo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by gmy on 19-8-22 15:30.
 * E-mail me via gmyboy@qq.com
 */
public class LeetcodeTest {
    public static void main(String[] args) {
//        String i = "Hello World";
//        int o = lengthOfLastWord(i);
//        System.out.println("Output : " + o);

//        int[] i = new int[]{1, 2, 9};
//        int[] o = plusOne(i);
//        System.out.println("Output : " + o[0] + "," + o[1] + "," + o[2]);

//        String a = "10", b = "11";//  0
//        String o = addBinary(a, b);
//        System.out.println("Output : " + o);

//        int i = 2147483647;
//        int o = mySqrt(i);
//        System.out.println("Output : " + o);

//        int i = 18;
//        System.out.println("Output : " + climbStairs(i));

        int[] i = new int[]{2, 2, 1};
        System.out.println("Output : " + singleNumber(i));
    }

    //https://leetcode.com/problems/length-of-last-word/
    public static int lengthOfLastWord(String s) {
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                index++;
            } else if (index == 0) {
                continue;
            } else {
                break;
            }
        }
        return index;
    }

    //https://leetcode.com/problems/plus-one/
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            return output;
        }
        return digits;
    }

    //https://leetcode.com/problems/add-binary/
    public static String addBinary(String a, String b) {
        int alen = a.length() - 1, blen = b.length() - 1;
        int aInt, bInt, sum, curser = 0;
        int maxNum = alen > blen ? alen : blen;
        char[] output = new char[maxNum + 1];
        for (int i = 0; i <= maxNum; i++) {
            if (alen >= 0) {
                aInt = a.charAt(alen--) == '1' ? 1 : 0;
            } else {
                aInt = 0;
            }
            if (blen >= 0) {
                bInt = b.charAt(blen--) == '1' ? 1 : 0;
            } else {
                bInt = 0;
            }
            sum = aInt + bInt + curser;
            if (sum == 0) {
                curser = 0;
                output[maxNum - i] = '0';
            } else if (sum == 1) {
                curser = 0;
                output[maxNum - i] = '1';
            } else if (sum == 2) {
                curser = 1;
                output[maxNum - i] = '0';
            } else if (sum == 3) {
                curser = 1;
                output[maxNum - i] = '1';
            }
        }
        return curser == 1 ? "1" + String.valueOf(output) : String.valueOf(output);
    }

    //https://leetcode.com/problems/sqrtx/
    private static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    //https://leetcode.com/problems/climbing-stairs/
    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int s1 = 1, s2 = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }

    //https://leetcode.com/problems/defanging-an-ip-address/
    public static String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
//        return address.replace(".", "[.]");
    }

    //https://leetcode.com/problems/jewels-and-stones/
    public static int numJewelsInStones(String J, String S) {
        int num = 0;
        for (char ch : S.toCharArray()) {
            if (J.indexOf(ch) > -1) {
                num++;
            }
        }
        return num;
    }

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new StringBuffer().append(chars).toString();
    }

    //https://leetcode.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        if (s == null || s.equals("")) return true;
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            while (!isLetter(s.charAt(start)) && start < end) start++;
            while (!isLetter(s.charAt(end)) && start < end) end--;
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9';
    }

    //https://leetcode.com/problems/valid-palindrome-ii   error
    public static boolean validPalindrome(String s) {
        if (s == null || s.equals("") || s.length() == 1) return true;
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.replace(i, i + 1, "");
            if (isPalindrome(sb.toString())) {
                return true;
            }
            sb.insert(i, s.charAt(i));
        }
        return false;
    }

    private static boolean isLowLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 0);
            }
        }
        return (int) map.keySet().toArray()[0];
    }

//    public static class MinStack {
//        /**
//         * initialize your data structure here.
//         */
//        public MinStack() {
//
//        }
//
//        public void push(int x) {
//
//        }
//
//        public void pop() {
//
//        }
//
//        public int top() {
//
//        }
//
//        public int getMin() {
//
//        }
//    }
}
