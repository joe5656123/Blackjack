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
        dealer.add(d2);
        dealer.add(d1);
        
        // Player JPanel
        JPanel player = new JPanel();
        player.setLayout(new FlowLayout());
        player.add(c2);
        player.add(c1);
        
        // Add Components
        setLayout(new BorderLayout());
        this.add(player, BorderLayout.SOUTH);
        this.add(dealer, BorderLayout.NORTH);
		
		// Add Buttons
        add(new JButton("HIT"));
    }
}
