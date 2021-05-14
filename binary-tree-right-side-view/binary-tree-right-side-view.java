/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        
        traverseLevel(root, 0);
        
        //Get all the right viewed
        List<Integer> rightView = new ArrayList<Integer>();
        rightView.add(root.val);
        for(int i = 1; i < levels.size(); i++){
            // System.out.println("LEVELS: " + levels.size());
            List<Integer> level = levels.get(i);
            // System.out.println("LEVEL: " + level.size());
            rightView.add(level.get(level.size() - 1));
        }
        return rightView;
    }
    
    public void traverseLevel(TreeNode node, int level){
        // System.out.println("level: " + level);
        
        if(level >= levels.size()){
            //New level
            List<Integer> levelList = new ArrayList<Integer>();
            levelList.add(node.val);
            levels.add(levelList);
        }
        else{
            //Level exists, add on to existing
            List<Integer> levelList = levels.get(level);
            levelList.add(node.val);
        }
        
        //Go left
        if(node.left != null)
            traverseLevel(node.left, level + 1);
        //Go right
        if(node.right != null)
            traverseLevel(node.right, level + 1);
    }
}