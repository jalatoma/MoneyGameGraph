/*
 * Project 3
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

public interface Project3GraphADT<T> {

    /**
     * Takes the id of a new node and the value assigned to that id and created it in the graph
     * @param id
     * @param value
     */
    void addNode(String id, T value);

    /**
     * Adds an edge between two nodes, when specified two ids
     * @param id1
     * @param id2
     */
    void addEdge(String id1, String id2);

    /**
     * Sets a specific node (given an id) to a new value, of not found nothing happens
     * @param id
     * @param value
     */
    void setNode(String id, T value);

    /**
     * Returns the value of a node at a specific id
     * @param id
     * @return node value
     */
    T getNode(String id);

    /**
     * Returns all the node ids
     * @return node ids
     */
    String[] getNodeIds();

    /**
     * Removes a specific node given an id
     * @param id
     */
    void removeNode(String id);

    /**
     * Removes an edge or connection between two nodes
     * @param id1
     * @param id2
     */
    void removeEdge(String id1, String id2);

    /**
     * Returns the count of the number of nodes
     * @return count of nodes
     */
    int countNodes();

    /**
     * Returns the count of edges between two nodes
     * @return count of edges
     */
    int countEdges();

    /**
     * Calculates the complexity of a graph by taking edges minus nodes + 1
     * @return returns how complicated the graph is
     */
    int genus();

    /**
     * Formats the nodes and the edges of the graph and prints them out
     * @return string representation of the graph
     */
    String toString();
}
