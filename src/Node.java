public class Node {
    private Integer info;
    private Node left;
    private Node right;

    public Node(int info){
        this.info = info;
    }

    public Integer info(){
        return info;
    }

    public void setInfo(Integer info){
        this.info = info;
    }

    public Node left(){
        return left;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public Node right(){
        return right;
    }

    public void setRight(Node right){
        this.right = right;
    }  
}
