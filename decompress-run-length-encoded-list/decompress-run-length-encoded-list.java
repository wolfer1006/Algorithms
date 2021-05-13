class Solution {
    public int[] decompressRLElist(int[] nums) {
        //12 34 => 2444
        
        //We can go through it once to get array size
        int size = 0;
        for(int i = 0; i < nums.length; i = i + 2){
            size += nums[i];
        }
        
        //Build the new array
        int[] runLength = new int[size];
        int runLengthIndex = 0;
        for(int i = 1; i < nums.length; i = i + 2){
            for(int j = 0; j < nums[i-1]; j++){
                runLength[runLengthIndex] = nums[i];
                runLengthIndex++;
            }
        }
        
        return runLength;
    }
}