import java.time.Duration;
import java.time.LocalDateTime;
public class App implements IHM{ 
    public static void main(String[] args) throws Exception {
        System.out.println("Pathfinding");
        App app= new App();
        app.execute();
    }
    //To visualize the result
    @Override
    public void showResult(String path, double distance){
        System.out.println("Path (size: "+distance+"):"+path);
    }
    //Execute all algorithms in secuence
    private void executeAllAlgorithms(Graph graph){
        executeAlgorithm("Deep", graph);
        executeAlgorithm("Breadth", graph);
        executeAlgorithm("Bellman-Ford", graph);
        executeAlgorithm("Dijkstra", graph);
        executeAlgorithm("A*", graph);
    }
    //Execute algorithm
    private void executeAlgorithm(String name,Graph graph){
        //Initialize
        LocalDateTime start;
        LocalDateTime end;
        Duration duration;
        Algorithm algo= null;

        //Create the algorithm
        switch(name){
            case "Deep":
                algo=new DeepFinding(graph, this);
                break;
            case "Breadth":
                algo= new BreadthFirstSearch(graph, this);
                break;
            case "Bellman-Ford":
                algo= new BellmanFord(graph, this);
                break;
            case "Dijkstra":
                algo= new Dijkstra(graph, this);
                break;
            case "A*":
                algo= new AStar(graph, this);
        }
        //Solve
        System.out.println("Algorithm: "+name);
        start=LocalDateTime.now();
        algo.resolve();
        end=LocalDateTime.now();
        duration= Duration.between(start, end);
        System.out.println("Duration (ms): "+duration.toMillis()+" \n");
    }
    private void execute(){
        //First map
        String mapStr = "..  XX   .\n" 
                      + "*.  *X  *.\n" 
                      + " .  XX ...\n" 
                      + " .* X *.* \n" 
                      + " ...=...  \n" 
                      + " .* X     \n" 
                      + " .  XXX*  \n" 
                      + " .  * =   \n" 
                      + " .... XX  \n" 
                      + "   *.  X* ";
        Map map1= new Map(mapStr, 0, 0, 9, 9);
        executeAllAlgorithms(map1);
        // Second map
        mapStr = "...*     X .*    *  \n" 
               + " *..*   *X .........\n"  
               + "   .     =   *.*  *.\n" 
               + "  *.   * XXXX .    .\n" 
               + "XXX=XX   X *XX=XXX*.\n" 
               + "  *.*X   =  X*.  X  \n" 
               + "   . X * X  X . *X* \n" 
               + "*  .*XX=XX *X . XXXX\n" 
               + " ....  .... X . X   \n" 
               + " . *....* . X*. = * "; 
        Map mapa2 = new Map(mapStr, 0, 0, 9, 19);
        executeAllAlgorithms(mapa2);
    }
}
