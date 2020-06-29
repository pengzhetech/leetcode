此题可以用栈，这种FILO特性的数据结构来解决，遇到左括号，将其压栈，右括号则将相应左括号和该右括号匹配，存入一个新的数组。
需要以下额外空间：
wordList[]:用来将s转换成字符数组;
stack:压栈出栈操作;
wordArray[]:用来存放整理好的字符数组.
eg. s = "{[()[]]}"; 
wordList[] = {{, [, (, ), [, ], ], }};八个元素
wordArray[] = {(, ), [, ], [, ], {, }};



```
import java.util.*;

class Solution {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	char[] wordList = s.toCharArray();
    	char[] wordArray = new char[s.length()];
    	int cnt = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (wordList[i] == '(' || wordList[i] == '[' || wordList[i] == '{') {
    			stack.push(wordList[i]);
    		}
    		else {
    			if (stack.isEmpty()) {
    				return false;
    			}
          wordArray[cnt] = stack.peek();
    			cnt++;
    			
    			stack.pop();
    			wordArray[cnt] = wordList[i];
    			cnt++;
    		}
    	}
    	int correct = 0;
    	for (int i = 0; i < wordArray.length - 1; i += 2) {
    		if (wordArray[i] == '(' && wordArray[i + 1] == ')' || wordArray[i] == '[' && wordArray[i + 1] == ']' || wordArray[i] == '{' && wordArray[i + 1] == '}') {
    			correct += 2;
    		}
    	}
      
    	return (correct == wordArray.length) ? true : false;
    }
}
```
该程序时间复杂度和空间复杂度均为O(n).