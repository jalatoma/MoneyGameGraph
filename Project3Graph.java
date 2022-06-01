/*
 * Project 3
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Jacynda Alatoma (alato006)
 */

public class Project3Graph<T extends Comparable<T>> implements Project3GraphADT<T>{

    // initialize variables to use in methods

    // first 3 arrays are to store values, ids, and edges
    private Comparable[] nodeVal;
    private String[] stringID;
    private boolean[][] edges;

    // counts nodes and edges
    private int nodeSize;
    private int edgeSize;

    /**
     * Constructor that initializes all the variables in the scope
     */
    public Project3Graph()
    {
        // set everything to null or 0
        nodeVal = null;
        stringID = null;
        edges = null;
        nodeSize = 0;
        edgeSize = 0;
    }

    /**
     * Takes the id of a new node and the value assigned to that id and created it in the graph
     * @param id
     * @param value
     */
    @Override
    public void addNode(String id, T value) {
        // if node is 0, initialize arrays of size 1 for everything and set initial values
        if (nodeSize == 0){
            nodeVal = new Comparable[1];
            stringID = new String[1];
            edges = new boolean[1][1];
            nodeVal[0] = (Comparable) value;
            stringID[0] = id;
            edges[0][0] = false;
            nodeSize++;
        }
        // this is for if there already are values in the array
        else {
            // increase size
            nodeSize++;

            // make a temp array that's bigger to add a new value
            String[] tempStr = new String[stringID.length + 1];
            // copy over values from previous array
            for (int i = 0; i < stringID.length; i++){
                tempStr[i] = stringID[i];
            }
            // assign the last value of the array to the new added on value
            tempStr[stringID.length] = id;
            // transfer over data to original array
            stringID = tempStr;

            // do the same temp process as above
            Comparable[] tempVal = new Comparable[nodeVal.length + 1];
            for (int i = 0; i < nodeVal.length; i++){
                tempVal[i] = nodeVal[i];
            }
            tempVal[nodeVal.length] = (Comparable) value;
            nodeVal = tempVal;

            // follow same temp process as above
            boolean[][] tempEdges = new boolean[edges.length + 1][edges.length + 1];
            for (int i = 0; i < edges.length; i++){
                for (int j = 0; j < edges.length; j++){
                    tempEdges[i][j] = edges[i][j];
                }
            }
            // set the newest addition to false because it has no edges yet
            tempEdges[edges.length][edges.length] = false;
            edges = tempEdges;
        }
    }

    /**
     * Adds an edge between two nodes, when specified two ids
     * @param id1
     * @param id2
     */
    @Override
    public void addEdge(String id1, String id2) {
        // increase edge size
        edgeSize++;

        // find length of ids and initialize two indexes
        int len = stringID.length;
        int index1 = -1, index2 = -1;
        for(int i = 0; i < len; i++){
            // set indexes 1 and 2 to their values if found
            if (stringID[i] == id1){
                index1 = i;
            }
            if (stringID[i] == id2){
                index2 = i;
            }
        }
        // if indexes were found, set the edge or connection to true
        if(index1 != -1 & index2 != -1) {
            edges[index1][index2] = true;
        }
        // if no indexes were found or one wasn't, don't return anything
        else{
            return;
        }
    }

    /**
     * Sets a specific node (given an id) to a new value, of not found nothing happens
     * @param id
     * @param value
     */
    @Override
    public void setNode(String id, T value) {
        // set length to string id length
        int len = stringID.length;
        for(int i = 0; i < len; i++){
            // if found id that matches, reassign its value
            if (stringID[i] == id){
                nodeVal[i] = (Comparable) value;
            }
        }
    }

    /**
     * Returns the value of a node at a specific id
     * @param id
     * @return node value
     */
    @Override
    public T getNode(String id) {
        // find length and initialize index
        int len = stringID.length;
        int index = -1;
        for(int i = 0; i < len; i++){
            // if id matches one that exists. reassign index
            if (stringID[i] == id){
                index = i;
            }
        }
        // if index exists, return the value at that index, otherwise return null
        if (index != -1){
            return (T) nodeVal[index];
        }
        return null;
    }

    /**
     * Returns all the node ids
     * @return node ids
     */
    @Override
    public String[] getNodeIds() {
        // return the string array of ids
        return stringID;
    }

