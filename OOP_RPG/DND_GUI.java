//Window import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;


class DND_GUI{
   //weapons list
     //Random Generator
   private static Random generator = new Random();
   //Creates windows components
   private JFrame window = new JFrame("DND Combat");  
   private JLabel lblYou = new JLabel("You:  "); 
   private JLabel lblComputer = new JLabel("Goblin:   ");
   private JLabel lblWeapon = new JLabel("Weapon:   "); 
  // private JComboBox cmbWeaponList;
   private JLabel lblResults = new JLabel("Results");
   private JLabel lblResults2 = new JLabel(" ");
   private JButton btnPlay = new JButton("Fight");
   private JProgressBar pbYou = new JProgressBar();
   private JProgressBar pbComputer = new JProgressBar();
   
   private static Weapon dagger = new Weapon(7,2,4);
   private static Weapon shortSword = new Weapon(5,2,6);
   private static Weapon longSword = new Weapon(3,2,8);
   private static Weapon greatSword = new Weapon(1,2,10);
   private static Die d20 = new Die(20);
   public int selectWeapon;
   //Panel for windows compoenents
 
   private JPanel content = new JPanel(new GridLayout(5, 2));
   //Declare and Instantiate Players
   private Player player = new Player();
   private Enemy goblin = new Enemy();
   

   public DND_GUI(){
      //String[] weaponList = {"Dagger","Short Sword","Long Sword","Great Sword"};
      pbYou.setMinimum(0);
      pbYou.setMaximum(player.getHP());
      pbYou.setValue(player.getHP());
      pbComputer.setMinimum(0);
      pbComputer.setMaximum(goblin.getHP());
      pbComputer.setValue(goblin.getHP());

      //Ends the program when the window is closed
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //JComboBox cmbWeaponList= new JComboBox(weaponList);

      //Add the component to a panel  
      //content.add(lblWeapon);
      //content.add(cmbWeaponList);
      content.add(lblYou);
      content.add(pbYou);
      content.add(lblComputer);
      content.add(pbComputer);
      content.add(lblResults);
      content.add(btnPlay);
      content.add(lblResults2);
      
      //Add panel to window
      window.add(content);
      
      //Set the size of the window
      window.setSize(800, 250);
      //Show the window
      window.setVisible(true);
      
      btnPlay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            //Player Turn
            if(player.getHP() > 0){
               if(selectWeapon == 0){
                  if(d20.roll() + dagger.getAttack() >= 10){
                     int damage = dagger.attack();
                     goblin.changeHP(-1 * damage);
                     pbComputer.setValue(goblin.getHP());
                     lblResults.setText("You used your dagger and hit for " + damage + " damage!");
                  }
                  else {
                     lblResults.setText("You missed!");
                  }
               }
            }
            else {
               lblResults.setText("You are dead.");
            }
            
            //Enemy Turn
            if (goblin.getHP() > 0){
               if(goblin.tryAttack() == true){
                  int Edamage = goblin.damageAttack();
                  player.changeHP(-1 * Edamage);
                  pbYou.setValue(player.getHP());
                  lblResults2.setText("They slashed you for " + Edamage + " damage!");
               }
               else {
                  lblResults2.setText("They missed you!");
               }
            }
            else {
               lblResults2.setText("They are dead");
            }
            
           
         }
      });



   }
   
   //Starts here
   public static void main(String [] args){
      //Runs the window creation code
      new DND_GUI();
   }


}