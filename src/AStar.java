import java.util.ArrayList;
//A* algorithm
public class AStar extends Algorithm{
    //Constructor
    public AStar(Graph _graph, IHM _ihm){
        super(_graph, _ihm);
    }
    //Solving method
    @Override
    protected void run(){
        //Initialize
        graph.calculateStimatedDistances();
        ArrayList<Node> nodeList= graph.nodeList();
        boolean exitFound=false;

        //Main loop
        while(nodeList.size()!=0 && !exitFound){
            //Finds the node with smaller distance
            Node currentNode = nodeList.get(0);
            for(Node node: nodeList){
                if(node.distanceFromStart+ node.stimatedDistance < currentNode.distanceFromStart+ currentNode.stimatedDistance){
                    currentNode=node;
                }
            }
            if(currentNode.equals(graph.exitNode())){
                //Exit found
                exitFound=true;
            }
            else{
                //Aply the arcs of this node
                ArrayList<Arc> exitArcList= graph.exitArcList(currentNode);
                for( Arc arc : exitArcList){
                    if(arc.origin.distanceFromStart+arc.cost< arc.destiny.distanceFromStart){
                        arc.destiny.distanceFromStart= arc.origin.distanceFromStart+arc.cost;
                        arc.destiny.precursor=arc.origin;
                    }
                }
                nodeList.remove(currentNode);
            }
        }
    }
}