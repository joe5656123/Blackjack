import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Blackjack extends JFrame{
    public static void main(String[] args) {
        Blackjack frame = new Blackjack();
        frame.setSize(600, 600);
        frame.setTitle("Black Jack");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public Blackjack(){
        Card c = new Card();
        setLayout(new FlowLayout());
        
        add(c);
        System.out.println("Denomination: " + c.getDenomination());
        System.out.println("Suit: " + c.getSuit());
    }
}
