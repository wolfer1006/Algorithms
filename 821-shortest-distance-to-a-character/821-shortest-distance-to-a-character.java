class Solution {
    public int[] shortestToChar(String s, char c) {
        //Get count of occurences of c
        long count = s.chars().filter(ch -> ch == c).count();
        System.out.println(count);
        
        //Find the indices of those
        int[] indices = new int[(int)count];
        int indicesCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c)
                indices[indicesCount++] = i;
        }
        System.out.println(Arrays.toString(indices));
        
        //Loop through s, forward AND back
        int[] forward = new int[s.length()];
        int[] backward = new int[s.length()];
        
        int indicesIndexF = 0;
        int indicesIndexB = indices.length - 1;
        int forwardIndex = indices[indicesIndexF];
        int backwardIndex = indices[indicesIndexB];
        
        for(int i = 0; i < s.length(); i++){
            //forward
            forward[i] = Math.abs(forwardIndex - i);
            if(forwardIndex == i && indicesIndexF != indices.length - 1)
                forwardIndex = indices[++indicesIndexF];
            
            //backward
            backward[s.length() - 1 - i] = Math.abs(backwardIndex - (s.length() - 1 - i));
            if(backwardIndex == (s.length() - 1 - i) && indicesIndexB != 0)
                backwardIndex = indices[--indicesIndexB];
        }
        
        //Compare the two arrays and taken the lowest of each index pairing
        int[] shortest = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            if(forward[i] <= backward[i])
                shortest[i] = forward[i];
            else
                shortest[i] = backward[i];
        }
        
        return shortest;
    }
}