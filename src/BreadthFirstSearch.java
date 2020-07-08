import java.util.LinkedList;
import java.util.ArrayList;
//Breadth First Searching algorithm
public class BreadthFirstSearch extends Algorithm {
    //Constructor
    public BreadthFirstSearch(Graph _graph, IHM _ihm){
        super(_graph, _ihm);
    }
    //Solving method
    @Override
    protected void run(){
        //Generates the linked list and an array of not visited nodes
        ArrayList<Node> nonVisitedNodes= graph.nodeList();
        LinkedList<Node> nodesToVisit= new LinkedList<Node>();
        nodesToVisit.add(graph.entryNode());
        nonVisitedNodes.remove(graph.entryNode());
        
        //Exit initialization
        Node exitNode= graph.exitNode();
        boolean exitFound= false;

        //Main loop
        while(!exitFound && nodesToVisit.size()!=0){
            Node currentNode = nodesToVisit.removeFirst();
            if(currentNode.equals(exitNode)){
                //Exit found, end of the algorithm
                exitFound=true;
            }else{
                //Add the nodes yet to be visited
                for(Node n : graph.adyacentNodeList(currentNode)){
                    if(nonVisitedNodes.contains(n)){
                        nonVisitedNodes.remove(n);
                        n.precursor=currentNode;
                        n.distanceFromStart= currentNode.distanceFromStart+graph.cost(currentNode, n);
                        nodesToVisit.add(n);
                    }
                }
            }
        }
    }
}