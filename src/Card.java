
import javax.swing.*;

public class Card extends JToggleButton{ // card Object
    // Member Variables
    private Suit _suit; // spade, club, heart, or diamond
    private Denomination _denomination; // a, 1, 2, 3, 4, 5, 6, 7, 8, 9, j, q, or k
    private int _cardNumber; // 1 - 52 (not including jokers)
    private ImageIcon i; // makes the button look like a card
    
    // Constructors
    public Card() { // Creates a new random card (for testing purposes only)
        this(new java.util.Random().nextInt(52) + 1);
    }

    public Card(int cardNumber) {
        this(cardNumber, true);
    }
    
    public Card(int cardNumber, boolean showFace) {
        this(cardNumber, showFace, false);
    }
    
    public Card(int cardNumber, boolean showFace, boolean dealer) {
        // Set Card Number
        this._cardNumber = cardNumber;
        
        // Set Suit
        this._suit = Suit.getSuitFromInt(cardNumber);
        
        // Set Denomination
        this._denomination = Denomination.getDenomFromInt(cardNumber);
        
        // Configure Image
        i = new ImageIcon("images/b1fv.png");
        
        // Set JToggleButton Properties
        this.setIcon(i);
        this.setDisabledIcon(i);
        this.setSelected(showFace);
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        this.setSelectedIcon(new ImageIcon("images/" + cardNumber + ".png"));
        this.setEnabled(!dealer);
        
    }
    
    // Copy constructors
    public Card(Card c) {
        this(c.getCardNumber());
    }
    
    public Card(Card c, boolean flipped) {
        this(c.getCardNumber(), flipped);
    }
    
    public Card(Card c, boolean flipped, boolean dealer) {
        this(c.getCardNumber(), flipped, dealer);
    }
    
    // Methods
    public String getSuit(){ // gets the suit of the card
        return this._suit.toString();
    }
    
    public String getDenomination(){ // gets the denomination of the card
        return this._denomination.toString();
    }
    
    public int getCardNumber(){ // gets the number of the card
        return this._cardNumber;
    }
    
    public void setCardNumber(int cardNumber){ // sets the number of the card
        // Set Card Number
        this._cardNumber = cardNumber;
        
        // Set Suit
        this._suit = Suit.getSuitFromInt(cardNumber);
        
        // Set Denomination
        this._denomination = Denomination.getDenomFromInt(cardNumber);
    }
    
    public int getWorth() {
        return this._denomination.getValue();
    }
}
