class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //Sort the products lexicographically
        Arrays.sort(products);
        
        List outerList = new ArrayList<>();
        //for loop for searchWord length
        for(int i = 1; i < searchWord.length() + 1; i++){
            List innerList = new ArrayList<String>();
            String prefix = searchWord.substring(0,i);
            
            //Loop the products
            int counter = 0;
            for(int j = 0; j < products.length; j++){
                if(products[j].startsWith(prefix)){
                    innerList.add(products[j]);
                    counter++;
                    if(counter == 3)
                        break;
                }
            }
            
            //Add the innerList to outerList
            outerList.add(innerList);
        }
        
        return outerList;
    }
}