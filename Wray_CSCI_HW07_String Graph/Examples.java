
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jw91482
 */
public class Examples {
    
    public static void main(String[] args) {
        k5_1();
        k5_2();
        disconnected();
    }
    
    /**
     * Make a complete graph with 5 vertices and then delete the vertices one
     * at a time.
     */
    public static void k5_1(){
        Graph g = makeK5();
        printGraph(g, "Make K5 & Delete Vertices");
        
        System.out.println();
        String u = "A", v = "B";
        showIfVertexExists(g, u);
        showIfVertexExists(g, v);
        showIfEdgeExists(g, u, v);
        
        // Remove vertices one at a time
        String[] V = g.getVertexLabels();
        for(String w : V){
            g.deleteVertex(w);
            printGraph(g, "Delete Vertex " + w);
        }
        
    }
    
    /**
     * Make a complete graph with 5 vertices and then delete the edges one
     * at a time.
     */
    public static void k5_2(){
        Graph g = makeK5();
        printGraph(g, "Make K5 & Delete Edges");
        
        System.out.println();
        String u = "A", v = "B";
        showIfVertexExists(g, u);
        showIfVertexExists(g, v);
        showIfEdgeExists(g, u, v);
        
        // Remove vertices one at a time
        String[] V = g.getVertexLabels();
        for(int i = 0; i < V.length - 1; i++){
            for(int j = i + 1; j < V.length; j++){
                g.deleteEdge(V[i], V[j]);
                printGraph(g, "Delete Edge {" + V[i] + ", " + V[j] + "}");                
            }
        }
        
    }
    
    public static void disconnected(){
        Graph g = makeExample();
        printGraph(g, "Disconnected Example");
    }
    
    public static void printGraph(Graph g, String message){
        System.out.println("========================================");
        System.out.println(message);
        
        System.out.println("n = " + g.numberOfVertices());
        System.out.println("m = " + g.numberOfEdges());
        
        System.out.println("\nmax deg = " + g.maxDegree());
        System.out.println("min deg = " + g.minDegree());
        System.out.println("avg deg = " + g.averageDegree());
        
        System.out.println("\nDegree & Neighbors");
        String[] V = g.getVertexLabels();
        for(String v : V){
            String[] neighbors = g.getNeighbors(v);
            System.out.print("deg(" + v + ") = " + g.degree(v));
            System.out.println(", N(" + v + ") = " + Arrays.toString(neighbors));
        }
        
        System.out.println("\nDegree Sequence: " + Arrays.toString(g.degreeSequence()));
    }
    
    public static void showIfEdgeExists(Graph g, String u, String v){
        String message = "Edge {" + u + ", " + v + "}";
        if(g.edgeExists(u, v)){
            message += " exists.";
        } else {
            message += " does NOT exist";
        }
        
        System.out.println(message);
    }
    
    public static void showIfVertexExists(Graph g, String v){
        String message = "Vertex " + v;
        if(g.vertexExists(v)){
            message += " exists.";
        } else {
            message += " does NOT exist";
        }
        
        System.out.println(message);
    }

    public static Graph makeK5(){
        Graph k5 = new StringGraph(5);

        String[] V = {"A", "B", "C", "D", "E"};        
        // Add the five vertices
        for(String v : V){
            k5.addVertex(v);
        }
        
        // Add all possible edges
        k5.addEdge("A", "B");
        k5.addEdge("A", "C");
        k5.addEdge("A", "D");
        k5.addEdge("A", "E");
        k5.addEdge("B", "C");
        k5.addEdge("B", "D");
        k5.addEdge("B", "E");
        k5.addEdge("C", "D");
        k5.addEdge("C", "E");
        k5.addEdge("D", "E");
        
        return k5;
    }
    
    public static Graph makeExample(){
        String[] V = {"A","B","C","D","E","F","G","H","I","J","K"};
        Graph g = new StringGraph();
        
        // Add the vertices
        for(String v : V){
            g.addVertex(v);
        }
        
        // Define edges in a m x 2 array
        String[][] E = new String[13][2]; // there are 13 edges in this example
        // First connected component
        E[0][0] = "A"; E[0][1] = "B"; // Edge {A,B}
        E[1][0] = "B"; E[1][1] = "C"; // Edge {B,C}
        E[2][0] = "C"; E[2][1] = "D"; // Edge {C,D}
        E[3][0] = "D"; E[3][1] = "E"; // Edge {D,E}
        E[4][0] = "E"; E[4][1] = "A"; // Edge {E,A}
        E[5][0] = "B"; E[5][1] = "D"; // Edge {B,D}
        
        // Second connected component
        E[6][0] = "F"; E[6][1] = "G"; // Edge {F,G}
        E[7][0] = "G"; E[7][1] = "H"; // Edge {G,H}
        E[8][0] = "H"; E[8][1] = "F"; // Edge {H,F}
        E[9][0] = "I"; E[9][1] = "K"; // Edge {I,K}
        E[10][0] = "K"; E[10][1] = "J"; // Edge {K,J}
        E[11][0] = "J"; E[11][1] = "I"; // Edge {J,I}
        E[12][0] = "H"; E[12][1] = "I"; // Edge {H,I}
        
        for(int i = 0; i < 13; i++){
            g.addEdge(E[i][0], E[i][1]);
        }
        
        return g;
        
    }
}


