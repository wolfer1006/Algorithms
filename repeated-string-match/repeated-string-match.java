class Solution {
    public int repeatedStringMatch(String a, String b) {
        String repeat = a;
        int count = 1;
        while(!a.contains(b)){
            if((count > 2 && a.length() >= b.length() * 2) || count == b.length())
                return -1;
            a = a + repeat;
            count++;
        }
        return count;
    }
}