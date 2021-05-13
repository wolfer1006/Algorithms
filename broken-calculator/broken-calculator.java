class Solution {
    public int brokenCalc(int x, int y) {
        //Easier to go from y -> x
        int count = 0;
        while(y > x){
            if(y % 2 == 0)
                y = y / 2;
            else
                y = y + 1;
            count++;
        }
        
        return count + (x - y);
    }
}