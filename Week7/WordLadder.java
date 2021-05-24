package leetcode.editor.cn;


import java.util.*;


public class WordLadder {

    public static void main (String[] args) {
        Solution solution = new WordLadder().new Solution();
        //TODO TEST
        solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双向BFS
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            Set<String> visitedSet = new HashSet<>();

            if (!wordSet.contains(endWord)) return 0;

            int result = 1;
            beginSet.add(beginWord);
            endSet.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> tmpSet = beginSet;
                    beginSet = endSet;
                    endSet = tmpSet;
                }

                Set<String> newAddedSet = new HashSet<>();
                for (String word: beginSet) {
                    List<String> newStringList = generNewString(word, wordSet);
                    for (String newWord: newStringList) {
                        if (endSet.contains(newWord)) {
                            return result + 1;
                        }
                        if (!visitedSet.contains(newWord)) {
                            visitedSet.add(newWord);
                            newAddedSet.add(newWord);
                        }
                    }
                }
                beginSet = newAddedSet;
                result++;
            }
            return 0;
        }

        private List<String> generNewString(String word, Set<String> wordSet) {
            List<String> resultList = new LinkedList<>();
            for (String dictWord : wordSet) {
                if (isNextWord(word, dictWord)) {
                    resultList.add(dictWord);
                }
            }
            return resultList;
        }

        private boolean isNextWord(String word, String dictWord) {
            int num = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != dictWord.charAt(i)){
                    num++;
                    if (num > 1) return false;
                }
            }
            return num == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}
