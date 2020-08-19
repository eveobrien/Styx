
package newpackage;

import package2.monster_Witch;
import package2.superMonster;
import package2.weapon_Dagger;
import package2.weapon_ShortSword;


public class Story {
    Game game;
    UI ui;
    visabilityManagement vm;
    Player player = new Player();
    superMonster monster;
    
    int silverRing;
    
    public Story(Game g, UI userInterface, visabilityManagement vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }
    
    public void defaultSetup(){
        player.hp = 10;
        ui.hpLabelNumber.setText("" + player.hp);
        
        player.currentWeapon = new weapon_Dagger();
        ui.weaponLabelName.setText(player.currentWeapon.name);
        
        silverRing = 0;
    }
    
    public void selectPosition(String nextPosition){
        switch(nextPosition){
            case "townGate": townGate(); break;
            case "talkMan": talkMan(); break;
            case "attackMan": attackMan(); break;
            case "crossRoad": crossRoad(); break;
            case "north": north(); break;
            case "east": east(); break;
            case "west": west(); break;
            case "fight": fight(); break;
            case "playerAttack": playerAttack(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "ending": ending(); break;
            
        }
    }
    
    public void townGate(){
        ui.mainTextArea.setText("You head through the trees. There is a man to\n the left, staring intently at you" + " as he stands\n beside some gates.");
        ui.choice1.setText("Talk to the man");
        ui.choice2.setText("Attack the man");
        ui.choice3.setText("Ignore the man");
        ui.choice4.setText("");
        
        game.nextPosition1 = "talkMan";
        game.nextPosition2 = "attackMan";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }
    
    public void talkMan(){
        
        if(silverRing==0){
            
        ui.mainTextArea.setText("Mysterious Man: Hello there, traveller. I've seen many like you, coming through here,\n yet not many return. " +
                             "Be careful on your journey - danger" +
                             " lies ahead, but I see you're stronger than that. Let me help you.\n" +
                             " If you find something of worth, bring it to me, and I'll get you" +
                            " out of here.");
          
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
        
        else if(silverRing==1){
            ending();
        }
    }
    
    public void attackMan(){
        
       ui.mainTextArea.setText("Mysterious Man: That may have been a mistake on your part but I cannot let that slip.\n"
                    + "\n>The man hits you with his fist for 1 damage");
            
       player.hp = player.hp - 1;
       ui.hpLabelNumber.setText("" + player.hp);
            
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        
    }
    
    public void crossRoad(){
        ui.mainTextArea.setText("After heading forwards, you cross a bridge with \nthree roads leading off of it.\n"
                    + "Go south to head back to the Town Gates.");
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go South");
        ui.choice4.setText("Go West");
        
        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";
    }
    
    public void north(){
        ui.mainTextArea.setText("You reach a river. Sitting down to relax, you drink some of the water"
        + ", recovering your HP");
        
        player.hp=player.hp+1;
        
        ui.hpLabelNumber.setText("" + player.hp);
        ui.choice1.setText("Go South");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        
    }
    
    public void east(){
        ui.mainTextArea.setText("You reach an entrance to a forest up ahead, where a Short Sword is leaned against a tree.\n"
                    + "> Short Sword equipped");
            player.currentWeapon = new weapon_ShortSword();
            ui.weaponLabelName.setText(player.currentWeapon.name);
            ui.choice1.setText("Go West");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    
    public void west(){
        monster = new monster_Witch();
        
        ui.mainTextArea.setText("You encounter a " + monster.name + "!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    
    public void fight(){
        
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\nWhat will you do?");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        
    }
    
    public void playerAttack(){
        
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        ui.mainTextArea.setText("You attacked the Witch and gave " + playerDamage + " damage!");
        
        monster.hp = monster.hp - playerDamage;
        
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        if(monster.hp>0){
        game.nextPosition1 = "monsterAttack";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
        
        else if(monster.hp<1){
        game.nextPosition1 = "win";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
        
        
    }
    
    public void monsterAttack(){
        
        int monsterDamage = new java.util.Random().nextInt(monster.attack);
        
        player.hp = player.hp - monsterDamage;
        ui.hpLabelNumber.setText("" + player.hp);
        
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        if(player.hp>0){
        game.nextPosition1 = "fight";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
        
        else if(player.hp<1){
        game.nextPosition1 = "lose";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
    }
    
    public void win(){
        ui.mainTextArea.setText("You killed the witch!\n What's down there?"
            + "\n>You obtained Silver Ring");
            silverRing = 1;
            
        ui.choice1.setText("Go East");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    
    public void lose(){
        ui.mainTextArea.setText("You are Dead!\n Good luck next time.\n\nGAME OVER");
            silverRing = 1;
            
        ui.choice1.setText("Title Screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    
    public void ending(){
         ui.mainTextArea.setText("Mysterious Man: *Laughs* Well done traveller, I knew there"
                + " was something different about you. \n "+ " Well... let me show you something" +
            "\n> The man takes the ring from you, puts it on his finger"
                        + "and rises his hand to the lock.\n"
            + "\n>The gate opens.\n" + "You win!\nTHE END");
         
         ui.choice1.setText("");
	 ui.choice2.setText("");
	 ui.choice3.setText("");
	 ui.choice4.setText("");
         
	 ui.choice1.setVisible(false);
	 ui.choice2.setVisible(false);
         ui.choice3.setVisible(false);
	 ui.choice4.setVisible(false);
    }
    
    public void toTitle(){
        defaultSetup();
        vm.showTitleScreen();
    }
}
