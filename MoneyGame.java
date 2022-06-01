/*
 * Project 3
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

public class MoneyGame{

    private Project3Graph object;

    /**
     * Constructor for the money game
     */
    public MoneyGame() {
        object = new Project3Graph();
    }

    /**
     * Adds a node to the money game given a new id and a number to assign it to
     * @param id
     * @param element
     */
    void addNode(String id, int element){
        // call the method from project3graph
        object.addNode(id, element);
    }

    /**
     * Adds a connection (edge) in between two nodes given two ids
     * @param id1
     * @param id2
     */
    public void addEdge(String id1, String id2){
        // call method from project3graph
        object.addEdge(id1, id2);
    }

    /**
     * Sums up all the values of the nodes
     * @return sum
     */
    int sum(){
        // get array of string ids and the length, also initialize sum
        String[] id = object.getNodeIds();
        int len = id.length;
        int sum = 0;

        // for every id value, add them up to get the sum of all the node's values
        for(int i = 0; i< len; i++){
            sum += (int) object.getNode(id[i]);
        }
        return sum;
    }

    /**
     * Tells the user if the game is winnable by checking sum against genus
     * @return true or false
     */
    boolean isWinnable(){
        // get the genus of the graph
        int genus = object.genus();

        // get the sum of the graph
        int sum = sum();

        // check to see if the sum is greater than or equal to the genus to win
        if (sum >= genus){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Formats the nodes and the edges of the graph and prints them out as:
     * id(value): nodes it's connected to, etc...
     * @return string representation of the graph
     */
    public String toString(){
        // calls the toString method from project3graph
        return(object.toString());
    }
}
