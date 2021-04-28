import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author pengzhe
 * @date 2021/2/28 11:28
 * @description
 */

public class TestCodes {

    @Test
    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(1);
        queue.add(5);
        queue.add(9);
        queue.forEach(System.out::println);
        System.out.println("-------------");

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));
        maxQueue.add(10);
        maxQueue.add(1);
        maxQueue.add(5);
        maxQueue.add(9);
        maxQueue.forEach(System.out::println);

        ArrayList<Integer> list = new ArrayList<>(maxQueue);

    }

    @Test
    public void test1() {
        System.out.println(reverse("I am a boy."));
    }

    private static String reverseString(String s) {
        int length = s.length();
        int begin = 0;
        int end = length - 1;

        Deque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (begin <= end) {
            char c = s.charAt(begin);
            if (word.length() != 0 && c == ' ') {
                stack.offerFirst(word.toString());
                word.setLength(0);
            } else {
                word.append(c);
            }
            begin++;
        }
        stack.offerFirst(word.toString());
        return String.join(" ", stack);

    }

    private static String reverse(String s) {
        int length = s.length();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (word.length() != 0 && c == ' ') {
                stack.offerFirst(word.toString());
                word.setLength(0);
            } else {
                word.append(c);
            }
        }
       // stack.offerFirst(word.toString());
        System.out.println(stack);
        return String.join(" ", stack);
    }

}
