public class App {
    public static void main(String[] args) throws Exception {

        Tree t = new Tree();

        t.insert(20);
        t.insert(25);
        t.insert(10);
        t.insert(15);
        t.insert(30);
        t.insert(23);
        t.insert(24);
        t.insert(35);

        System.out.println("\n\nPre-Order: ");
        t.preOrder();
        System.out.println("\n\nIn-Order: ");
        t.inOrder();
        System.out.println("\n\nPost-Order: ");
        t.postOrder();
        System.out.println("\n");

        t.search(10);

        t.remove(t, 10);

        System.out.println("\nPre-Order: ");
        t.preOrder();
        System.out.println("\n\nIn-Order: ");
        t.inOrder();
        System.out.println("\n\nPost-Order: ");
        t.postOrder();
        System.out.println("\n");

        t.search(10);

    }
}
