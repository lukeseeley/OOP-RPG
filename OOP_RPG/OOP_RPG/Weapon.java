import java.util.Random;

public class Weapon {
   private static Random generator = new Random();
   private int attack;
   private int damageDice;
   private int damageDie;
   private int damage;
   
   private static Die d4 = new Die(4);
   private static Die d6 = new Die();
   private static Die d8 = new Die(8);
   private static Die d10 = new Die(10);
   
   //Constructor
   public Weapon(int attack, int damageDice, int damageDie){
      this.attack = attack;
      this.damageDice = damageDice;
      this.damageDie = damageDie;
   }
   
   public int getAttack(){
      return attack;
   }
   
   public int attack() {
      damage = 0;
      for(int i = 0; i <= damageDice; i++){
         if(damageDie == 4){
            damage += d4.roll();
         }
         else if(damageDie == 6){
            damage += d6.roll();
         }
         else if(damageDie == 8){
            damage += d8.roll();
         }
         else if(damageDie == 10){
            damage += d10.roll();
         }
      }
      return damage;
   }
}