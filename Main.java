public class Main {
    public static void main(String[] args) {

        Project3Graph object = new Project3Graph();

         object.addNode("n1", 5);
        object.addNode("n2", 7);
        object.addNode("n3", 2);
        object.addNode("n4", 10);
        object.addEdge("n1", "n2");
        object.addEdge("n1", "n3");
        object.addEdge("n2", "n3");
        object.addEdge("n4", "n1");
        object.addEdge("n4", "n2");

        System.out.println(object.countNodes());
        System.out.println(object.countEdges());

        object.toString();

        object.removeNode("n4");
        object.removeEdge("n1", "n2");

        System.out.println(object.countNodes());
        System.out.println(object.countEdges());

        object.toString();

        /*
        object.addNode("p1", 10);
        object.addNode("p2", -5);
        object.addNode("p3", -6);
        object.addNode("p4", -2);

        object.addEdge("p1", "p2");
        object.addEdge("p1", "p3");
        object.addEdge("p2", "p3");
        object.addEdge("p4", "p1");

        System.out.println(object.isWinnable());
        object.toString();

         */
    }
}
