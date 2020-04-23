package com.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }
    
    List<String> printPath(String label1, String label2){
    	List<String> pathList = new ArrayList<String>();
    	List<Vertex> vertexList = adjVertices.get(new Vertex(label1));
    	String pathBuilder = "";
    	pathBuilder = pathBuilder+"->"+label1;
    	for(Vertex vertex : vertexList) {
    		pathBuilder = pathBuilder+"->"+vertex.toString();
    		List<Vertex> vertexList2 = adjVertices.get(new Vertex(vertex.toString()));
    		System.out.println("1=>"+pathBuilder);
    		if(vertex.toString().equals(label2)) {
    			System.out.println("11=>"+pathBuilder);
    			pathBuilder="";
    			pathBuilder=pathBuilder+"->"+label1;
    		}
    		for(Vertex vertex2 : vertexList2) {
        		pathBuilder = pathBuilder+"->"+vertex2.toString();
        		List<Vertex> vertexList3 = adjVertices.get(new Vertex(vertex2.toString()));
        		System.out.println("2=>"+pathBuilder);
        		if(vertex2.toString().equals(label2)) {
        			System.out.println("22=>"+pathBuilder);
        			pathBuilder="";
        			pathBuilder=pathBuilder+"->"+label1;
        		}
        		for(Vertex vertex3 : vertexList3) {
            		pathBuilder = pathBuilder+"->"+vertex3.toString();
            		List<Vertex> vertexList4 = adjVertices.get(new Vertex(vertex3.toString()));
            		System.out.println("3=>"+pathBuilder);
            		if(vertex3.toString().equals(label2)) {
            			System.out.println("33=>"+pathBuilder);
            			pathBuilder="";
            			pathBuilder=pathBuilder+"->"+label1;
            		}
            	}
        	}
    	}
    	return null;
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
    
    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
}