public class Die {
    //instance variables
    private int sides;

    //constructor sets value of "sides"
    public Die() {
        sides = 6;
    }

    //returns a random int between 1 and
    //the number of sides on the Die (6 in this game)
    public int roll() {
        int num = (int)(Math.random()*sides) + 1;
        return num;
    }

    //passes "int num" which is the number rolled on the die
    //returns the ChanceCard that corresponds to the number rolled
    public String chanceCard(int num) {
        String[] cards = {"Automatic loss", "Get out of Jail for free", "Chance to roll dice again", "Automatic loss", "Get out of Jail for free", "Chance to roll dice again"};

        return cards[num-1];
    }

    //method deals with the result of the card picked
    //returns whether user has won, lost, or can roll again
    public static int cardResult(int num) {
        //choices 1,4 in the card array are "Automatic loss" cards
        //returns 1 which represents a loss
        if (num == 1 || num == 4){
            System.out.println("\nYou Lost....");
            return 1;
        }
        //choices 2, 5 in the card array are "Get out of Jail for free" cards
        //returns 2 which represents a win
        else if (num == 2 || num == 5){
            System.out.println("\nYOU WON!!!");
            return 2;
        }
        //3 and 6 (remaining nums) means player has a chance to roll again
        System.out.println("\nYou have the chance to roll again");
        return 3;
    }
}
