import java.util.ArrayList;
//Dijkstra's algorithm
public class Dijkstra extends Algorithm{
    //Constructor
    public Dijkstra(Graph _graph, IHM _ihm){
        super(_graph, _ihm);
    }
    //Solving method
    @Override
    protected void run(){
        //Initialize
        ArrayList<Node> nodeList= graph.nodeList();
        boolean exitFound= false;
        //Main loop
        while(nodeList.size()!=0 && !exitFound){
            //Findd the node with less distance
            Node currentNode= nodeList.get(0);
            for(Node node : nodeList){
                if(node.distanceFromStart<currentNode.distanceFromStart){
                    currentNode=node;
                }
            }
            if(currentNode.equals(graph.exitNode())){
                exitFound=true;
            }else{
                ArrayList<Arc> exitArcList= graph.exitArcList(currentNode);
                for(Arc arc : exitArcList){
                    if(arc.origin.distanceFromStart + arc.cost < arc.destiny.distanceFromStart){
                        arc.destiny.distanceFromStart= arc.origin.distanceFromStart + arc.cost;
                        arc.destiny.precursor= arc.origin;
                    }
                }
                nodeList.remove(currentNode);
            }
        }
    }
}