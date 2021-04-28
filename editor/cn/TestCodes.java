import org.junit.Test;

import java.util.*;

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

    @Test
    public void testMap() {

        String[] strings = {"abb", "abb", "ab", "c", "ff", "ab", "ff", "c", "ff", "c", "c"};
        System.out.println(topKFrequent(strings, 2));


    }

    public List<String> topKFrequent(String[] nums, int k) {
        //使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (String key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

}
