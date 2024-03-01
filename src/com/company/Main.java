package com.company;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    public static void main(String[] args) {
        //1
        String expression = "5+20-8+5";
        int result = evaluateExpression(expression);
        System.out.println("\nგამოსახულების შედეგი '" + expression + "' არის: " + result);

        //2
        List<String> strings = List.of("abbcc", "abc", "abcabc", "cabcbb");
        int happyCount = numberOfHappyStrings(strings);
        System.out.println("\n'ბედნიერი' სტრინგების რაოდენობა: " + happyCount);

        //3 - გთხოვთ ყურადღება მიაქციოთ ამ ამოცანისთვის შექმნილ non-public კლასს, ზემოთ
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("\nსაწყისი ლისტი:");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("დარევერსებული ლისტი:");
        printList(reversedHead);


        //4
        int[] nums1
                = { 1,2,3,3,4,5};

        int[] nums2 = { 3,4,4,5,6,7 };

        System.out.println("\nმასივი 1: "
                + Arrays.toString(nums1));
        System.out.println("მასივი 2: "
                + Arrays.toString(nums2));
        findIntersection(nums1,nums2);

        //5
        int[] array = {6, 2, 2, 3, 4, 1};
        int k = 8;
        int res = lenOfLongSubarr(array, k);
        System.out.println("\nშედეგი: " + res);

        //6
        int[] arr = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = {1, 6, -1, 10};
        boolean res1 = isValidSequence(arr, sequence);
        System.out.println("\nშედეგი: " + res1);
    }


    //1
    public static int evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }
        }


        result += sign * num;

        return result;
    }

    //2
    public static int numberOfHappyStrings(List<String> strings) {
        int happyCount = 0;

        for (String str : strings) {
            if (isHappy(str)) {
                happyCount++;
            }
        }
        return happyCount;
    }

    public static boolean isHappy(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                return false;
        }
        return true;
    }

    //3
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    //4
    public static void findIntersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        System.out.println("\nსაერთო ელემენტები " + set1);
    }

    //5
    public static int lenOfLongSubarr(int[] array, int k) {
        int maxLength = 0;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < array.length; right++) {
            currentSum += array[right];

            while (currentSum > k) {
                currentSum -= array[left];
                left++;
            }

            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }

    //6
    public static boolean isValidSequence(int[] array, int[] sequence) {
        int i = 0, j = 0;

        while (i < array.length && j < sequence.length) {
            if (array[i] == sequence[j]) {
                j++;
            }
            i++;
        }

        return j == sequence.length;
    }
}




