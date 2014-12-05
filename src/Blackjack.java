import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Blackjack extends JFrame{
    private final Deck _deck;
    private Player _player;
    
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
        this._deck = new Deck();

        Card d1Fake = this._deck.draw();
        Card d1 = new Card(d1Fake.getCardNumber(), true, true);
        Card d2Fake = this._deck.draw();
        Card d2 = new Card(d2Fake.getCardNumber(), false, true);
        
        Card c1 = this._deck.draw();
        Card c2Fake = this._deck.draw();
        Card c2 = new Card(c2Fake.getCardNumber(), true, false);
        
        // Dealer JPanel
        JPanel dealer = new JPanel();
        dealer.setLayout(new FlowLayout());
        dealer.setBackground(new Color(0, 150, 0));
        dealer.add(d2);
        dealer.add(d1);
        
        // Player JPanel With Buttons
        _player = new Player(this._deck);
        _player.addCard(c2);
        _player.addCard(c1);
        
        // How to add to the middle v
        // player.add(new Card(), null, 3);

        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 150, 0));
        this.add(_player, BorderLayout.SOUTH);
        this.add(dealer, BorderLayout.NORTH);
        
        System.out.println("Denomination: " + c1.getDenomination());
        System.out.println("Suit: " + c1.getSuit());
        System.out.println("Denomination: " + c2.getDenomination());
        System.out.println("Suit: " + c2.getSuit());
    }
}
