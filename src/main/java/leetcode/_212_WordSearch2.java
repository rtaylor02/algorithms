package leetcode;

import java.util.HashMap;
import java.util.List;

public class _212_WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        /*
        Steps:
        1) Build tries from the list of words provided. NOTE: each tries node consists of:
           a) children list: all nodes below the node
           b) is_end property: to mark the end character of a word
        1-1) Start from root node
        1-2) If the 1st letter is not found, insert a node. If found, check if 2nd letter is in the children list.
        1-3) Continue iteratively until the tries is completed for all the words.
        2) Traverse the board looking for the first letters of the words.
        3) Travers to children of the 1st node to see if a complete word exists.
        4) Any complete word found,
         */
        return null;
    }
}

class Trie {
    HashMap<Character, List<Character>> children = new HashMap<>();
    boolean isEnd;

    public void insert(char c) {
        //if (!children.containsKey()) {
            //children.put(c, )
        //}
    }
}
