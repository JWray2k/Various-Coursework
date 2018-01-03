import java.util.Arrays; //import for array sort - 
import java.lang.RuntimeException; //generate runtime exception
import java.util.ArrayList;
import java.util.Collections;

/*
 * Jonathan Wray
 * CSCI310 - HW07 - String Graph
 * 4/25/2017

HW 07 - String Graph 
http://cis4.sau.edu/lillis/csci310/2016Spring/assignments/hw07_string-graph/hw07_string-graph.html

In class we've been discussing how to implement a graph using an adjacency matrix. 
The graph you will create for this assignment is somewhat simpler than what we've 
discussed in class (as described in requirements 1, 2, and 3 below).

Requirements

    1. This is not a generic graph. Each vertex of the graph is a String.
    2. This is an unweighted and undirected graph.
    3. In several situations a RuntimeException is thrown. This should make the class easier to design. 
       The requirements are given in this Graph.java interface.
    4. Your class is to be called StringGraph and must implement this interface: Graph.java.
    5. Your class should include the following instance variables:
        - labels: A one-dimensional array of Strings that stores the unique label for each vertex.
        - edgeMatrix: A two-dimensional array of boolean values that serves as the adjacency matrix for the graph.
        - numVertices: An int for the number of vertices.
        - numEdges: An int for the number of edges.
        - capacity: An int for the capacity (similar to the ArrayListOfStrings from HW 02).
    6. Your class should have the following constructors:
        - A default constructor that sets the initial capacity to 1.
        - A parameterized constructor that specifies the initial capacity.

 */

public class StringGraph implements Graph {
    
    //labels: A one-dimensional array of Strings that stores the unique label for each vertex.
    private String[] labels; //http://stackoverflow.com/questions/1200621/how-to-declare-and-initialize-an-array-in-java
    //edgeMatrix: A two-dimensional array of boolean values that serves as the adjacency matrix for the graph. //consists of True or False
    private boolean[][] edgematrix; //http://stackoverflow.com/questions/12231453/syntax-for-creating-a-two-dimensional-array 
    //numVertices: An int for the number of vertices.
    private int numVertices;
    //numEdges: An int for the number of edges.
    private int numEdges;
    //capacity: An int for the capacity (similar to the ArrayListOfStrings from HW 02)
    private int capacity;
    
    //A default constructor that sets the initial capacity to 1.
    public StringGraph(){
        capacity = 1;
    }
    
    //A parameterized constructor that specifies the initial capacity. 
    public StringGraph(int initial){
        capacity = initial; //initial set as capacity was originally I was was constructing here
        labels = new String[initial];
	edgematrix = new boolean[initial][];

	// We use only the portion of the matrix below the main diagonal to store the edges
	for(int i = 0; i < edgematrix.length; i++){
            edgematrix[i] = new boolean[i+1];			
            for(int j = 0; j < i; j++){
		edgematrix[i][j] = false;
            }
        }
    }
    

    /**
     * Returns the number of vertices in the graph.
     * @return the number of vertices in the graph
     */
    @Override
    public int numberOfVertices() {
       return numVertices;
    }

    
    /**
     * Returns the number of edges in the graph.
     * @return the number of edges in the graph
     */
    @Override
    public int numberOfEdges() {
        return numEdges;
    }

    
    /**
     * Returns an array of Strings containing the labels of the vertices.
     * @return a String array containing the vertex labels
     */
    @Override
    public String[] getVertexLabels() {
      String[] vertices = new String[numVertices]; 
      String vertex;
      
      for (int i = 0; i < numVertices; i++) //for loop cycles through the new array
      { 
         vertex = this.labels[i]; //vertex  value is stored in labels... its position is stored in edgematrix
         vertices[i] = vertex; //new string array is populated with the values of labels array.
      }
      return vertices; //I think I may be able to just return the array of labels to begin with... do I need just the string, or also location?
   }
 //referenced from http://faculty.washington.edu/moishe/javademos/ch18%20Code/jss2/Graph.java
/**   I may need my instance variables protected - like in the example.
      labels = new String[numVerticies]; 
      String vertex;
      
      for (int i = 0; i < numVerticies; i++) //for loop cycles through the new array
      { 
         vertex = this.labels[i]; //vertex  value is stored in labels... its position is stored in edgematrix
         labels[i] = vertex; //new string array is populated with the values of labels array.
      }
      return labels; 
   }
 */
    
