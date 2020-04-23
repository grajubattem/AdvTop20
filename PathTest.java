package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PathTest {
	public static void main(String[] args) {
		String[] aNodes = new String[] {"B","C","D"};
		String[] bNodes = new String[] {"C","D"};
		String[] cNodes = new String[] {"D"};
		String[] dNodes = new String[] {};
		
		Map<String, List<String>> nodesMap = new HashMap<String, List<String>>();
		nodesMap.put("A", Arrays.asList(aNodes));
		nodesMap.put("B", Arrays.asList(bNodes));
		nodesMap.put("C", Arrays.asList(cNodes));
		nodesMap.put("D", Arrays.asList(dNodes));
		
		
		printNodesPath(nodesMap);
		
		for(String nodeName : nodesMap.keySet()){
			String path = "";
			System.out.println("1"+nodeName);
			
			Iterator<String> iter = nodesMap.get(nodesMap).iterator();
			while(iter.hasNext()) {
				String node=iter.next();
				System.out.println("2"+node);
				nodesMap.get(node).iterator();
			}
			
			path="";
		}
	}

	private static Map<String, List<String>>  printNodesPath(Map<String, List<String>> nodesMap) {
		//map iterate rootsnodes, tract path
		//call process subnodes, trackpath
		for(String nodeName : nodesMap.keySet()){
			String path = nodeName+"";
			System.out.println("1"+nodeName);
			processNodes(path, nodesMap.get(path));
		}
		return null;
	}
	
	static void processNodes(String path, List<String> nodes){
		
	}
}

class Node{
	private String nodeName;
	private List<String> nodeList = new ArrayList<String>();
	Node(String nodeName){
		this.nodeName = nodeName;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public List<String> getNodeList() {
		return nodeList;
	}
	public void addToNodeList(List<String> nodeList) {
		this.nodeList = nodeList;
	}
	
}