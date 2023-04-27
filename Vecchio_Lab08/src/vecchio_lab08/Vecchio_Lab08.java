
package vecchio_lab08;
import java.io.*;
import java.util.Scanner; 

public class Vecchio_Lab08 {
    
// PROGRAM NAME: Labratory 08
// PROGRAMMER: Jacob Vecchio
// DATE DUE: Wednesday, April 26th 2023
// PROGRAM PURPOSE: 
// To confuse and/or confound me!!!
// This program will allow the user to change settings on a radio receiver with the use 
// of a menu.
   
//==============================================================================
    //Perform Each Task
//==============================================================================
     public static void main(String[] args)throws IOException {
        Receiver theReceiver;
        theReceiver = new Receiver();
        theReceiver.LoadSettings();
        theReceiver.DisplayStatus();
        
        while (true) {
            char choice;
            choice = GetChoice();
            PerformChoice(choice, theReceiver);
            theReceiver.DisplayStatus();
        }
    }
    
//==============================================================================
    //Get Choice
//==============================================================================
     public static char GetChoice() {
        Scanner kbd = new Scanner(System.in);
        System.out.print(
                "Choose one of the following: (1)Change band, (2)Increase Frequency,"
                        + " " + "(3)Decrease Frequency, (4)Volume up, (5)Volume Down, "
                        + "(6)Set Preset, (7)Select Preset, (8)Save/Quit: ");
        return kbd.next().toUpperCase().charAt(0);
    }
    
//==============================================================================
    //Perform Choice
//==============================================================================
      public static void PerformChoice(char choice, Receiver theReceiver) throws IOException{
        switch (choice) {
            case '1':
                theReceiver.ChangeBand();
                break;
            case '2':
                theReceiver.IncreaseFrequency();
                break;
            case '3':
                theReceiver.DecreaseFrequency();
                break;
            case '4':
                theReceiver.IncreaseVolume();
                break;
            case '5':
                theReceiver.DecreaseVolume();
                break;
            case '6':
                SetNewPreset(theReceiver);
                break;
            case '7':
                SelectNewPreset(theReceiver);
                break;
            case '8':
                theReceiver.SaveSettings();
                System.exit(0);
                break;
            default:
                System.out.println("Input Error, Make a new selection");
        }
    }

    
//==============================================================================
    //Set New Preset
//==============================================================================
   public static void SetNewPreset(Receiver theReceiver) {
        Scanner kbd = new Scanner(System.in);
        System.out.print("To Set preset, choose a number (1-5): ");
        int presetChoice = kbd.nextInt() - 1;
        if (presetChoice >= 0 && presetChoice < 5) {
            theReceiver.SetPreset(presetChoice);
        } else {
            System.out.println("Error occured, Enter a valid Number!!!");
        }
    }
    
//==============================================================================
    //Select New Preset 
//==============================================================================
   public static void SelectNewPreset(Receiver theReceiver) {
        Scanner kbd = new Scanner(System.in);
        System.out.print("To Select preset, choose a number (1-5): ");
        int presetChoice = kbd.nextInt() - 1;
        if (presetChoice >= 0 && presetChoice < 5) {
            theReceiver.SelectPreset(presetChoice);
        } else {
            System.out.println("Error occured, Enter a valid Number!!!");
        }
    }
}

