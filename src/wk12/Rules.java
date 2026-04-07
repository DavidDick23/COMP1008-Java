/*
Two Players playing against each other
    Player 1: regular player
    Player 2: Dealer
    
-diff between regular player and dealer: when dealer has sum of cards of 17, they must hold/stay at that value

-players cycle through a Deck of Cards
    a Deck has 52
-each card has a Suit and a Rank and a Value
- a Suit is one of values; Heart, Clubs, Diamonds, Spade

-player gets two Cards
    -has to decide to play or stay
        play: get a Card in Deck
        stay: don't
-dealer gets two Cards
    -has to decide to play or stay
        HOWEVER, must obey rule of 17 or more => STAY

*/
interface Rules{
    boolean canPlay();
}
