public class Player {
    //name of player in this class
    private String name;
    //the total number of wins per plays
    private int totalWins;
    //win or loss for a given round
    private boolean hasWon;

    public Player(String name){
        this.name = name;
        hasWon = false;
    }

    //gets the name of the player
    public String getName(){
        return name;
    }

    //gets if the player has won the round or not
    public boolean getHasWon(){
        return hasWon;
    }

    //gets the number of total wins/points for a given player
    public int getTotalWins(){
        return totalWins;
    }

    //increases totalWins if the player wins a round
    public void increaseWins(){
        totalWins++;
    }

    //sets hasWon to true
    public void incrementWins(){
        hasWon = true;
    }

    //determines who has won the whole game (who is the champion)
    public int compare(Player p){
        //the player in this class has won
        if(this.hasWon == true && p.getHasWon() == false){
            increaseWins();
            return 1;
        }
        //the player passed in has won
        else if(this.hasWon == false && p.getHasWon() == true){
            p.increaseWins();
            return 2;
        }
        //case of tie
        return 0;
    }
}
