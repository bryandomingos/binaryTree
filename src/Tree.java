public class Tree {
    
    private Node root;

    public void insert(Integer value){
        insert(root, value);
    }

    public void insert(Node no, Integer value){

        if(no == null){
            root = new Node(value);
        }else if(value >= no.info()){         
            if(no.right() == null){
                no.setRight(new Node(value));

            }else{
                insert(no.right(), value);
            }

        }else if(no.left() == null){
            no.setLeft(new Node(value));
        }else{
            insert(no.left(), value);
        }       
    }

    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node no){
        if(no != null){
            System.out.print(no.info() + " ");
            preOrder(no.left());
            preOrder(no.right());
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(Node no){
        if(no != null){
            inOrder(no.left());
            System.out.print(no.info() + " ");
            inOrder(no.right());
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node no){
        if(no != null){
            postOrder(no.left());
            postOrder(no.right());
            System.out.print(no.info() + " ");
        }
    }

    public Node remove(Tree tree, Integer value){
        Node NodeBalance = remove(tree, root , value, null);
        return NodeBalance;
    }

    public Node remove(Tree tree, Node target, Integer value, Node father){
        if(target != null){   
            if(target.info() == value){
                if(target.left() == null && target.right() == null){ // None
                    if(father == null){
                        tree.root = null;

                    }else if(target.info() >= father.info()){
                        father.setRight(null);

                    }else{
                        father.setLeft(null);
                    }

                }else if(target.left() == null){                    // Only Right
                    if(target.info() >= father.info()){
                        father.setRight(target.right());

                    }else{
                        father.setLeft(target.right());

                    }
                    target.setLeft(null);

                }else if(target.right() == null){                   // Only Left
                    if(target.info() >= father.info()){
                        father.setRight(target.left());

                    }else{
                        father.setLeft(target.left());
                    }
                    
                    target.setLeft(null);
                    
                }else{                                             // Both
                    int bigger = biggerLeft(target).info();
                    int NodeRemove = remove(tree, bigger).info();
                    target.setInfo(NodeRemove);
                    return target;
                }

            }

            if(value >= target.info()){
                return remove(tree, target.right(), value, target);

            }else{
                return remove(tree, target.left(), value, target);
            }
        }
        return null;
    }

    private Node biggerLeft(Node target){

        if(target.left() != null){
            target = target.left();

            while(target.right() != null){
                target = target.right();
            }
        }
        return target;
    }

    public Node search(Integer value){
        return search(root, value);
    }

    private Node search(Node target, Integer value){

        if(target != null){
            if(target.info() == value){
                System.out.println("Node found!\n");
                return target;

            }else if(value >= target.info()){
                return search(target.right(), value);

            }else{
                return search(target.left(), value);
            }

        }else{
            System.out.println("Node not found!\n");
            return null;
        }
    }

}


