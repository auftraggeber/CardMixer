package cardmixer;

public class Card {

    private CardIndex cardIndex;
    private CardColor cardColor;

    public Card(CardIndex cardIndex, CardColor cardColor) {
        this.cardIndex = cardIndex;
        this.cardColor = cardColor;
    }

    public CardIndex getCardIndex() {
        return cardIndex;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    @Override
    public String toString() {
        return "| " + cardIndex.getSymbol() + " " + cardColor.toString() + " |";
    }
}
