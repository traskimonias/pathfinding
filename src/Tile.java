public class Tile extends Node {
    protected TileType type;
    protected int row;
    protected int column;

    //Constructor
    public Tile(TileType _type, int _row, int _column){
        type=_type;
        row=_row;
        column=_column;
    }
    //If the path can croos this tile
    //Only road, grass and bridge are accesible
    boolean accesible(){
        return (type.equals(TileType.Road) || type.equals(TileType.Grass) || type.equals(TileType.Bridge));
    }
    //How much does it cost to croos this tile
    double cost(){
        switch(type){
            case Road:
                return 1;
            case Bridge:
                return 2;
            case Grass:
                return 2;
            default :
                return Double.POSITIVE_INFINITY;
        }
    }
    //toString shows coordinates and type
    @Override
    public String toString(){
        return "["+row+";"+column+";"+type.toString()+"]";
    }
}