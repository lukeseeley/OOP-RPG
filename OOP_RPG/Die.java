//***********************************************
// Die.java 
//Represents one die 1 to number of faces
//***********************************************

import java.util.Random;

public class Die{
   
   private final int MIN_SIDES = 4;
   private static Random generator = new Random();
   private int value;   // Current value of the die
   private int sides;   // Number of sides of the die
   
   //Constructor: six sided die.
   public Die(){
      value = 1;
      sides = 6;
   }
   //Overloaded Constructor: Different sided die
   public Die(int sides){
      if(sides >= MIN_SIDES){
         this.sides = sides;
      }
      else{
         this.sides = MIN_SIDES;
      }
      value = 1;
   }
   
   //Roll Method: rolls and returns the dice value
   public int roll(){
      value = generator.nextInt(sides) + 1;
      return value;
   }
   
   // Returns the current die value
   public int getValue(){
      return value;
   }
   
   //toString overrides Objec.toString
   public String toString(){
      return Integer.toString(value);
   }
}