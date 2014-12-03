import java.awt.event.*;
import javax.swing.*;

public class Card extends JToggleButton{ // card Object
    private Suit _suit; // spade, club, heart, or diamond
    private Denomination _denomination; // a, 1, 2, 3, 4, 5, 6, 7, 8, 9, j, q, or k
    private int _cardNumber; // 1 - 52 (not including jokers)
    private ImageIcon i; // makes the button look like a card
    
    public Card() { 
        this(new java.util.Random().nextInt(53) - 1);
    }

    public Card(int cardNumber) {
        // Set Card Number
        this._cardNumber = cardNumber;
        
        // Set Suit
        this._suit = Suit.getSuitFromInt(cardNumber);
        
        // Set Denomination
        this._denomination = Denomination.getDenomFromInt(cardNumber);
        
        // Configure Image
        try {
            i = new ImageIcon("images/b1fv.png");
        } catch (Exception e) { 
            System.out.println(e);
        }
        
        //this.setSize(100, 75);
        this.setIcon(i);
        this.setSelected(true);
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        this.setSelectedIcon(new ImageIcon("images/" + cardNumber + ".png"));
    }
    
    public Card(int cardNumber, boolean flipped, boolean dealer) {
        // Set Card Number
        this._cardNumber = cardNumber;
        
        // Set Suit
        this._suit = Suit.getSuitFromInt(cardNumber);
        
        // Set Denomination
        this._denomination = Denomination.getDenomFromInt(cardNumber);
        
        // Configure Image
        if (flipped == true){
            try {
                i = new ImageIcon("images/" + cardNumber + ".png");
            } catch (Exception e) { 
                System.out.println(e);
            }
        } else {
            try {
                i = new ImageIcon("images/b1fv.png");
            } catch (Exception e) { 
                System.out.println(e);
            }
        }
        
        //this.setSize(100, 75);
        this.setIcon(i);
        this.setSelected(true);
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        if (flipped == true){
            if (dealer == false)
                this.setSelectedIcon(new ImageIcon("images/b1fv.png"));
        } else {
            if (dealer == false)
                this.setSelectedIcon(new ImageIcon("images/" + cardNumber + ".png"));
        }
    }
    
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
}
