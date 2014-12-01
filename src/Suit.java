public enum Suit {
    Spade("Spade"),
    Heart("Heart"),
    Diamond("Diamond"),
    Club("Club");
    
    private final String _id;
    
    private Suit(String id) {
        this._id = id;
    }
    
    public static Suit getSuitFromInt(int i) {
        if (i <= 13) {
            return Suit.Spade;
        } else if (i <= 26) {
            return Suit.Heart;
        } else if (i <= 39) {
            return Suit.Diamond;
        } else {
            return Suit.Club;
        }
    }
    
    @Override
    public String toString() {
        return this._id;
    }
}
