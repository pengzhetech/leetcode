import java.io.Serializable;

/**
 * @author pengzhe
 * @date 2020/7/5 11:13
 * @description
 */

public class RandomNode implements Serializable {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
