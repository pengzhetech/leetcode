/**
 * @author pengzhe
 * @date 2020/9/20 20:45
 * @description
 */

public class TrieNode {

    // R links to node children
    public TrieNode[] links;

    public final int R = 26;

    public boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
