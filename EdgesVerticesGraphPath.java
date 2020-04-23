package com.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EdgesVerticesGraphPath {
public static void main(String[] args) {
	
	//add all edged here
	 // Create a sample graph 
	GraphN g = new GraphN(4); 
    g.addEdge(0,1); 
    g.addEdge(0,2); 
    g.addEdge(0,3); 
    g.addEdge(2,0); 
    g.addEdge(2,1); 
    g.addEdge(1,3); 
//    A,B
//    A,C
//    A,D
//    B,D
//    B,C
//    C,D
//    D,null
    
    Map<String, LinkedList<String>> paths = new HashMap<String, LinkedList<String>>();
    LinkedList<String> aList = new LinkedList<String>();
    aList.add("B");aList.add("C");aList.add("D");aList.add("E");
    paths.put("A", aList);
    
    LinkedList<String> bList = new LinkedList<String>();
    bList.add("C");bList.add("D");
    paths.put("B", bList);
    
    LinkedList<String> cList = new LinkedList<String>();
    cList.add("D");
    paths.put("C", cList);
    
    LinkedList<String> dList = new LinkedList<String>();
    paths.put("D", dList);
    

    System.out.println(g);
	//print possible paths for A to D 
    printPaths("","A","D", "", paths,null,null);
}


private static void printPaths(String basePath, String source, String destination, String buildPath, 
		Map<String, LinkedList<String>> allPathsMap, 
		LinkedList<String> baseVertices, LinkedList<String> inprocessVertices ) {
	if(source.equals(destination)) {
		//buildPath = buildPath+","+destination;
		//System.out.println("Print Path1="+buildPath);
		//buildPath = "";
	}
	if(baseVertices==null) {
		baseVertices = (LinkedList<String>) allPathsMap.get(source);
		buildPath = source;
		basePath = source;
		identifyEdges(basePath, source,destination, buildPath, allPathsMap, baseVertices, baseVertices);
	}
		 
	identifyEdges(basePath, source,destination, buildPath, allPathsMap, baseVertices, inprocessVertices);
	
}

private static void identifyEdges(String basePath, String source, String destination, String buildPath, 
		Map<String, LinkedList<String>> allPathsMap, LinkedList<String> baseVertices, LinkedList<String> inprocessVertices) {
	
	for(String vertice : inprocessVertices) {
		LinkedList<String> subVertices = allPathsMap.get(vertice);
		buildPath = buildPath+","+vertice;
		if(subVertices.size()==0) {
			System.out.println("Print Path2=="+buildPath);
			buildPath = "";
			baseVertices.remove();
			subVertices = baseVertices;
			buildPath = basePath;
		}
		printPaths(basePath, vertice, destination, buildPath, allPathsMap, baseVertices, subVertices);
	}
}
}

class GraphN{

    // No. of vertices in graph 
    private int v;  
      
    // adjacency list  
    private ArrayList<Integer>[] adjList;  
      
    //Constructor 
    public GraphN(int vertices){ 
          
        //initialise vertex count 
        this.v = vertices; 
          
        // initialise adjacency list 
        initAdjList();  
    } 
      
    // utility method to initialise 
    // adjacency list 
    @SuppressWarnings("unchecked") 
    private void initAdjList() 
    { 
        adjList = new ArrayList[v]; 
          
        for(int i = 0; i < v; i++) 
        { 
            adjList[i] = new ArrayList<>(); 
        } 
    } 
      
    // add edge from u to v 
    public void addEdge(int u, int v) 
    { 
        // Add v to u's list. 
        adjList[u].add(v);  
    } 
	
}