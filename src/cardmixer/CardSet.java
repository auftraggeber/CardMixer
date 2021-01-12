package cardmixer;

/**
 * Ein CardSet bestimmt, welche Karten zur Verfügung stehen.
 * @author Jonas Langner
 * @version 1.0
 * @since Alpha
 */
public class CardSet {

    private Card[] cards;

    /**
     * Gibt an, wie oft das Set durchmischt werden soll.
     */
    private static final int MIX_PARAMETER = 2;

    /**
     * Erstellt das CardSet.
     * @param cards Gibt an, welche Karten es gibt.
     */
    public CardSet(Card ... cards) {
        this.cards = cards;
    }

    /**
     * Erstellt das Card.
     * @param indices Welche Karten gibt es pro Farbe?
     */
    public CardSet(CardIndex ... indices) {
        /* Länge des Arrays bestimmen */
        this.cards = new Card[indices.length * CardColor.values().length];

        /* Schleifenzähler */
        int i = 0;

        /* Jede Karte jeder Farbe erstellen */
        for (CardIndex index : indices) {

            for (CardColor color : CardColor.values()) {

                this.cards[i] = new Card(index, color);

                /* inkrementieren */
                i++;
            }
        }
    }

    public Card[] getCards() {
        return cards;
    }

    /**
     * Gibt eine spezifische Karte aus.
     * @param index Der Index im Array.
     * @return Die spezifische Karte.
     */
    public Card getCard(int index) {
        /* ausgabe mit absicherung */
        return this.cards[index % this.cards.length];
    }

    /**
     * Ermittelt eine Zufällige Karte.
     * @return Die ausgewählte Karte.
     */
    public Card getRandomCard() {
        /* zufälligen Wert ermitteln */
        int randomIndex = (int) (Math.random() * this.cards.length);

        /* sichere ausgabe */
        return getCard(randomIndex);
    }

    /**
     * "Mischt" die Karten.<br/>
     * Neue Reihenfolge kann über Getter ausgelesen werden.
     */
    public void mix() {
        /* 2 mal durch Reihenfolge gehen */
        for (int i = 0; i < MIX_PARAMETER; i++) {

            /* durch set durchgehen */
            for (int j = 0; j < this.cards.length; j++) {
                /* Karte zwischenspeichern */
                Card temp = this.cards[j];

                /* karten austauschen -> andere Karte per zufall ermitteln */
                int randomIndex = (int) (Math.random() * this.cards.length);

                /* tauschen */
                this.cards[j] = this.cards[randomIndex];
                this.cards[randomIndex] = temp;
            }

        }
    }

    @Override
    protected CardSet clone() {
        return new CardSet(cards);
    }

    /* Default-CardSets */
    public static final CardSet POKER_SET = new CardSet(new CardIndex[]{
            CardIndex.ACE,
            CardIndex.TWO,
            CardIndex.THREE,
            CardIndex.FOUR,
            CardIndex.FIVE,
            CardIndex.SIX,
            CardIndex.SEVEN,
            CardIndex.EIGHT,
            CardIndex.NINE,
            CardIndex.TEN,
            CardIndex.JACK,
            CardIndex.QUEEN,
            CardIndex.KING
    });

}
