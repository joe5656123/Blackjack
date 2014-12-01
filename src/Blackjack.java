import java.util.*;
import java.awt.*;
import java.awt.event.*;
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
        Card d1 = new Card();
        Card d2 = new Card();
        
        Card c1 = new Card();
        Card c2 = new Card();
        
        setLayout(new FlowLayout());
        
        add(d1);
        add(d2);
        
        add(c1);
        add(c2);
        //System.out.println("Denomination: " + c1.getDenomination());
        //System.out.println("Suit: " + c1.getSuit());
        //System.out.println("Denomination: " + c2.getDenomination());
        //System.out.println("Suit: " + c2.getSuit());
    }
}
