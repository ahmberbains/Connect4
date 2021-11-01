public class Coin {

    //Our game board will be made up of coins
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";

    boolean isPlayer;

    // constructor
    public Coin(boolean player){
        isPlayer = player;
    } // constructor 1

    String getCoinString(){
        if(isPlayer)
            return ANSI_BLUE + " 0 " + ANSI_RESET;
        return ANSI_RED + " 0 " + ANSI_RESET;
    }

} //public class Coin
