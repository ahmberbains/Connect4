public class Game {

    //This class will handle all of our game logic.
    int board_columns = 8;
    int board_rows = 5;
    Coin[][] board = new Coin [board_columns][board_rows]; // 8 columns, 5 rows (like x, y)
    boolean victoryAchieved = false;
    // Constructor - initializes your variables
    public Game(){
        displayBoard();
        while(true) {
            playerMove();
            if (victoryAchieved){
                displayBoard();
                System.out.println("The player won!");
                return;
            }
            aiMove();
            if (victoryAchieved){
                displayBoard();
                System.out.println("The AI won!");
                return;
            }
            displayBoard();
            if(boardIsFull()){
                System.out.println("The board is full! This game results in a draw.");
                return;
            }
        }
    } // constructor 1

    //Game methods

    void checkForVictory(int x, int y){
        checkNeighbour(1, x, y, 0, 1); // downward direction
        checkNeighbour(1, x, y, 0, -1); // upward
        checkNeighbour(1, x, y, -1, 0); // leftward
        checkNeighbour(1, x, y, -1, 0); // rightward

        checkNeighbour(1, x, y, -1, 1); // down left diagonal
        checkNeighbour(1, x, y, 1, 1); // down left diagonal
        checkNeighbour(1, x, y, -1, -1); // down left diagonal
        checkNeighbour(1, x, y, 1, -1); // down left diagonal


    } //checkForVictory

    void checkNeighbour(int nInRow, int posX, int posY, int dirX, int dirY){
        Coin coin = board[posX][posY];
        posX += dirX;
        posY += dirY;

        if (posX < 0 || posX >= board_columns || posY < 0 || posY >= board_rows)
            return;
/*
        if (posX < 0)
            return;

        if (posX >= board_columns)
            return;

        if (posY < 0)
            return;

        if (posY >= board_rows)
            return;
*/
        Coin neighbour = board[posX][posY];

        if (neighbour == null){
            return; // return marks the end of a function (it wont continue)
        }

        if (coin.isPlayer != neighbour.isPlayer){
            return;
        }

        nInRow++;
        if(nInRow == 3){
            checkNeighbour(nInRow, posX, posY, -dirX*3, -dirY*3);
        }
        if(nInRow == 4){
            victoryAchieved = true;
            return;
        }

        checkNeighbour(nInRow, posX, posY, dirX, dirY);

    } // checkNeighbour

    boolean boardIsFull(){
        for (int row = 0; row < board_rows; row++) {
            for (int col = 0; col < board_columns; col++) {
                if (board[col][row] == null) {
                    return false;
                }
            }
        }
        return true;
    }


    void aiMove(){
        boolean columnPlayable;
        do{
            int aiColumn = Main.rand.nextInt(board_columns);
            columnPlayable = enterCoin(aiColumn, false);
        } while(!columnPlayable);

    }

    void playerMove(){
        try{
            System.out.print("\nEnter a column number: ");
            String userInput = Main.input.next();
            int playerColumn = Integer.parseInt(userInput); //converts string to int
            boolean columnPlayable = enterCoin(playerColumn, true);
            if (!columnPlayable){
                System.out.println("Column" + playerColumn + " is full!");
                playerMove();
            }
            //System.out.println("\n");
        } catch(Exception e) {
            playerMove();
        }
    }

    boolean enterCoin(int column, boolean isPlayer){ // places coin in lowest possible row
        Coin c = new Coin(isPlayer);
        for(int row = board_rows - 1; row >= 0; row--){
            if(board[column][row] == null){
                board[column][row] = c;
                checkForVictory(column, row);
                return true;
            }
        }
        return false;
    }

    void displayBoard(){
        // print the column numbers so the user can easily see them
        for (int col=0; col < board.length; col++){
            System.out.print(" " + col + " ");

        }// loop over columns
        System.out.println();
        //print the board
        for(int row=0; row < board[0].length; row++){
            for (int col=0; col < board.length; col++){
                Coin c = board[col][row];
                if(c == null)
                    System.out.print(" 0 ");
                else
                    System.out.print(c.getCoinString());

            }// loop over columns
            System.out.println();
        } // loop over rows
    }
    
} //public class Game
