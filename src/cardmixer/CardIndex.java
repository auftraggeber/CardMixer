package cardmixer;

/**
 * Der CardIndex ist der Wert einer Karte. Jeder Wert hat zudem ein Symbol.
 * @author Jonas Langner
 * @version 1.0
 * @since Alpha
 */
public enum CardIndex {

    ACE_FIRST("A",1),
    ACE_LAST("A",14),
    ACE("A", new CardIndex[]{ACE_FIRST, ACE_LAST}),
    TWO("2",2),
    THREE("3",3),
    FOUR("4",4),
    FIVE("5",5),
    SIX("6",6),
    SEVEN("7",7),
    EIGHT("8",8),
    NINE("9",9),
    TEN("10",10),
    JACK("J",11),
    QUEEN("Q",12),
    KING("K",13);

    private String symbol;
    private int value;
    private CardIndex[] unites;

    private CardIndex(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    private CardIndex(String symbol, CardIndex ... couldBe) {
        this.symbol = symbol;
        unites = couldBe;
        value = -1;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public CardIndex[] getSubIndices() {
        return unites;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
