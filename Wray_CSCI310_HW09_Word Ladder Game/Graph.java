/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jw91482
 */
public interface Graph {

    
    /**
     * Returns the number of vertices in the graph.
     * @return the number of vertices in the graph
     */
     int numberOfVertices();

    
    /**
     * Returns the number of edges in the graph.
     * @return the number of edges in the graph
     */
     int numberOfEdges();

    
    /**
     * Returns an array of Strings containing the labels of the vertices.
     * @return a String array containing the vertex labels
     */
     String[] getVertexLabels();

    
    /**
     * Adds a new vertex to the graph.
     * @param v the new vertex to be added
     * @throws RuntimeException if vertex already exists
     */
     void addVertex(String v) throws RuntimeException;

    
    /**
     * Determines if a vertex with the given label exists.
     * @param v the label of a vertex.
     * @return true of the vertex exists, false if it does not exist.
     */
     boolean vertexExists(String v);

    
    /**
     * Determines if an edge with the given end vertices exists.
     * @param u one end vertex
     * @param v the other end vertex
     * @return true if the edge exists, false otherwise.
     * @throws RuntimeException if either u or v does not exist.
     */
     boolean edgeExists(String u, String v) throws RuntimeException;

    
    /**
     * Deletes a vertex and all incident edges.
     * @param v The vertex to be deleted
     * @throws RuntimeException if the vertex does not exist
     */
     void deleteVertex(String v) throws RuntimeException;

    
    /**
     * Adds a new edge to the graph.
     * @param u one end vertex of the edge
     * @param v the other end vertex of the edge
     * @throws RuntimeException if edge {u, v} already exists or if either u or
     * v does not exist.
     */
     void addEdge(String u, String v) throws RuntimeException;

    
    /**
     * Deletes an edge from the graph.
     * @param u one end vertex of the edge
     * @param v the other end vertex of the edge
     * @throws RuntimeException if edge {u, v} does not exist or if either u or
     * v does not exist.
     */
     void deleteEdge(String u, String v) throws RuntimeException;

    
    /**
     * Returns an array of Strings containing the labels of the neighbors of 
     * the specified vertex.
     * @param v the vertex of interest
     * @return a String array holding the labels the neighbors.
     * @throws RuntimeException if the specified vertex does not exist
     */
     String[] getNeighbors(String v) throws RuntimeException;

    
    /**
     * Returns the degree of a the specified vertex.
     * @param v the vertex of interest
     * @return the degree of the given vertex
     * @throws RuntimeException if the specified vertex does not exist
     */
     int degree(String v) throws RuntimeException;

    
    /**
     * Returns the maximum degree of the graph.
     * @return the maximum degree
     * @see degreeStats()
     */
     int maxDegree();

    
    /**
     * Returns the minimum degree of the graph.
     * @return the minimum degree
     * @see degreeStats()
     */
     int minDegree();

    
    /**
     * Returns the average degree of the graph.
     * @return the average degree
     * @see degreeStats()
     */
     double averageDegree();

    /**
     * Returns the maximum degree, minimum degree, and average degree of this
     * graph. If Graph is empty: max = -1, min = -1, avg = NaN.
     * @return a three element array of doubles containing max, min, avg degree.
     * @see Graph.maxDegree()
     * @see Graph.minDegree()
     * @see Graph.avgerageDegree()
     */
     double[] degreeStats();
    
    
    /**
     * Returns an int array containing the degree sequence of the graph.
     * @return an int array containing the degrees of all vertices, sorted in
     * non-ascending order.
     */    
     int[] degreeSequence();
    
}
