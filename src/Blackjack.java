import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Blackjack extends JFrame{
    public static void main(String[] args) {
        Blackjack frame = new Blackjack();
        frame.setSize(250, 250);
        frame.setTitle("Black Jack");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public Blackjack(){
        Card c = new Card();
        setLayout(new GridLayout(3, 3, 3, 3));
        
        add(new Card(1));
        //add(c.iButton);
    }
}