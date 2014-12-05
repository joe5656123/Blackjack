public enum Denomination { // Denomination enum
    Ace("Ace", 11),
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10),
    Jack("Jack", 10),
    Queen("Queen", 10),
    King("King", 10);
    
    private final String _id;
    private final int _value;
    
    private Denomination(String id, int value) {
        this._id = id;
        this._value = value;
    }
    
    public static Denomination getDenomFromInt(int i) {
        return Denomination.values()[(i - 1) % 13]; // divides the deck into 4 suits
    }
    
    @Override
    public String toString() {
        return this._id;
    }
    public float getValue() {
        return this._value;
    }
}
