public class Player {
   private int HP;
   
   //Constructor
   public Player(){
      HP = 100;
   }   
   
   //Overrider Constructor: non default health
   public Player(int HP){
      this.HP = HP;
   }
   public int getHP(){
      return HP;
   }
   
   public void changeHP(int effect){
      HP += effect;
   }
   
}