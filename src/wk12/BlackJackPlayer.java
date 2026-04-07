class BlackJackPlayer extends Participant implements Rules{
    public BlackJackPlayer(String name){
        super(name);
    }
    
    

    public boolean canPlay(){
        return getHandTotal() < BLACKJACK;
    }
}
