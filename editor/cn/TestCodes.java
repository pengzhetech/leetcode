import org.junit.Test;

import java.util.ArrayList;
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

}
