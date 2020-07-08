import java.util.Stack;
import java.util.ArrayList;
//Deep finding algorithm
public class DeepFinding extends Algorithm {
    //Constructor
    public DeepFinding(Graph _graph, IHM _ihm){
        super(_graph, _ihm);
    }
    //Solving method
    @Override
    protected void run(){
        //Generates the stack and an array of not visited nodes
        ArrayList<Node> nonVisitedNodes= graph.nodeList();
        Stack<Node> nodesToVisit= new Stack<Node>();
        nodesToVisit.push(graph.entryNode());
        nonVisitedNodes.remove(graph.entryNode());
        
        //Exit initialization
        Node exitNode= graph.exitNode();
        boolean exitFound= false;

        //Main loop
        while(!exitFound && nodesToVisit.size()!=0){
            Node currentNode = nodesToVisit.pop();
            if(currentNode.equals(exitNode)){
                //Exit found, end of the algorithm
                exitFound=true;
            }else{
                for(Node n : graph.adyacentNodeList(currentNode)){
                    if(nonVisitedNodes.contains(n)){
                        nonVisitedNodes.remove(n);
                        n.precursor=currentNode;
                        n.distanceFromStart= currentNode.distanceFromStart+graph.cost(currentNode, n);
                        nodesToVisit.push(n);
                    }
                }
            }
        }
    }
}