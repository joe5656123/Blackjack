import java.util.Collections;
public class Deck {
    private java.util.ArrayList<Card> _deck;
    
    public Deck () {
        this.generateNewDeck();
    }
    
    public final void generateNewDeck() {
        this._deck = new java.util.ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            this._deck.add(new Card(i));
        }
        Collections.shuffle(this._deck);
    }
    
    public Card draw() {
        if (!this._deck.isEmpty()) {
            return this._deck.remove(0);
        } else {
            this.generateNewDeck();
            return this.draw();
        }
    }
    
    // Getters and Setters
    public java.util.ArrayList<Card> getDeck() {
        return this._deck;
    }
    
}
