import javax.swing.*;

public class Card extends JButton{ // card Object
    private String _suit; // spade, club, heart, or diamond
    private Denomination _denomination; // a, 1, 2, 3, 4, 5, 6, 7, 8, 9, j, q, or k
    private int _cardNumber; // 1 - 52 (not including jokers)
    
    public Card(){ } // creates an empty card object
    
    // creates a card object with a specific suit, denomination, and number
    /*
    public Card(String suit, String denomination, int cardNumber){
        this._suit = suit;
        this._denomination = denomination;
        this._cardNumber = cardNumber;
    }
    */
    
    public Card(int cardNumber) {
        // Set Card Number
        this._cardNumber = cardNumber;
        
        // Set Suit
        if (cardNumber <= 13) {
            this._suit = "spade";
        } else if (cardNumber <= 26) {
            this._suit = "club";
        } else if (cardNumber <= 39) {
            this._suit = "heart";
        } else {
            this._suit = "diamond";
        }
        
        // Set Denomination
        this._denomination = Denomination.getDenomFromInt(cardNumber);
    }
    
    public String getSuit(){ // gets the suit of the card
        return this._suit;
    }
    
    public void setSuit(String suit){ // sets the suit of the card
        this._suit = suit;
    }
    
    public String getDenomination(){ // gets the denomination of the card
        return this._denomination.toString();
    }
    
    /*
    public void setDenomination(String denomination){ // sets the denomination of the card
        this._denomination = denomination;
    }
    */
    
    public int getCardNumber(){ // gets the number of the card
        return this._cardNumber;
    }
    
    public void setCardNumber(int cardNumber){ // sets the number of the card
        this._cardNumber = cardNumber;
    }
}