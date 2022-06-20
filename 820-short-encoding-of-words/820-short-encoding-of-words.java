class Solution {
    public int minimumLengthEncoding(String[] words) {
        //Check each word to see if it exists within another word
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if((i != j) && words[i] != null && words[j] != null && words[i].endsWith(words[j])){
                    words[j] = null;
                }
            }
        }
        System.out.println(Arrays.toString(words));
        
        //Build a new String
        String validEncoding = new String();
        for(int i = 0; i < words.length; i++){
            if(words[i] != null){
                validEncoding = validEncoding + words[i] + '#';
            }
        }
        
        return validEncoding.length();
    }
}