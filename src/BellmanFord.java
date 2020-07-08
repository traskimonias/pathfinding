import java.util.ArrayList;
//Bellman Ford's algorithm
public class BellmanFord extends Algorithm {
    //Constructor
    public BellmanFord(Graph _graph, IHM _ihm){
        super(_graph, _ihm);
    }
    //Solving method
    @Override
    protected void run(){
        //Initialize
        boolean distanceChanged= true;
        int i =0;
        ArrayList<Arc> arcList= graph.arcList();

        //Main loop
        int maxLoopTimes= graph.nodeNumber()-1;
        while(i<maxLoopTimes && distanceChanged){
            distanceChanged=false;
            for(Arc arc: arcList){
                if(arc.origin.distanceFromStart+arc.cost < arc.destiny.distanceFromStart){
                    //Shorter path found
                    arc.destiny.distanceFromStart= arc.origin.distanceFromStart+arc.cost;
                    arc.destiny.precursor= arc.origin;
                    distanceChanged=true;
                }
            }
            i++;
        }
        //Check if its negative
        for(Arc arc : arcList){
            if(arc.origin.distanceFromStart+arc.cost < arc.destiny.distanceFromStart){
                System.err.println("Negative loop. There is no shorter path");
            }
        }
    }
}