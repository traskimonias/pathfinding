public class TileTypeConverter {
    public static TileType charToType(char c){
        switch(c){
            case ' ' :
                return TileType.Grass;
            case '*':
                return TileType.Tree;
            case '=':
                return TileType.Bridge;
            case 'X':
                return TileType.Water;
            case '.':
                return TileType.Road;
        }
        return null;
    }
}