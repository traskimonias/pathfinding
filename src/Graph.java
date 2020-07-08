import java.util.ArrayList;
public interface Graph {

    Node entryNode();
    Node exitNode();

    ArrayList<Node> nodeList();
    ArrayList<Node> adyacentNodeList(Node origin);
    ArrayList<Arc> arcList();
    ArrayList<Arc> exitArcList(Node origin);

    int nodeNumber();
    double cost(Node exit, Node arrive);
    String rebuildPath();
    void calculateStimatedDistances();
    void clear();
}