    /**
     * Removes a specific node given an id
     * @param id
     */
    @Override
    public void removeNode(String id) {
        // if there is no id that exists then do nothing
        if(getNode(id) == null){
            return;
        }
        else{
            int index1 = -1;
            int removeEdge = 0;
            int len = stringID.length;
            for(int i = 0; i < len; i++){
                // if id matches one that exists. assign index
                if (stringID[i] == id){
                    index1 = i;
                }
            }
            // reduce node size
            nodeSize--;
            int index = -1;
            // crete arrays to copy information over to
            String[] tempStr = new String[stringID.length - 1];
            Comparable[] tempVal = new Comparable[nodeVal.length - 1];
            boolean[][] tempEdges = new boolean[edges.length - 1][edges.length - 1];

            // in the for loops, loop over areas
            for(int i = 0; i < len; i++){
                if(stringID[i] == id){
                    index = i;
                }
            }
            // copy to the temp arrays
            for(int i = 0; i<len-1; i++){
                if(i < index){
                    tempStr[i] = stringID[i];
                    tempVal[i] = nodeVal[i];
                }
                else {
                    tempStr[i] = stringID[i+1];
                    tempVal[i] = nodeVal[i+1];
                }
            }
            // reassign temp arrays to the regular
            stringID = tempStr;
            nodeVal = tempVal;
            for(int i =0; i< stringID.length + 1; i++){
                if (hasEdge(index1, i) || hasEdge(i, index1)){
                    removeEdge++;
                }
            }

            // update the edges array
            for(int i = 0; i < tempEdges.length; i++){
                if(i < index){
                    for(int j = 0; j<tempEdges.length; j++) {
                        if(j < index) {
                            tempEdges[i][j] = edges[i][j];
                        } else {
                            tempEdges[i][j] = edges[i][j+1];
                        }
                    }
                }
                else {
                    for(int j = 0; j<tempEdges.length; j++){
                        if(j < index) {
                            tempEdges[i][j] = edges[i+1][j];
                        } else {
                            tempEdges[i][j] = edges[i+1][j+1];
                        }
                    }
                }
            }

            // copy the array over
            edges = tempEdges;
            edgeSize = edgeSize - removeEdge;
        }
    }

    /**
     * Removes an edge or connection between two nodes
     * @param id1
     * @param id2
     */
    @Override
    public void removeEdge(String id1, String id2) {
        // update size variable
        edgeSize--;

        // get length and initialize variables
        int len = stringID.length;
        int index1 = -1, index2 = -1;

        // set indexes for the two nodes
        for(int i = 0; i < len; i++){
            if (stringID[i] == id1){
                index1 = i;
            }
        }
        for(int i = 0; i < len; i++){
            if (stringID[i] == id2){
                index2 = i;
            }
        }

        // set their relationship to false
        if(index1 != -1 & index2 != -1) {
            edges[index1][index2] = false;
        }
        else{
            return;
        }
    }

    /**
     * Returns the count of the number of nodes
     * @return count of nodes
     */
    @Override
    public int countNodes() {
        return nodeSize;
    }

    /**
     * Returns the count of edges between two nodes
     * @return count of edges
     */
    @Override
    public int countEdges() {
        return edgeSize;
    }

    /**
     * Calculates the complexity of a graph by taking edges minus nodes + 1
     * @return returns how complicated the graph is
     */
    @Override
    public int genus() {
        // genus given to us in directions
        return (edgeSize - nodeSize + 1);
    }

    /**
     * Tells if there is an edge connecting two nodes
     * @param index1
     * @param index2
     * @return boolean for the edge matrix
     */
    public boolean hasEdge(int index1, int index2){
        // checks for an edge
        return(edges[index1][index2]);
    }

    /**
     * Formats the nodes and the edges of the graph and prints them out in format:
     * id(value): nodes it's connected to, etc...
     * @return string representation of the graph
     */
    @Override
    public String toString() {
        // get length and edge count
        int len = stringID.length;
        int edgeCount;

        // start for lop for printing
        for(int i = 0; i < len; i++){
            // initialize this count for the commas separating each node
            edgeCount = 0;
            System.out.print(stringID[i] + "(" + nodeVal[i] + "): ");
            for (int j = 0; j< len; j++){
                if(hasEdge(i, j) || hasEdge(j, i)){
                    edgeCount++;
                    // if it's the first one no need to add the comma, otherwise do
                    if (edgeCount == 1) {
                        System.out.print(stringID[j]);
                    } else {
                        System.out.print(", " + stringID[j]);
                    }
                }
            }
            // always start a new line
            System.out.print("\n");
        }
        return " ";
    }
}
