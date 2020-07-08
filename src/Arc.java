public class Arc {
    protected Node origin;
    protected Node destiny;
    protected double cost;
    //Constructor
    public Arc(Node _origin, Node _destiny, double _cost){
        origin=_origin;
        destiny=_destiny;
        cost=_cost;
    }
}