    /**
     * Adds a new vertex to the graph.
     * @param v the new vertex to be added
     * @throws RuntimeException if vertex already exists
     */
    @Override
    public void addVertex(String v) throws RuntimeException { //I'm not sure why this has a Runtime Exception...
      if (numVertices == labels.length){
         expandCapacity(); //expand capacity method call...
      }

      labels[numVertices] = v; //v represents vertex
      for (int i = 0; i <= numVertices; i++)
      {
         edgematrix[numVertices][i] = false;
         edgematrix[i][numVertices] = false;
      }      
      numVertices++;
    }
    /**
     * public void addVertex() {
    // If the number of vertices is more than half the size of our matrix, 
    // double the size of our matrix
    int numV = getNumVertices();
    if (numV > 0.5 * size) {
        size = 2*size;
        int[][] newAdjMatrix = new int[size][size];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[0].length; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMatrix;
    }
    setNumVertices(numV+1);
    } https://code.snipcademy.com/tutorials/data-structures/graphs/adjacency-matrices
     */


    
    /**
     * Determines if a vertex with the given label exists.
     * @param v the label of a vertex.
     * @return true of the vertex exists, false if it does not exist.
     */
    @Override
    public boolean vertexExists(String v) {
        for (int i = 0; i <= numVertices; i++){
            return labels[i].equals(v);
        }
        return false; //will reach this statement if the vertex doesn't exist
    }

    
    /**
     * Determines if an edge with the given end vertices exists.
     * @param u one end vertex
     * @param v the other end vertex
     * @return true if the edge exists, false otherwise.
     * @throws RuntimeException if either u or v does not exist.
     */
    @Override
    public boolean edgeExists(String u, String v) throws RuntimeException { //u is row, v is column
        int row = 0;
        int column = 0;
                
        //isn't there an easier way to do this than to parse through for each vertex... this isn't really saving me much tun time...
        if(!vertexExists(u) && !vertexExists(v)){ //checking against the vertex to see if they both exist in the first place... throwing exception if not
            throw new RuntimeException();
        }
        
        for (int i = 0; i <= numVertices; i++){
            if(labels[i].equals(u)){
                row = i; //check location of string u in labels... and select the index as row
            }
        }
        for (int i = 0; i <= numVertices; i++){
            if(labels[i].equals(v)){
                column = i; //check location of string v in labels... and select the index as column
            }
        }
        if (edgematrix[row][column] = true){ //I can't initialize the row and column as 0 because they're used as array indexes to check for edges
            return true; //figure out how
        }
        numEdges++; //increiment number of edges
        return false;
    }

    
    /**
     * Deletes a vertex and all incident edges.
     * @param v The vertex to be deleted
     * @throws RuntimeException if the vertex does not exist
     */
    @Override
    public void deleteVertex(String v) throws RuntimeException {
        int index = 0;
        if (!vertexExists(v)){ //v used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        }
            
        for (int i = 0; i <= numVertices; i++){
            if(labels[i].equals(v)){
                index = i;
            }
        }
            numVertices--;
            
        for (int i = index; i < numVertices; i++) //index should have been initialized from for loop...
           labels[i] = labels[i+1];

        for (int i = index; i < numVertices; i++) //learn to understand these type of for statements...
            for (int j = 0; j <= numVertices; j++)
               edgematrix[i][j] = edgematrix[i+1][j];

        for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               edgematrix[j][i] = edgematrix[j][i+1];
        
        numVertices--; //decriment the number of verticies
      }
       
    
    
    /**
     * public void removeVertex() throws VertexOutOfBoundsException {
    int numV = getNumVertices();
    if (numV == 0) {
      throw new VertexOutOfBoundsException();
    }
    if (size < 0.5 * numV) {
        size = (int) 0.5*size;
        int[][] newAdjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMatrix;
    }
    setNumVertices(numV-1);
    } https://code.snipcademy.com/tutorials/data-structures/graphs/adjacency-matrices
     */

    
    /**
     * Adds a new edge to the graph.
     * @param u one end vertex of the edge
     * @param v the other end vertex of the edge
     * @throws RuntimeException if edge {u, v} already exists or if either u or
     * v does not exist.
     */
    @Override
    public void addEdge(String u, String v) throws RuntimeException {
        int i = getIndexOfItemInArray(labels, u);
        if (!vertexExists(u)){ //u used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        }

        int j = getIndexOfItemInArray(labels, v);
        if (!vertexExists(v)){ //v used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        }

        if (i>=j) edgematrix[i][j] = true;
        else edgematrix[j][i] = true;

        numEdges++;

    } //http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/myGraph.java
    
    /**
     * public void addEdge(int v, int w) throws VertexOutOfBoundsException {
    int numV = getNumVertices();
    if (v >= numV || w >= numV) {
      throw new VertexOutOfBoundsException();
    }
    adjMatrix[v][w] = 1;
    setNumEdges(getNumEdges()+1);
    } https://code.snipcademy.com/tutorials/data-structures/graphs/adjacency-matrices
     */
    
    /**
     *         if (vertexExists(u) && vertexExists(v)){ //do i really have to constantly swirch my strings into ints... this is a pain...
         edgematrix[u][v] = true; //review delete vertex..
         edgematrix[v][u] = true;
      }
     */

    
    /**
     * Deletes an edge from the graph.
     * @param u one end vertex of the edge
     * @param v the other end vertex of the edge
     * @throws RuntimeException if edge {u, v} does not exist or if either u or
     * v does not exist.
     */
    @Override
    public void deleteEdge(String u, String v) throws RuntimeException {
        int i = getIndexOfItemInArray(labels, u);
        if (!vertexExists(u)){ //u used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        }

        int j = getIndexOfItemInArray(labels, v);
        if (!vertexExists(v)){ //v used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        }

        if (i>=j){
            if (edgematrix[i][j]){
                edgematrix[i][j] = false; //review this later...
                numEdges--;
            }
        }else{
            if (edgematrix[j][i]){
                edgematrix[j][i] = false; //review this later...
                numEdges--;
            }
        }
    } //http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/myGraph.java
    
    /** I honestly don't know why I don't have a getIndex method...
     * {
     * removeEdge (getIndex(u), getIndex(v));
     * }
     */
    
    /**
     *         if (vertexExists(u) && vertexExists(v)){
         edgematix[u][v] = false; //review above
         edgematix[v][u] = false;
      }
     */
    
    /** this is a great bit of code here...
     * public void removeEdge(int v, int w) throws VertexOutOfBoundsException {
    int numV = getNumVertices();
    if (v >= numV || w >= numV) {
      throw new VertexOutOfBoundsException();
    }
    adjMatrix[v][w] = 0;
    setNumEdges(getNumEdges()-1);
    }
     */

    
    /**
     * Returns an array of Strings containing the labels of the neighbors of 
     * the specified vertex.
     * @param v the vertex of interest
     * @return a String array holding the labels the neighbors.
     * @throws RuntimeException if the specified vertex does not exist
     */
    @Override
    public String[] getNeighbors(String v) throws RuntimeException {
        if (!vertexExists(v)){ //v used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        }
        
        String[] neighbors = new String[numVertices];
        int numNeighbors = 0;
        int source = getIndexOfItemInArray(labels, v); //get index of item in array.. from Array util import


        for(int j = 0; j < numVertices; j++){
            boolean edge = false; //unsure of what this is doing.. come back to it...
            if (j <= source) edge = edgematrix[source][j]; //what is source?
            else edge = edgematrix[j][source];

            if(edge)
                neighbors[numNeighbors++] = labels[j]; 
                //neighbors[numNeighbors++] = new String(labels[j]); string constructor ...not needed.
            }

        neighbors = resize(neighbors, numNeighbors); //resize... hmmm
        return neighbors;
    } //http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/myGraph.java
    
    /**
     *  List<Integer> inNeighbors = new ArrayList<Integer>();
            for (int u : adjListsMap.keySet()) {
                    //iterate through all edges in u's adjacency list and 
                    //add u to the inNeighbor list of v whenever an edge
                    //with startpoint u has endpoint v.
                    for (int w : adjListsMap.get(u)) {
                            if (v == w) {
                                    inNeighbors.add(u);
                            }
                    }
            }
            return inNeighbors;
	}
        * https://github.com/Cs4r/UCSDGraphs/blob/master/src/basicgraph/GraphAdjList.java - uses hashmap import
     */
    
    /**
     *  this uses an int index...
     *  // returns the indices of all the neighbors of a given vertex. The
        // vertex is specified as an index and the neighbors are returned
	// in an int array 
        public int[] getNeighbors(int index)
        {
                if((index < 0) || (index >= numVertices))
                {
                        System.out.print("getNeighbors failed: Index");
                        System.out.print(index);
                        System.out.println(" is out of bounds.");
                        return null;
                }

		// Call the earlier getNeighbors function to get the names of
		// neighbors
                String[] nbrNames = getNeighbors(names[index]);

		// Turn the array of neighbor names into an array
		// of neighbor indices
		int[] nbrIndices = new int[nbrNames.length];
		for(int i = 0; i < nbrIndices.length; i++)
			nbrIndices[i] = getIndex(nbrNames[i]);

		return nbrIndices;
        } http://homepage.divms.uiowa.edu/~sriram/21/fall07/code/myListGraph.java
     */

    
    /**
     * Returns the degree of a the specified vertex.
     * @param v the vertex of interest
     * @return the degree of the given vertex
     * @throws RuntimeException if the specified vertex does not exist
     */
    @Override
    public int degree(String v) throws RuntimeException {
        if (!vertexExists(v)){ //v used to check the vertex
            throw new RuntimeException(); //if vertex doesn't exist ...exception is thrown.
        } 
        // Get the index of the vertex
        int i = getIndexOfItemInArray(labels, v); //method call for getIndexOfItemInArray(stringArray, name)

        // Call the other degree function that returns the degree
        // of a vertex, given its index
        return degree(i); //http://homepage.divms.uiowa.edu/~sriram/21/fall07/code/myListGraph.java
    }
    
    // returns the degree of a vertex with given index - added for usablilty of degree method that takes in a String... this isn't too efficient though..
    public int degree(int index){
        int numNeighbors = 0;

        // Scan the row corresponding to vertex in the adjacency
        // matrix, counting the number of neighbors
        for (int j = 0; j <= index; j++){
            if(edgematrix[index][j]){
                numNeighbors++;
            }
        }

        for (int j = index+1; j < numVertices; j++){
            if(edgematrix[j][index]){
                numNeighbors++;
            }
        }

        return numNeighbors;	
    }
    
    /** This is for a directional graph..
     * public int getInDegree(int v) throws VertexOutOfBoundsException {
  int numV = getNumVertices();
  if (v >= numV) {
    throw new VertexOutOfBoundsException();
  }
    // Count the number of in-degrees
    int count = 0;
    for (int i = 0; i < getNumVertices(); i++) {
        if (adjMatrix[i][v] != 0) {
            count++;
        }
    }
    return count;
}
 
public int getOutDegree(int v) throws VertexOutOfBoundsException {
  int numV = getNumVertices();
  if (v >= numV) {
    throw new VertexOutOfBoundsException();
  }
    // Count the number of in-degrees
    int count = 0;
    for (int i = 0; i < getNumVertices(); i++) {
        if (adjMatrix[v][i] != 0) {
            count++;
        }
    }
    return count;
    } https://code.snipcademy.com/tutorials/data-structures/graphs/adjacency-matrices
     */

    /**
     *     
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    /**
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    } http://algs4.cs.princeton.edu/41graph/Graph.java.html
     */
    
    /**perhaps this is the best one:
     * 	// returns the degree of a vertex with given name
    	public int degree(String vertex)
    	{
		// Get the index of the vertex
		int i = getIndex(vertex);
		if(i == -1)
		{
			System.out.print("In degree: ");
			System.out.print(vertex);
			System.out.println(" does not exist.");
			return -1;
		}

		// Call the other degree function that returns the degree
		// of a vertex, given its index
		return degree(i);
    	}
        * http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/myGraph.java
     */
    
    /**public List<Integer> getDegreeSeq() throws VertexOutOfBoundsException {
    List<Integer> degreeSeq = new ArrayList<Integer>();
    int degrees = 0;
    for (int i = 0; i < getNumVertices(); i++) {
        degrees = getInDegree(i) + getOutDegree(i);
        degreeSeq.add(degrees);
    }
    Collections.sort(degreeSeq);
    Collections.reverse(degreeSeq);
    return degreeSeq;
    } https://code.snipcademy.com/tutorials/data-structures/graphs/adjacency-matrices
     */ 
    
    
    
    
    
    
    /**
     * Returns the maximum degree of the graph.
     * @return the maximum degree
     * @see degreeStats()
     */
    @Override
    public int maxDegree() {  //the run time of this is somewhat of a mess. I should really re-evaluate it...
        int current;
        int max = 0;
        for (int i = 0; i < numVertices; i++){ //using less than because I'm checking the labels array... have to account for index 0
             current = degree(labels[i]);
             if (current > max){
                 max = current;
             }
            
        }
        return max;
    }

    
    /**
     * Returns the minimum degree of the graph.
     * @return the minimum degree
     * @see degreeStats()
     */
    @Override
    public int minDegree() { //once again... this run time will be a mess..
        int current;
        int min = 1000000; //need to come up with a better way to instantiate min... 
        for (int i = 0; i < numVertices; i++){
             current = degree(labels[i]);
             if (current < min){
                 min = current;
             }
            
        }
        return min;
    }

    
    /**
     * Returns the average degree of the graph.
     * @return the average degree
     * @see degreeStats()
     */
    @Override
    public double averageDegree() {
        int count = 0;
        int total = 0; //need to come up with a better way to instantiate min... 
        for (int i = 0; i < numVertices; i++){
             total += degree(labels[i]);
             count++;
        }
        return total / count; //will this return an int or double? - I may have to initialize count and total as doubles...
    }

    
    /**
     * Returns the maximum degree, minimum degree, and average degree of this
     * graph. If Graph is empty: max = -1, min = -1, avg = NaN.
     * @return a three element array of doubles containing max, min, avg degree.
     * @see Graph.maxDegree()
     * @see Graph.minDegree()
     * @see Graph.avgerageDegree()
     */
    @Override
    public double[] degreeStats() {
        double[] statArray = new double[3];
        if(numVertices == 0){ //not sure why this isn't working...
            statArray[0] = -1;
            statArray[1] = -1;
            
        }else{
            statArray[0] = maxDegree();
            statArray[1] = minDegree();
            statArray[2] = averageDegree();
        }
        
        return statArray;
    }
    //unused print statement...
    //System.out.println("mas = " + maxDegree() + "," + " min = " + minDegree() + ","+ " avg = " + averageDegree() + "."); //dp I need a toString()?

    
    /**
     * Returns an int array containing the degree sequence of the graph.
     * @return an int array containing the degrees of all vertices, sorted in
     * non-ascending order.
     */    
    @Override
    public int[] degreeSequence() {
        int[] degreeArray = new int[labels.length];
        //Integer[] degreeArray = new Integer[labels.length]; //need to instantiate new array as Integer instead of int array to use Collections.reverseOrder()
        for(int i = 0; i <= degreeArray.length; i++){ //populates each of the empty locations of the new degree array
            degreeArray[i] = degree(labels[i]); //inserts the degree into the statArray
        }
        // sorting array
        //Arrays.sort(degreeArray, Collections.reverseOrder()); //https://www.tutorialspoint.com/java/util/arrays_sort_int.htm
        Arrays.sort(degreeArray);
        reverse(degreeArray); //not sure why ArrayUtils.raver(degreeArray) was recommended...
        //need to generate an int array for the length of labels...
        //once I've created the array, I then make a counter for the matrix and once I've 
        //parsed through a column, I can add this cound to the array index matching the label - actually, just call my other degree method...
        
        //I'll at ths point have an unsorted int array... I have to sort it from greatest to lowest.. giving me my final degree sequence.
        return degreeArray;
    }

    
    //this wasn't part of the interface... not entirely sure I can use this.
   /******************************************************************
     Creates new arrays to store the contents of the graph with
     twice the capacity.
   ******************************************************************/
   protected void expandCapacity(){
      String[] largerVertices = new String[labels.length*2]; //double length of string labels
      boolean[][] largerEdgeMatix = 
            new boolean[labels.length*2][labels.length*2]; //sdouble size of edge matrix

      for (int i = 0; i < labels.length; i++){
//        for (int j = 0; j < labels.length; j++){
//           largerEdgeMatix[i][j] = edgematrix[i][j];
//        } //- manual array copy, we'll use the build-in method for Array Copy instead...
         System.arraycopy(edgematrix[i], 0, largerEdgeMatix[i], 0, labels.length);
         largerVertices[i] = labels[i];
      }
      capacity = capacity*2; //double capacity
      labels = largerVertices; //replace old array
      edgematrix = largerEdgeMatix; //replace old array
   }
   //http://faculty.washington.edu/moishe/javademos/ch18%20Code/jss2/Graph.java


    //used getIndexOfItemInArray for another method call... may not be allowed to used this.
    /**
     * Method to get the index of the given item from the list
     * @param stringArray
     * @param name
     * @return index of the item if item exists else return -1
     */
    public static int getIndexOfItemInArray(String[] stringArray, String name) { //hmmm.... labels is my string array to check name against
        if (stringArray != null && stringArray.length > 0) {
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(stringArray));
            int index = list.indexOf(name);
            list.clear();
            return index;
        }
        return -1;
    } //http://stackoverflow.com/questions/4287417/java-get-index-of-element-in-array-error
    
    //need the below to reverse the main array
    public static void reverse(int[] array){ //org.apache.commons.lang.ArrayUtils.reverse(int([])
        if(array == null){
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while(j > i){
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
    
    
    //re-evaluate this method call in Part 2 - I don't thinkk it's really necessary.
    //http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/myGraph.java
    //Resizes the array of verticies. Can make it larger or smaller depending on what the newSize is.
    protected String[] resize(String[] array, int newSize){
        String[] temp = new String[newSize];
        
        int smallerSize = newSize;
        if(array.length < smallerSize){
            smallerSize = array.length;
        }
        for(int i = 0; i < smallerSize; i++){
            temp[i] = array[i];
        }
        return temp;
    }
}
/**
 * References:
 * http://introcs.cs.princeton.edu/java/45graph/Graph.java
 * 
 * http://algs4.cs.princeton.edu/41graph/Graph.java.html
 * 
 * http://algs4.cs.princeton.edu/41graph/SymbolGraph.java.html
 * 
 * http://introcs.cs.princeton.edu/java/45graph/ - theoretical
 * 
 * http://algs4.cs.princeton.edu/41graph/AdjMatrixGraph.java.html - adjacency matrix
 * 
 * http://faculty.washington.edu/moishe/javademos/ch18%20Code/jss2/Graph.java - adjacency matrix
 * 
 * http://homepage.divms.uiowa.edu/~sriram/21/fall07/code/myListGraph.java
 * 
 * https://github.com/cjalvarado/Course3/blob/master/Course3Solutions/src/basicgraph/Graph.java - string labels to vertices
 * 
 * https://www.cs.virginia.edu/~evans/cs201j/lectures/graph/impl1/Graph.java - string nodes
 * 
 * http://www.codediesel.com/algorithms/building-a-adjacency-matrix-of-a-graph/ - visual adjacency matrix
 * 
 * http://opendatastructures.org/ods-java/12_1_AdjacencyMatrix_Repres.html - details and complexities of adjacency matrix
 * 
 * http://www.algolist.net/Data_structures/Graph/Internal_representation - apparently I really liked this the first time
 * 
 * http://stackoverflow.com/questions/13102738/creating-graphs-using-a-degree-sequence - speaks of degree requirements
 * 
 * http://stackoverflow.com/questions/35185744/degree-of-connectivity-of-a-graph - degree of connectivity
 * 
 * https://github.com/Cs4r/UCSDGraphs/blob/master/src/basicgraph/Graph.java - degree sequence
 * 
 * http://homepage.divms.uiowa.edu/~sriram/21/spring07/code/myGraph.java - get Degree and neighbors... **this seems helpful!
 * 
 * https://google.github.io/guava/releases/21.0/api/docs/com/google/common/graph/Graph.html - java documentation for Graph interface... helpful info
 * 
 * http://opendatastructures.org/ods-java/12_2_AdjacencyLists_Graph_a.html - understanding adjacency lists / graphs
 * 
 * http://www.sanfoundry.com/java-program-generate-graph-given-fixed-degree-sequence/ - fixed degree sequence
 * 
 * https://code.snipcademy.com/tutorials/data-structures/graphs/adjacency-matrices - absolutely amazing tutorial.***
 * 
 * http://stackoverflow.com/questions/4287417/java-get-index-of-element-in-array-error - getting an item from an array
 * 
 * http://stackoverflow.com/questions/8647809/how-to-know-whether-a-vertex-exists-in-my-graph - checking for an edge .... in a program that reads in the graph from a file
 * 
 * http://stackoverflow.com/questions/5773279/checking-whether-two-vertices-are-connected ** - adjacency matrix - includes searching...
 * 
 * https://www.youtube.com/watch?v=D-W7VdUQBto - degree sequence of a graph
 * 
 * http://mathworld.wolfram.com/DegreeSequence.html - degree sequence delivered in a table... (talks about min and max)
 * 
 * https://math.stackexchange.com/questions/608633/list-of-ways-to-tell-if-degree-sequence-is-impossible-for-a-simple-graph - degrees in math formulas
 * 
 * https://math.stackexchange.com/questions/31119/is-a-graph-simple-given-the-number-of-vertices-and-the-degree-sequence - Graph Justifies Claim / Handshaking Lemma
 * 
 * https://en.wikipedia.org/wiki/Handshaking_lemma - Handshaking Lemma - think about the party where people shake hands...
 * 
 * https://en.wikipedia.org/wiki/Seven_Bridges_of_K%C3%B6nigsberg - 1736 paper written by Leonhard Euler... beginning the study of graph theory
 * 
 * http://stackoverflow.com/questions/1200621/how-to-declare-and-initialize-an-array-in-java - review for initializing arrays
 * 
 * https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Global_Objects/Object/toString - toString() method
 * 
 * http://stackoverflow.com/questions/20858833/how-to-print-out-only-return-value-of-a-method - printing out the return value of a method
 * 
 * http://stackoverflow.com/questions/2219565/how-to-print-the-result-of-a-method-with-system-out-println - method calls and print statement complexities
 * 
 * http://stackoverflow.com/questions/13102738/creating-graphs-using-a-degree-sequence - creating graphs using degree sequence
 * 
 * http://algs4.cs.princeton.edu/41graph/GraphGenerator.java.html - graph generator
 * 
 * http://www.sanfoundry.com/java-program-check-if-any-graph-possible-be-constructed-given-degree-sequence/ - checking possibility of graph generation based on degree sequence
 * 
 * https://cs.stackexchange.com/questions/55342/how-to-generate-a-degree-sequence-of-a-degree-distribution - math behind degree generation
 * 
 * https://www.coursera.org/learn/advanced-data-structures/lecture/5fDPg/project-programming-assignment-walkthrough - Coursera Walkthrough. 
 * 
 * http://www.cs.cmu.edu/~clo/www/CMU/DataStructures/Lessons/lesson5_1.htm - object oriented programming - graphs and degrees...
 * 
 * https://www.youtube.com/watch?v=aNKO4ttWmcU - degree sequence vid - graphical sequences and graphing algorithms... ** very good **
 * 
 * http://www.perlmonks.org/bare/?node_id=467742 - perl code for degree sequence
 * 
 * http://stackoverflow.com/questions/16252269/how-to-sort-a-arraylist-in-java - sorting an arrayList
 * 
 * https://www.tutorialspoint.com/java/util/arrays_sort_int.htm - sorting an array - using the built-in method  
 * 
 * http://stackoverflow.com/questions/9814283/need-to-create-a-new-runtimeexception-for-emptystacks - extending a runtime exception
 * 
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html - throwing exceptions (references stacks)
 * 
 * http://stackoverflow.com/questions/19857008/extending-exception-runtimeexception-in-java - good explination for Runtime Exception
 * 
 * https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html - Runtime Exception Java Doc
 */