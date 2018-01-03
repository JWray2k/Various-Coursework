import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Kevin
 */
public final class StringGraph implements Graph {
    // Serializable to save using streams

    private String[] labels;	       // 1D array to store the vertices
    private boolean[][] edgeMatrix;  // 2D array to store adjacencies between vertices
    private int numVertices;
    private int numEdges;
    private int capacity;

    /**
     * Default constructor sets initial capacity to 1
     */
    public StringGraph() {
        this(1);
    }

    /**
     * Parameterized constructor sets initial capacity to given capacity
     *
     * @param initCapacity initial capacity for number of vertices
     * @throws RuntimeException if initial capacity < 1
     */
    public StringGraph(int initCapacity)  throws RuntimeException{
        if (initCapacity < 1) {
            throw new RuntimeException("Parameterized Constructor failed: "
                    + "Capacity must be positive.");
        }

        capacity = initCapacity;

        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];

        for (int i = 0; i < capacity; i++) {
            labels[i] = null;
            for (int j = 0; j < capacity; j++) {
                edgeMatrix[i][j] = false;
            }
        }

        numVertices = 0;
        numEdges = 0;
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
        String[] temp = new String[numVertices];
        // copy labels into temp
        System.arraycopy(labels, 0, temp, 0, temp.length);
        return temp;
    }

    /**
     * Returns the index at which a vertex label is stored.
     *
     * @param v the vertex of interest
     * @return the index at which the vertex is stored. Returns -1 if not found
     */
    public int getIndex(String v) {
        for (int i = 0; i < numVertices; i++) {
            if (v.equals(labels[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Resizes the array of labels and the adjacency matrix to a new capacity.
     * Make the capacity either larger or smaller, depending on the value of
     * newCapacity.
     *
     * @param newCapacity The new capacity. Can be either larger or smaller than
     * current capacity.
     */
    public void resize(int newCapacity) {
        if (newCapacity > capacity) {
            increaseCapacity(newCapacity);
        } else {
            decreaseCapacity(newCapacity);
        }
    }

    // Increases the the size of labels array and adjacency matrix
    // Also set capacity variable to biggerCapacity
    private void increaseCapacity(int biggerCapacity) {
        // Making arrays bigger
        // Array of Labels
        String[] tempLabels = new String[biggerCapacity];
        System.arraycopy(labels, 0, tempLabels, 0, capacity);
        labels = tempLabels;

        // Adjacency Matrix
        boolean[][] tempMatrix = new boolean[biggerCapacity][biggerCapacity];
        for (int i = 0; i < biggerCapacity; i++) {
            for (int j = 0; j < biggerCapacity; j++) {
                if (i < capacity && j < capacity) {
                    tempMatrix[i][j] = edgeMatrix[i][j];
                } else {
                    tempMatrix[i][j] = false;
                }
            }
        }
        edgeMatrix = tempMatrix;
        capacity = biggerCapacity;
    }

    // Decreases the the size of labels array and adjacency matrix
    // Also set capacity variable to smallerCapacity
    private void decreaseCapacity(int smallerCapacity) {
        // Make array of labels smaller
        String[] tempLabels = new String[smallerCapacity];
        System.arraycopy(labels, 0, tempLabels, 0, smallerCapacity);
        labels = tempLabels;

        // Make adjacency matrix smaller
        boolean[][] tempMatrix = new boolean[smallerCapacity][smallerCapacity];
        for (int i = 0; i < smallerCapacity; i++) {
            System.arraycopy(edgeMatrix[i], 0, tempMatrix[i], 0, smallerCapacity);
        }
        edgeMatrix = tempMatrix;

        capacity = smallerCapacity;
    }

    /**
     * Adds a new vertex to the graph.
     * @param v the new vertex to be added
     * @throws RuntimeException if vertex already exists
     */
    @Override
    public void addVertex(String v)  throws RuntimeException{
        if (vertexExists(v)) {
            throw new RuntimeException("Method addVertex(v) Failed: Vertex \""
                    + v + "\" already exists.");
        }

        // if array of vertices is full, we need to expand it and 
        // also expand edgeMatrix
        if (this.numberOfVertices() == this.capacity) {
            resize(2 * capacity);
        }

        labels[numVertices] = v;
        numVertices++;
    }

    /**
     * Determines if a vertex with the given label exists.
     * @param v the label of a vertex.
     * @return true of the vertex exists, false if it does not exist.
     */
    @Override
    public boolean vertexExists(String v) {
        return getIndex(v) != -1;
    }

    /**
     * Determines if an edge with the given end vertices exists.
     * @param u one end vertex
     * @param v the other end vertex
     * @return true if the edge exists, false otherwise.
     * @throws RuntimeException if either u or v does not exist.
     */
    @Override
    public boolean edgeExists(String u, String v) throws RuntimeException {
        int i = getIndex(u);
        if (i == -1) {
            throw new RuntimeException("Method edgeExists(u, v) failed: Vertex \""
                    + u + "\" does not exist.");
        }

        int j = getIndex(v);
        if (j == -1) {
            throw new RuntimeException("Method edgeExists(u, v) failed: Vertex \""
                    + v + "\" does not exist.");
        }

        return this.edgeMatrix[i][j];
    }

    /**
     * Deletes a vertex and all incident edges.
     * @param v The vertex to be deleted
     * @throws RuntimeException if the vertex does not exist
     */
    @Override
    public void deleteVertex(String v) throws RuntimeException {
        int delIndex = getIndex(v); // index of the vertex being deleted
        int lastIndex = numVertices - 1; // last index currently used

        if (delIndex == -1) {
            throw new RuntimeException("Method deleteVertex(v) failed: Vertex \""
                    + v + "\" does not exist.");
        }

        // Adjust adjacency matrix to move the last row/col into the empty
        // row/col created by the deleted vertex.
        //
        // Entry [i][delIndex] will be replaced with entry [i][lastIndex].
        // Entry [delIndex][i] will be replaced with entry [lastIndex][i].
        //
        // There is one exception however, that is when i == delIndex. In that
        // case, [i][delIndex] and [delIndex][i] cannot be true because that
        // wold be a self-loop.
        //
        // We also need to adjust the number of edges whenever there is an 
        // edge at position [i][deleteIndex].
        for (int i = 0; i <= lastIndex; i++) {
            if (edgeMatrix[i][delIndex] == true) {
                // There is an edge between vertex i and the deleted vertex
                numEdges--;
            }

            if (i == delIndex) {
                // this is the exception above. So make sure we don't have
                // a self loop.
                edgeMatrix[i][delIndex] = false;
            } else {
                // This is the new spot where [i][lastIndex] & [lastIndex][i]
                // will be stored.
                edgeMatrix[i][delIndex] = edgeMatrix[i][lastIndex];
                edgeMatrix[delIndex][i] = edgeMatrix[lastIndex][i];
            }
        }

        // Now we need to clear out the row and colum that were being used
        // before we deleted the vertex.
        for (int i = 0; i <= lastIndex; i++) {
            edgeMatrix[i][lastIndex] = false;
            edgeMatrix[lastIndex][i] = false;
        }

        // Finally, we need to adjust the labels to match what we've done 
        // in the adjacency matrix.
        labels[delIndex] = labels[lastIndex];
        labels[lastIndex] = null;

        // Lastly, decrement the number of vertices in the graph.
        numVertices--;

    }

    /**
     * Adds a new edge to the graph.
     * @param u one end vertex of the edge
     * @param v the other end vertex of the edge
     * @throws RuntimeException if edge {u, v} already exists or if either u or
     * v does not exist.
     */
    @Override
    public void addEdge(String u, String v) throws RuntimeException {
        int i = getIndex(u);
        if (i == -1) {
            throw new RuntimeException("Method addEdge(u, v) failed: Vertex \""
                    + u + "\" does not exist.");
        }

        int j = getIndex(v);
        if (j == -1) {
            throw new RuntimeException("Method addEdge(u, v) failed: Vertex \""
                    + v + "\" does not exist.");
        }

        if (edgeMatrix[i][j] == true) {
            throw new RuntimeException("Method addEdge(u, v) failed: Edge {"
                    + u + ", " + v + "} already exists.");
        }

        edgeMatrix[i][j] = true;
        edgeMatrix[j][i] = true;

        numEdges++;
    }

    /**
     * Deletes an edge from the graph.
     * @param u one end vertex of the edge
     * @param v the other end vertex of the edge
     * @throws RuntimeException if edge {u, v} does not exist or if either u or
     * v does not exist.
     */
    @Override
    public void deleteEdge(String u, String v) throws RuntimeException {
        int i = getIndex(u);
        if (i == -1) {
            throw new RuntimeException("Method deleteEdge(u, v) failed: Vertex \""
                    + u + "\" does not exist.");
        }

        int j = getIndex(v);
        if (j == -1) {
            throw new RuntimeException("Method deleteEdge(u, v) failed: Vertex \""
                    + v + "\" does not exist.");
        }

        if (edgeMatrix[i][j] == false) {
            throw new RuntimeException("Method deleteEdge(u, v) failed: Edge {"
                    + u + ", " + v + "} does not exist.");
        }

        edgeMatrix[i][j] = false;
        edgeMatrix[j][i] = false;
        numEdges--;

    }

    /**
     * Returns an array of Strings containing the labels of the neighbors of 
     * the specified vertex.
     * @param v the vertex of interest
     * @return a String array holding the labels the neighbors.
     * @throws RuntimeException if the specified vertex does not exist
     */
    @Override
    public String[] getNeighbors(String v) throws RuntimeException {
        int source = getIndex(v);
        if (source == -1) {
            throw new RuntimeException("method getNeighbors(v) failed: Vertex \""
                    + v + "\" does not exist.");
        }

        int[] neighborIndices = this.getNeighborIndices(source);

        String[] neighbors = new String[neighborIndices.length];

        int neighborIndex;
        for (int i = 0; i < neighbors.length; i++) {
            neighborIndex = neighborIndices[i];
            neighbors[i] = labels[neighborIndex];
        }

        return neighbors;
    }

    /**
     * Returns the degree of a the specified vertex.
     * @param v the vertex of interest
     * @return the degree of the given vertex
     * @throws RuntimeException if the specified vertex does not exist
     */
    @Override
    public int degree(String v) throws RuntimeException {
        int i = getIndex(v);
        if (i == -1) {
            throw new RuntimeException("Method degree(v) failed: Vertex \""
                    + v + "\" does not exist.");
        }

        // Call the overloaded degree method that takes the index of a vertex
        return degree(i);
    }

    // returns the degree of a vertex with given index
    /**
     * Returns the degree of the vertex with the given index
     *
     * @param index The index of the vertex of interest
     * @return The degree of the vertex with the given index
     * @throws RuntimeException if index < 0 || index >= numVertices
     */
    private int degree(int index) throws RuntimeException {
        if (index < 0 || index >= numVertices) {
            throw new RuntimeException("Method degree(index) failed: Index "
                    + index + " is out of range.");
        }

        int numNeighbors = 0;

        // Scan the row for the given index and count neighbors as we go
        for (int i = 0; i < numVertices; i++) {
            if (edgeMatrix[index][i]) {
                numNeighbors++;
            }
        }

        return numNeighbors;
    }

    /**
     * Returns an int array containing the degree sequence of the graph.
     * @return an int array containing the degrees of all vertices, sorted in
     * non-ascending order.
     */    
    @Override
    public int[] degreeSequence() {
        int[] degrees = new int[numVertices];
        for (int v = 0; v < numVertices; v++) {
            degrees[v] = 0;
            for (int i = 0; i < numVertices; i++) {
                degrees[v] += edgeMatrix[v][i] ? 1 : 0;
            }
        }

        Arrays.sort(degrees);

        // reverse becasue degre sequence needs to be in descending order
        int left = 0;
        int right = degrees.length - 1;
        int temp;
        while (left < right) {
            // exchange the left and right elements
            temp = degrees[left];
            degrees[left] = degrees[right];
            degrees[right] = temp;

            // move the bounds toward the center
            left++;
            right--;
        }

        return degrees;
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
        if (this.numberOfVertices() == 0) {
            return new double[]{-1, -1, Double.NaN};
        }
        int[] degSeq = degreeSequence();

        int sum = 0;
        for (int deg : degSeq) {
            sum += deg;
        }
        double avgDegree = (double) sum / numVertices;

        double maxDegree = degSeq[0];
        double minDegree = degSeq[numVertices - 1];

        double[] results = new double[3];
        results[0] = maxDegree;
        results[1] = minDegree;
        results[2] = avgDegree;

        return results;
    }

    /**
     * Returns the maximum degree of the graph.
     * @return the maximum degree
     * @see degreeStats()
     */
    @Override
    public int maxDegree() {
        return (int) (degreeStats()[0]);
    }

    /**
     * Returns the minimum degree of the graph.
     * @return the minimum degree
     * @see degreeStats()
     */
    @Override
    public int minDegree() {
        return (int) (degreeStats()[1]);
    }

    /**
     * Returns the average degree of the graph.
     * @return the average degree
     * @see degreeStats()
     */
    @Override
    public double averageDegree() {
        return degreeStats()[2];
    }

    // returns the indices of all the neighborIncices of a given vertex with index
    /**
     * Returns the indices of all neighbors of the vertex with the given index.
     *
     * @param index The index of the vertex of interest
     * @return an array of int values containing the indices of the neighbors of
     * the vertex of interest
     * @throws RuntimeException if index < 0 || index >= 0
     */
    public int[] getNeighborIndices(int index) throws RuntimeException {
        if (index < 0 || index >= numVertices) {
            throw new RuntimeException("Method getNeighbors(index) failed: Index "
                    + index + " is out of range.");
        }

        int numNeighbors = degree(index);
        int[] neighborIncices = new int[numNeighbors];

        int neighborsFound = 0;

        for (int i = 0; i < numVertices; i++) {
            if (edgeMatrix[index][i]) {
                neighborIncices[neighborsFound] = i;
                neighborsFound++;
            }
        }

        return neighborIncices;
    }
    
    /**
     * Returns the shortest path in this graph from vertex s to vertex t.
     * @param s the source vertex
     * @param t the destination vertex
     * @return a list of strings containing the labels of the vertices along
     * the shortest path from s to t, starting with s and ending with t.
     * @throws RuntimeException of either specified vertex does not exist
     */
    //@Override
    public String[] shortestPath(String s, String t) throws RuntimeException {
        int i = getIndex(s);
        if (i == -1) {
            throw new RuntimeException("Method shortestPath(s, t) failed: Vertex \""
                    + s + "\" does not exist.");
        }

        int j = getIndex(t);
        if (j == -1) {
            throw new RuntimeException("Method edgeExists(s, t) failed: Vertex \""
                    + t + "\" does not exist.");
        }

        String[] prev = bfsSSSP(s);
        List<String> sp = new ArrayList<>();
        String current = t;
        while (prev[this.getIndex(current)] != null) {
            sp.add(0, current);
            current = prev[this.getIndex(current)];
        }

        if (sp.size() > 0) {
            sp.add(0, s);
        }

        return sp.toArray(new String[sp.size()]);

    }

    /**
     * Perform BFS Single Source Shortest Path from specified vertex.
     * @param v Source for shortest paths
     * @return String array containing the "Previous" vertices for the shortest
     * path.
     * @see Graph.shortestPath(String s, String t)
     * @throws RuntimeException if the specified vertex does not exist
     */
    //@Override
    public String[] bfsSSSP(String v) throws RuntimeException {
        if(!vertexExists(v)){
            throw new RuntimeException("Method bfsSSSP(v) failed: Vertex \""
                    + v + "\" does not exist.");
        }
        
        String prev[] = new String[numVertices]; // Previous vertex in SSSP

        // Mark each vertex as "not visited"
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
            prev[i] = null;
        }

        Queue<String> q = new LinkedList<>();

        visited[this.getIndex(v)] = true; // visit the first vertex
        q.add(v); // Add it to the queue

        String w;
        String[] neighbors;
        while (!q.isEmpty()) {
            w = q.remove();
            neighbors = this.getNeighbors(w);
            for (String u : neighbors) {
                if (!visited[this.getIndex(u)]) {
                    visited[this.getIndex(u)] = true;
                    prev[this.getIndex(u)] = w;
                    q.add(u);
                }
            }
        }

        return prev;

    }


    /**
     * Performs a Breadth First Search traversal starting at a given vertex.
     * @param v the vertex at which the BFS traversal is started
     * @return an array of Strings containing the labels of the vertices visited
     * in the order that they were visited.
     * @throws RuntimeException if the specified vertex does not exist
     */
    //@Override
    public String[] bfsOrder(String v) throws RuntimeException {
        if(!vertexExists(v)){
            throw new RuntimeException("Method bfsOrder(v) failed: Vertex \""
                    + v + "\" does not exist.");
        }
        
        String order[] = new String[numVertices]; // Has vertices in visited order
        int count = 0;

        // Mark each vertex as "not visited"
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        Queue<String> q = new LinkedList<>();

        visited[this.getIndex(v)] = true; // visit the first vertex
        q.add(v); // Add it to the queue
        order[count++] = v;

        String w;
        String[] neighbors;
        while (!q.isEmpty()) {
            w = q.remove();
            neighbors = this.getNeighbors(w);
            for (String u : neighbors) {
                if (!visited[this.getIndex(u)]) {
                    visited[this.getIndex(u)] = true;
                    q.add(u);
                    order[count++] = u;
                }
            }
        }

        if (count < numVertices) {
            String[] smaller = new String[count];
            System.arraycopy(order, 0, smaller, 0, count);
            order = smaller;
        }

        return order;
    }


    /**
     * Performs a Depth First Search traversal starting at a given vertex.
     * @param v the vertex at which the DFS traversal is started
     * @return an array of Strings containing the labels of the vertices visited
     * in the order that they were visited.
     * @throws RuntimeException if the specified vertex does not exist
     */
    //@Override
    public String[] dfsOrder(String v) throws RuntimeException {
        if(!vertexExists(v)){
            throw new RuntimeException("Method dfsOrder(v) failed: Vertex \""
                    + v + "\" does not exist.");
        }
        
        String[] order = new String[numVertices];
        int count = 0;

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        List<String> S = new LinkedList<>(); // Use S as a stack
        S.add(0, v);
        visited[this.getIndex(v)] = true;
        order[count++] = v;

        String tos;
        String u;
        String[] neighbors;
        boolean foundUnvisitedNeighbor;

        while (!S.isEmpty()) {
            tos = S.get(0);
            // Look for unvisited neighbor u
            foundUnvisitedNeighbor = false;
            neighbors = this.getNeighbors(tos);
            int i = 0;
            while (i < neighbors.length && !foundUnvisitedNeighbor) {
                u = neighbors[i];
                if (visited[getIndex(u)] == false) {
                    foundUnvisitedNeighbor = true;
                    // visit u
                    S.add(0, u); // Push u on the stack
                    visited[getIndex(u)] = true;
                    order[count++] = u;
                }
                i++;
            }
            if (!foundUnvisitedNeighbor) {
                S.remove(0); // Pop the stack
            }
        }

        if (count < numVertices) {
            String[] smaller = new String[count];
            System.arraycopy(order, 0, smaller, 0, count);
            order = smaller;
        }

        return order;

    }

    /**
     * Determines if the graph is connected.
     * @return true if the graph is connected, false if the graph is not
     * connected.
     */
    //@Override
    public boolean isConnected() {
        return bfsOrder(labels[0]).length == numVertices;
    }
} // end of class

