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
        
        //The next block of lines are for testing purposes
        //TODO:  Add a card grom the deck instead of created a random card.
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
        dealer.add(d2); // Dealers unflipped card
        dealer.add(d1); // Dealers flipped card
        
        // Player JPanel With Buttons
        _player = new Player(this._deck); // Ads the player panel
        _player.addCard(c2); // Players flipped card
        _player.addCard(c1); // Players unflipped card

        
        // Add Components
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0, 150, 0)); // Green background
        this.add(_player, BorderLayout.SOUTH); // Adds the player cards
        this.add(dealer, BorderLayout.NORTH); // Adds the dealers cards
        
        System.out.println("Denomination: " + c1.getDenomination()); // The correct cards denomination
        System.out.println("Suit: " + c1.getSuit()); // The correct cards suit
        System.out.println("Denomination: " + c2.getDenomination()); // The correct cards denomination
        System.out.println("Suit: " + c2.getSuit()); // The correct cards suit
    }
}
