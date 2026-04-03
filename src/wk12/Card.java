class Card{
    private String suit, rank;
    private int value;
    private boolean used;
    
    public String getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
    public int getValue(){
        return value;
    }
    public void setSuit(String suit){
        this.suit = suit;
    }
    public void setRank(String rank){
        this.rank = rank;
    }
    public void setValue(int value){
        this.value = value;
    }
    public boolean isUsed(){
        return used;
    }
    public void setAsUsed(){
        used = true;
    }
    public Card(String suit, String rank, int value){
        setSuit(suit);
        setRank(rank);
        setValue(value);
    }
    
    public String toString(){
        return "Suit: " + suit+ "Rank: " + rank+ 
            "Value: " + value;
    }

}
