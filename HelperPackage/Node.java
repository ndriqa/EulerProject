package HelperPackage;
/**We use a node to find shortest or longest path in a graph.
 * Since euler project no, 18 and 67 requires the longest route
 * in an upside down tree graph, we don't need to use variable visited
 * since we can't go back to upper levels of the hierarchy.
 *
 * @author ndriqa
 * */

public class Node {
    int value;
    int distance;

    Node previous;
    boolean visited;

    public Node(int i){
        value = i;
        distance = 0;
    }

    public void setVisited(boolean v) {
        visited = v;
    }
    public void setPrevious(Node p) {
        previous = p;
    }
    public void setDistance(int d){
        distance = d;
    }

    public int getDistance(){
        return distance;
    }
    public int getValue(){
        return value;
    }
}
