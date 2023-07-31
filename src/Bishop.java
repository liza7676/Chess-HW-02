public class Bishop extends ChessPiece{ // slon
    public Bishop(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }
    public String getSymbol(){
        return "B";
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
        int y = column - toColumn;
        if(x < 0)
            x *= -1;
        if(y < 0)
            y *= -1;
        if (x != y || x == 0)
            return false;

        x = line - toLine;
        y = column - toColumn;
        int j = column;
        if(x > 0 && y > 0){
            for (int i = line-1; i > toLine; i--){
                j--;
                if (chessBoard.board[i][j] != null)
                    return false;
            }
        } else if (x < 0 && y < 0){
            for (int i = line+1; i < toLine; i++){
                j++;
                if (chessBoard.board[i][j] != null)
                    return false;
            }
        } else if (x > 0 && y < 0){
            for (int i = line-1; i > toLine; i--){
                j++;
                if (chessBoard.board[i][j] != null)
                    return false;
            }
        } else {
            for (int i = line+1; i < toLine; i++){
                j--;
                if (chessBoard.board[i][j] != null)
                    return false;
            }
        }

        return true;
    }
}
