class Dealer extends Participant implements Rules{
  public final int DEALER_STAY = 17;

  public Dealer(String name){
    super(name);
    }
 
    public boolean canPlay(){
        return getHandTotal() < DEALER_STAY;
    }

}
