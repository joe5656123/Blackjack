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
        // Instansiate Cards
        Card d1Fake = new Card();
        Card d1 = new Card(d1Fake.getCardNumber(), true, true);
        Card d2Fake = new Card();
        Card d2 = new Card(d2Fake.getCardNumber(), false, true);
        
        Card c1 = new Card();
        Card c2Fake = new Card();
        Card c2 = new Card(c2Fake.getCardNumber(), true, false);
        
        // Dealer JPanel
        JPanel dealer = new JPanel();
        dealer.setLayout(new FlowLayout());
        dealer.setBackground(new Color(0, 150, 0));
        dealer.add(d2);
        dealer.add(d1);
        
        // Player JPanel With Buttons
        JPanel player = new JPanel();
        player.setLayout(new FlowLayout());
        player.setBackground(new Color(0, 150, 0));
        player.add(new JButton("STAY"));
        player.add(c2);
        player.add(c1);
        player.add(new JButton("HIT"));
        
        // How to add to the middle v
        // player.add(new Card(), null, 3);

        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 150, 0));
        this.add(player, BorderLayout.SOUTH);
        this.add(dealer, BorderLayout.NORTH);
        
        System.out.println("Denomination: " + c1.getDenomination());
        System.out.println("Suit: " + c1.getSuit());
        System.out.println("Denomination: " + c2.getDenomination());
        System.out.println("Suit: " + c2.getSuit());
    }
}
