public abstract class Algorithm {
    protected Graph graph;
    protected IHM ihm;
    //Constructor
    public Algorithm(Graph _graph, IHM _ihm){
        graph=_graph;
        ihm=_ihm;
    }
    protected abstract void run();
    public final void resolve(){
        graph.clear();
        run();
        ihm.showResult(graph.rebuildPath(),graph.exitNode().distanceFromStart);
    }
}