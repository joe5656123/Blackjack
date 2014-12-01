import javax.swing.*;

public class Card extends JButton{ // card Object
    private Suit _suit; // spade, club, heart, or diamond
    private Denomination _denomination; // a, 1, 2, 3, 4, 5, 6, 7, 8, 9, j, q, or k
    private int _cardNumber; // 1 - 52 (not including jokers)
    public JButton iButton;
    
    public Card() { 
        this(new java.util.Random().nextInt(52));
    }

    public Card(int cardNumber) {
        // Set Card Number
        this._cardNumber = cardNumber;
        
        // Set Suit
        this._suit = Suit.getSuitFromInt(cardNumber);
        
        // Set Denomination
        this._denomination = Denomination.getDenomFromInt(cardNumber);
        
        // Configure Image
        ImageIcon i = null;
        
        try {
            i = new ImageIcon("images/" + cardNumber + ".png");
        } catch (Exception e) { 
            System.out.println(e);
        }
        
        //JButton iButton;
        iButton = new JButton("i");
        iButton.setSize(100, 75);
        iButton.setIcon(i);
        //iButton.addActionListener(new ProcessorNextStepListener(this));
        
        //add(iButton);
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
