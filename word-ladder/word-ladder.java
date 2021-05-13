class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int step = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
        Set<String> nextSet = new HashSet<>();
            for(String word: beginSet){
                // System.out.println(step + " " + word);
                char[] charArr = word.toCharArray();
                for(int i = 0; i < beginWord.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char previousChar = charArr[i];
                        charArr[i] = c;
                        String nextWord = new String(charArr);
                        if(endSet.contains(nextWord))
                            return step + 1;
                        if(visited.add(nextWord) && wordList.contains(nextWord))
                            nextSet.add(nextWord);
                        charArr[i] = previousChar;
                    }
                }
            }
            if(endSet.size() < nextSet.size()) {
                beginSet = endSet;
                endSet = nextSet;
            }else {
                beginSet = nextSet;
            }
            step++;
        }
        return 0;
    }
}