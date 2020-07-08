import java.util.ArrayList;
import java.util.Arrays;
public class Map implements Graph{ 
    Tile[][] tiles;
    int rowNumber;
    int columnNumber;
    Tile entryN;
    Tile exitN;
    ArrayList<Node> nodeL=null;
    ArrayList<Arc> arcL=null;
    public Map(String _map, int _exitRow, int _exitColumn, int _entryRow, int _entryColumn){
        //Generates tiles array
        String[] rows= _map.split("\n");
        rowNumber= rows.length;
        columnNumber=rows[0].length();
        tiles= new Tile[rowNumber][];
        //Fill
        for(int i=0; i<rowNumber;i++){
            tiles[i]= new Tile[columnNumber];
            for(int j=0; j<columnNumber; j++){
                TileType type= TileTypeConverter.charToType(rows[i].charAt(j));
                tiles[i][j] = new Tile(type, i, j);
            }
        }
        //Entry and exit
        entryN= tiles[_entryRow][_entryColumn];
        entryN.distanceFromStart= entryN.cost();
        exitN= tiles[_exitRow][_exitColumn];
        //List nodes and arcs
        nodeList();
        arcList();
    }
    @Override
    public Node entryNode(){
        return entryN;
    }
    @Override
    public Node exitNode(){
        return exitN;
    }
    @Override
    public ArrayList<Node> nodeList(){
        if(nodeL == null){
            nodeL = new ArrayList<Node>();
            for(int i=0; i<rowNumber;i++){
                nodeL.addAll(Arrays.asList(tiles[i]));
            }
        }
        return nodeL;
    }
    @Override
    public ArrayList<Node> adyacentNodeList(Node origin){
        //Initialize
        ArrayList<Node> exitNodeList= new ArrayList<Node>();
        int row= ((Tile)origin).row;
        int column= ((Tile)origin).column;
        //Checks if the adyacent tiles are accesible
        //Right neighbour
        if(column-1>=0 && tiles[row][column-1].accesible()){
            exitNodeList.add(tiles[row][column-1]);
        }
        //Left
        if(column+1<columnNumber && tiles[row][column+1].accesible()){
            exitNodeList.add(tiles[row][column+1]);
        }
        //Up
        if(row-1>=0 && tiles[row-1][column].accesible()){
            exitNodeList.add(tiles[row-1][column]);
        }
        //Down
        if(row+1<rowNumber && tiles[row+1][column].accesible()){
            exitNodeList.add(tiles[row+1][column]);
        }
        return exitNodeList;
    }
    @Override
    public ArrayList<Arc> exitArcList(Node origin){
        ArrayList<Arc> exitArcL= new ArrayList<Arc>();
        int row= ((Tile)origin).row;
        int column= ((Tile)origin).column;
        if(tiles[row][column].accesible()){
            //If the tile its accesible check if its neighbours are too
            //Right neighbour
            if(column-1>=0 && tiles[row][column-1].accesible()){
                exitArcL.add(new Arc(tiles[row][column],tiles[row][column-1] ,tiles[row][column-1].cost()));
            }
            //Left
            if(column+1<columnNumber && tiles[row][column+1].accesible()){
                exitArcL.add(new Arc(tiles[row][column],tiles[row][column+1] ,tiles[row][column+1].cost()));
            }
            //Up
            if(row-1>=0 && tiles[row-1][column].accesible()){
                exitArcL.add(new Arc(tiles[row][column],tiles[row-1][column] ,tiles[row-1][column].cost()));
            }
            //Down
            if(row+1<rowNumber && tiles[row+1][column].accesible()){
                exitArcL.add(new Arc(tiles[row][column],tiles[row+1][column] ,tiles[row+1][column].cost()));
            }
        }
        return exitArcL;
    }
    @Override
    public ArrayList<Arc> arcList(){
        if(arcL==null){
            arcL=new ArrayList<Arc>();
            //Loop through all nodes
            for(int row=0; row< rowNumber;row++){
                for(int column=0;column<columnNumber;column++){
                    ArrayList<Arc> arcs = exitArcList(tiles[row][column]);
                    arcL.addAll(arcs);
                }
            }
        }
        return arcL;
    }
    @Override
    public double cost(Node entry,Node exit){
        return ((Tile)exit).cost();
    }  
    @Override
    public int nodeNumber(){
        return rowNumber*columnNumber;
    }
    @Override
    public String rebuildPath(){
        //Initialize
        String path="";
        Tile currentNode=exitN;
        Tile previousNode= (Tile) exitN.precursor;
        //Loop throught all the path
        while(previousNode!=null){
            path="-"+currentNode.toString()+path;
            currentNode=previousNode;
            previousNode= (Tile) currentNode.precursor;
        }
        path=currentNode.toString()+path;
        return path;
    }
    @Override
    public void calculateStimatedDistances(){
         //Loop through all nodes
         for(int row=0; row< rowNumber;row++){
            for(int column=0;column<columnNumber;column++){
                tiles[row][column].stimatedDistance=Math.abs(exitN.row-row)+Math.abs(exitN.column-column);
            }
        }
    }
    @Override
    public void clear(){
        //Clear list
        nodeL=null;
        arcL=null;
        //Clear distances and precoursors
        for(int row=0; row< rowNumber;row++){
            for(int column=0;column<columnNumber;column++){
                tiles[row][column].distanceFromStart=Double.POSITIVE_INFINITY;
                tiles[row][column].precursor=null;
            }
        }
        //Starting node
        entryN.distanceFromStart=entryN.cost();
    }
}