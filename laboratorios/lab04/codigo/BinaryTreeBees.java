
/**
 * Write a description of class BinaryTreeBees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinaryTreeBees
{
    Node root;
    
    public BinaryTreeBees(Node root){
        this.root = root;
    }
    
    public Node getRoot(){
        return root;
    }
    
    public void add(Node param, Double value, Bee toSave) throws NullPointerException{
        if(param == null){
            return;
        }

        if(param.distance < value){
            if(param.right != null)
                add(param.right, value, toSave);
            else
                param.right = new Node(toSave, value);
        }else{
            if(param.left != null)
                add(param.left, value, toSave);
            else
                param.left = new Node(toSave, value);
        }
    }
}
