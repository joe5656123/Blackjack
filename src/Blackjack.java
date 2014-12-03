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
        Card d1Fake = new Card();
        Card d1 = new Card(d1Fake.getCardNumber(), true, true);
        Card d2Fake = new Card();
        Card d2 = new Card(d2Fake.getCardNumber(), false, true);
        
        Card c1 = new Card();
        Card c2Fake = new Card();
        Card c2 = new Card(c2Fake.getCardNumber(), true, false);
        
        setLayout(new FlowLayout());
        /*Container contentPane = new Container();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        contentPane.add(new JLabel("Label: "));
        contentPane.add(new JTextField("Text field", 15));*/
        
        add(d2);
        add(d1);
        
        //setLayout(new FlowLayout());
        
        add(c2);
        add(c1);
        
        add(new JButton("HIT"));
        //System.out.println("Denomination: " + c1.getDenomination());
        //System.out.println("Suit: " + c1.getSuit());
        //System.out.println("Denomination: " + c2.getDenomination());
        //System.out.println("Suit: " + c2.getSuit());
    }
}
