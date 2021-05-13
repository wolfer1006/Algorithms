class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1)
            return 1;
        
        int count = 0;
        char lastChar = chars[0];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == lastChar)
                count++;
            else{
                sb.append(lastChar);
                if(count > 1)
                    sb.append(count);
                lastChar = chars[i];
                count = 1;
            }
        }
        
        sb.append(lastChar);
        if(count > 1)
            sb.append(count);
        
        for(int i = 0; i < sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}