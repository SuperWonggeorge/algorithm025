## 本周作业

说明：作业摸版使用idea的LeetCode插件生成

### 中等

1. 生成括号

   - 之前做过递归方式，按照课程老师要求，用DP实现
   - 最优子结构：对于n对括号的情况，等于i对括号的情况，外面加上左右括号，再加上j对括号的情况，其中 i + j = n - 1

   https://github.com/Albertsirius/algorithm025/blob/main/Week7/GenerateParentheses.java

2. 有效的数独

   	- 按照课程所说，对于每一个9宫格的判断的索引是((行 / 3) * 3 + (列 / 3))

   https://github.com/Albertsirius/algorithm025/blob/main/Week7/ValidSudoku.java
   
3. 单词接龙

   	- 双向BFS
   	- 老师在课上提供的代码超时了，修改了一下：取出单词后，不是采用每一位进行遍历26个字母来形成新的单词这种方式；而是直接才字典寻找跟当前单词只有一个字母不一样的单词
   	https://github.com/Albertsirius/algorithm025/blob/main/Week7/WordLadder.java
