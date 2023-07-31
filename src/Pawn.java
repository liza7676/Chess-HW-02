public class Pawn extends ChessPiece{//peshka
    public Pawn(String color) {
        super(color);
    }
    public String getColor(){
        return color;
    }
    public String getSymbol(){
        return "P";
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (toLine < 0 || toColumn < 0 || toLine > 7 || toColumn > 7)
            return false;
        if(chessBoard.board[toLine][toColumn]!= null) {
            if ( chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())){
                return false;
            }
        }
        int x;
        int y = column - toColumn;
        if (getColor().equals("White"))
            x = line - toLine;
        else
            x = toLine - line;
        if (column != toColumn) {
            if(chessBoard.board[toLine][toColumn]== null){
                return false;
            }
            if((y == 1 || y == -1) || x == 1)
                return true;
            else
                return false;
        }
        if(this.color.equals("White")){
            if (x == -1){
                if (chessBoard.board[toLine][toColumn] == null)
                    return true;
            }
            if ((x == -2) && line == 1) {
                if ((chessBoard.board[toLine][toColumn] == null) && (chessBoard.board[toLine - 1][toColumn] == null))
                    return true;
            }
        } else {
            if (x == -1) {
                if (chessBoard.board[toLine][toColumn] == null)
                    return true;
            }
            if (x == -2 && line == 6){
                if ((chessBoard.board[toLine][toColumn] == null) && (chessBoard.board[toLine + 1][toColumn] == null))
                    return true;
            }
        }
        return false;
    }
}
