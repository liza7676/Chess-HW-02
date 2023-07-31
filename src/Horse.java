public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }
    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (toLine < 0 || toColumn < 0 || toLine > 7 || toColumn > 7)
            return false;
        if(chessBoard.board[toLine][toColumn]!= null) {
            if ( chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())){
                return false;
            }
        }
        int x = line - toLine;
        int y = column -toColumn;
        if((x == 2 || x == -2) && (y == 1 || y == -1))
            return true;
        if((x == 1 || x == -1) && (y == 2 || y == -2))
            return true;
        return false;
    }
    public String getSymbol(){
        return "H";
    }
}
