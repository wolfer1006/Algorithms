/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    List<List<Node>> levels = new ArrayList<List<Node>>();
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        //Build out lists
        traverseLevel(root, 0);
        
        //Make the pointers
        for(int i = 0 ; i < levels.size(); i++){
            List<Node> levelList = levels.get(i);
            for(int j = 0; j < levelList.size() - 1; j++){
                levelList.get(j).next = levelList.get(j + 1);
            }
        }
        
        return root;
    }
    
    public void traverseLevel(Node node, int level){
        if(level >= levels.size()){
            //New level
            List<Node> levelList = new ArrayList<Node>();
            levelList.add(node);
            levels.add(levelList);
        }
        else{
            //Exisiting level
            List<Node> levelList = levels.get(level);
            levelList.add(node);
        }
        
        //Traverse left
        if(node.left != null)
            traverseLevel(node.left, level + 1);
        //Traverse right
        if(node.right != null)
            traverseLevel(node.right, level + 1);
    }
}