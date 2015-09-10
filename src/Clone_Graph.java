/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

         1
        / \
       /   \
      0 --- 2
           / \
           \_/
 Hide Tags: Depth-first Search Breadth-first Search Graph

 */

import java.util.*;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Clone_Graph {
    /**
     * Solution 1: DFS recursive
     *
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if(node==null)return null;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        return helper1(node,map);
    }
    private UndirectedGraphNode helper1(UndirectedGraphNode node,Map<UndirectedGraphNode,UndirectedGraphNode> map){
        //get the node' which is copied by node
        UndirectedGraphNode graphNode = new UndirectedGraphNode(node.label);
        //relate node to node'
        map.put(node,graphNode);
        //Recursive
        for(UndirectedGraphNode tempNode:node.neighbors){
            UndirectedGraphNode newNode = map.containsKey(tempNode)?map.get(tempNode):helper1(tempNode,map);
            graphNode.neighbors.add(newNode);
        }
        return graphNode;
    }

    /**
     *  Solution2:  BFS
     *
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node==null)return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new  HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node,root);
        queue.offer(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                UndirectedGraphNode tempNode = queue.poll();
                for( UndirectedGraphNode neighborNode: tempNode.neighbors){
                    //if neighborNode has a self-cycle, we can catch that.
                    UndirectedGraphNode newNeighborNode = map.get(neighborNode);
                    //if not, we can use new node to replace it.
                    if(!map.containsKey(neighborNode)){
                        queue.offer(neighborNode);
                        newNeighborNode = new UndirectedGraphNode(neighborNode.label);
                        map.put(neighborNode,newNeighborNode);

                    }
                    map.get(tempNode).neighbors.add(newNeighborNode);
                }
            }

        }
        return root;

    }

}


class UndirectedGraphNode {
       int label;
       List<UndirectedGraphNode> neighbors;
       UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}