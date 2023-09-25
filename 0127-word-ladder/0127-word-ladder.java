class Node{
    String first;
    int second;
    Node(String first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord,1));
        Set<String> s =new HashSet<String>(); 
        int len = wordList.size();
        for(int i=0;i<len;i++){
            s.add(wordList.get(i));
        }
        s.remove(beginWord);
        while(!q.isEmpty()){
            String word =q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord)) return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedword =new String (replacedCharArray);
                    if(s.contains(replacedword)==true){
                        s.remove(replacedword);
                        q.add(new Node(replacedword,steps+1));
                    } 
                }
            }
        }
        return 0;
    }
}