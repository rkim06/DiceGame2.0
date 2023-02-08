import java.util.Scanner;

public class DiceGame {
    //instance variables
    private int counter;
    private Player p1;
    private Player p2;

    //prints the instructions of the game (and welcome)
    public void instructions() {
        System.out.println("WELCOME TO JAIL in MONOPOLY");

        System.out.println("You have two tries to get out of jail in one round. "+
                "The first time will be a dice roll and from there "+
                "you will have a choice between rolling two dice to"+
                " try your luck at getting a double or one "+
                "die to choose a card./n/n"+
                " This is a best out of three game. You can lose individual"+
                " rounds but win the overall game.\nGood luck~");
        System.out.println();
    }

    //iterates through three rounds per game
    //compares and then prints who won the round
    public void gameRounds(){
        for (int i = 0; i<3; i++){
            //prints round number
            System.out.println("ROUND "+(i+1));

            //creates player 1's turn
            Round rnd1 = new Round(p1);
            System.out.println("Player 1's turn:");
            rnd1.playGame();
            System.out.println("\n");
            //creates player 2's turn
            Round rnd2 = new Round(p2);
            System.out.println("Player 2's turn:");
            rnd2.playGame();

            int winner = p1.compare(p2);
            if(winner == 1){
                System.out.println(p1.getName()+" won the round!!!\n\n");
            }
            else if(winner == 2){
                System.out.println(p2.getName()+" won the round!!!\n\n");
            }
            else if(winner == 0){
                System.out.println("Nobody won the round!!!\n\n");
            }
        }
    }

    //prints the winner of the final champion
    public void printChampion(){
        int playerOneTotal = p1.getTotalWins();
        int playerTwoTotal = p2.getTotalWins();

        //prints the final points of each player
        System.out.println(p1.getName()+" got "+p1.getTotalWins()+" total points");
        System.out.println(p2.getName()+" got "+p2.getTotalWins()+" total points");
        System.out.println("therefore....");

        //compares the wins of player1 and player2
        if(playerOneTotal > playerTwoTotal){
            System.out.println(p1.getName()+" IS THE FINAL CHAMPION");
        }
        else if(playerOneTotal < playerTwoTotal){
            System.out.println(p2.getName()+" IS THE FINAL CHAMPION");
        }
        else{
            System.out.println("ITS A TIE");
        }
    }

    //plays the game
    //creates two players
    public void playGame(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter name of player 1: ");
        String player1name = s.nextLine();
        System.out.print("Enter name of player 2: ");
        String player2name = s.nextLine();
        System.out.println();

        p1 = new Player(player1name);
        p2 = new Player(player2name);

        instructions();
        gameRounds();
        printChampion();
    }

    //main method makes a game
    public static void main(String[] args) {
        DiceGame dg = new DiceGame();
        dg.playGame();
    }

}
