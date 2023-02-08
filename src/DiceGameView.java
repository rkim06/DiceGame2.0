import java.awt.*;
import javax.swing.*;

public class DiceGameView extends JFrame{
    private Image background;
    private Image[] dieImgs;
    private Image[] rndResults;
    private Image[] winOrLoss;

    private int windowWidth;
    private int windowHeight;

    public DiceGameView(int width, int height, Image background, Image[] dieImgs, Image[] rndResults, Image[] winOrLoss) {
        // Initialize the image reference so it shares the image with the Back-End
        this.background = background;
        //need to use width and height to
        windowWidth = width;
        windowHeight = height;

        //fills in all the die images into the array
        for(int i = 0; i<6; i++){
            dieImgs[i] = new ImageIcon("Resources/"+(i+1)+".png").getImage();
        }

        //fills in all round result images into "rndResults" array
        rndResults[0] = new ImageIcon("Resources/autoLoss.png").getImage();
        rndResults[1] = new ImageIcon("Resources/jailCard.png").getImage();
        rndResults[2] = new ImageIcon("Resources/rollAgain.png").getImage();

        //fills in winOrLoss array
        winOrLoss[0] = new ImageIcon("Resources/win.png").getImage();
        winOrLoss[1] = new ImageIcon("Resources/loss.png").getImage();


        // Initialize the JFrame.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("DICE GAME");
        this.setSize(1000, 800);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        g.drawImage();
    }

}
