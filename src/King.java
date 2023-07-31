public class King extends ChessPiece{
    public King(String color){
        super(color);
    }

    public String getColor(){
        return color;
    }
    public String getSymbol(){
        return "K";
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (toLine < 0 || toColumn < 0 || toLine > 7 || toColumn > 7)
            return false;
        if(chessBoard.board[toLine][toColumn]!= null) {
            if ( chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())){
                return false;
            }
        }
        if (isUnderAttack(chessBoard, toLine, toColumn ))
            return false;
        int x = line - toLine;
        int y = column - toColumn;
        if(x < 0)
            x *= -1;
        if(y < 0)
            y *= -1;
        if(x == 1 || y == 1)
            return true;
        return false;
    }
    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (board.board[i][j] != null) {
                    if (board.board[i][j] != this ) {
                        if (!board.board[i][j].getColor().equals(getColor())) {
                            if (!(board.board[i][j].getSymbol().equals("K") && board.nowPlayerColor().equals(board.board[i][j].getColor()))){
                                if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}