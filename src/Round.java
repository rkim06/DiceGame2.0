import java.util.Scanner;

public class Round {
    //Instance Variables
    private Scanner input;
    private Die d1;
    private Die d2;
    private Die d3;
    private Die d4;
    private Player p;

    //constructor that sets values of the Instance Variables
    public Round(Player p) {
        input = new Scanner(System.in);
        d1 = new Die();
        d2 = new Die();
        d3 = new Die();
        d4 = new Die();
        this.p = p;
    }

    //methods calls on other methods to play the round
    //per player
    public void playGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("Type anything to start: ");
        String useless = input.next();
        System.out.println();

        rollForDouble();
        partTwo();
    }

    //method for when player initially rolls for a double
    //either in the beginnning or by choice
    //
    public String rollForDouble() {
        int roll1 = d3.roll();
        int roll2 = d4.roll();

        //compares rolls of the two dice
        int comparison = compareDice(roll1,roll2);

        System.out.println("You rolled a "+roll1+" and a "+roll2);

        return "The rolls are not the same...\nYOU LOST";
    }

    //this method is for the second round and only runs
    //if the player fails to win/get a double
    public void partTwo() {
        System.out.println();
        System.out.println("You have the chance to roll again or pick a card. Enter 1 to roll again. Enter 2 to pick a card.");
        int decision = input.nextInt();

        //if player chooses to roll again (1)
        //rollForDouble() is called to roll again
        if(decision == 1) {
            System.out.println();
            System.out.println(rollForDouble());
        }
        //if player chooses to pick a card
        //a die is rolled to be passed into cardResult()
        //and both the roll and corresponding card are printed
        else if(decision == 2) {
            System.out.println("Roll a dice to choose a card.");
            int roll = d1.roll();
            System.out.println("You rolled a "+roll+" which is \""+d1.chanceCard(roll)+"\"");
            int f = d1.cardResult(roll);
            //if the cardResult
            if(f == 2){
                p.incrementWins();
            }
            System.out.println(f);
            if(roll == 1 || roll == 4 || roll == 2 || roll == 5) {
                return;
            }
            else if(roll == 3 || roll == 6) {
                System.out.println(rollForDouble());
            }
        }
    }

    //this method checks for if the die rolled
    //make a "double" (are the same number)
    public int compareDice(int die1, int die2) {
        //returns 0 if the numbers are same
        //1 if different
        if(die1 == die2){
            return 0;
        }
        return 1;
    }
}
