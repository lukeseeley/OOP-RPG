public class Enemy {
   private int HP;
   private int attack;
   private int damageDice;
   private int damageDie;
   private int damage;
   
   private static Die d4 = new Die(4);
   private static Die d6 = new Die();
   private static Die d8 = new Die(8);
   private static Die d20 = new Die(20);
   
   //Constructor: Default
   public Enemy(){
      HP = 100;
      attack = 0;
      damageDice = 2;
      damageDie = 4;
   }
   
   //Constructor: Build
   public Enemy(int HP, int attack, int damageDice,int damageDie){
      this.HP = HP;
      this.attack = attack;
      this.damageDice  = damageDice;
      this.damageDie = damageDie;
   }
   public boolean tryAttack(){
      int attempt;
      attempt = d20.roll() + this.attack;
      if(attempt >= 10){
         return true;
      }
      else {
         return false;
      }
   }
   
   public int damageAttack() {
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
      }
      return damage;
   }
   
   public int getHP() {
      return HP;
   }
   
   public void changeHP(int effect){
      HP += effect;
   }
}
