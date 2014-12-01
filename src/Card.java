import java.awt.event.*;
import javax.swing.*;

public class Card extends JToggleButton{ // card Object
    private Suit _suit; // spade, club, heart, or diamond
    private Denomination _denomination; // a, 1, 2, 3, 4, 5, 6, 7, 8, 9, j, q, or k
    private int _cardNumber; // 1 - 52 (not including jokers)
    private JToggleButton iButton; // makes the card a button
    private ImageIcon i; // makes the button look like a card
    
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
        //ImageIcon i = new ImageIcon("images/" + cardNumber + ".png");

        try {
            i = new ImageIcon("images/" + cardNumber + ".png");
        } catch (Exception e) { 
            System.out.println(e);
        }
        
        //this.setSize(100, 75);
        this.setIcon(i);
        iButton = new JToggleButton(i, true);
        //this.setSelected(true);
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        
        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent ie){
                Card c = new Card();
                if(c.iButton.isSelected()){
                    c.i = new ImageIcon("images/" + c._cardNumber + ".png");
                    c.iButton.setIcon(c.i);
                    c.iButton.setSelected(true);
                    System.out.println("button is right side up");
                    //c.iButton = new JToggleButton(i, false);
                    repaint();
                } else {
                    c.i = new ImageIcon("images/b1fv.png");
                    c.iButton.setIcon(c.i);
                    c.iButton.setSelected(false );
                    System.out.println("button is up side down");
                    //c.iButton = new JToggleButton(i, true);
                    repaint();
                }
            }
        });
        
        /*JToggleButton jtb = new JToggleButton("Press Me");
        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ev) {
                Card c = new Card();
                if (ev.getStateChange() == ItemEvent.SELECTED){
                    ImageIcon i = new ImageIcon("images/" + c._cardNumber + ".png");//♥
                    iButton.setIcon(i);
                    System.out.println("button is right side up");
                    repaint();
                } else if (ev.getStateChange() == ItemEvent.DESELECTED){
                    ImageIcon i = new ImageIcon("images/b2fv.png");
                    iButton.setIcon(i);
                    System.out.println("button is up side down");
                    repaint();
                }
            }
        });*/
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
