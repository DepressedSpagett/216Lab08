
package vecchio_lab08;

import java.io.*;
import java.util.Scanner;

public class Receiver {
//==============================================================================    
    //Attributes
//==============================================================================
    private int volume;
    private int currentFreqAM;
    private double currentFreqFM;
    private String currentBand;
    private int [ ] presetAM;
    private double [ ] presetFM;

//==============================================================================    
    //Methods of Pain
//==============================================================================   
    
    //Load Settings
    public void LoadSettings() throws IOException{
        
        File receiverFile;
        Scanner receiverFileSC;
        presetAM = new int[5];
        presetFM = new double [5];
        receiverFile = new File("receiver.txt");
        receiverFileSC = new Scanner(receiverFile);
        
        currentBand = receiverFileSC.nextLine();
        currentFreqAM = receiverFileSC.nextInt();
        currentFreqFM = receiverFileSC.nextDouble();
        volume = receiverFileSC.nextInt();
        //AM Presets
        presetAM[0] = receiverFileSC.nextInt( );
        presetAM[1] = receiverFileSC.nextInt( );
        presetAM[2] = receiverFileSC.nextInt( );
        presetAM[3] = receiverFileSC.nextInt( );
        presetAM[4] = receiverFileSC.nextInt( );
        //FM Presets
        presetFM[0] = receiverFileSC.nextDouble( );
        presetFM[1] = receiverFileSC.nextDouble( );
        presetFM[2] = receiverFileSC.nextDouble( );
        presetFM[3] = receiverFileSC.nextDouble( );
        presetFM[4] = receiverFileSC.nextDouble( );
        
        receiverFileSC.close();
    }
    
    //Save Settings
    public void SaveSettings() throws IOException{
       
        PrintWriter outPW;
       
        outPW = new PrintWriter("receiver.txt");
        outPW.println(currentBand);
        outPW.println(currentFreqAM);
        outPW.println(currentFreqFM);
        outPW.println(volume);
        //AM Presets 
        outPW.println(presetAM[0]);
        outPW.println(presetAM[1]);
        outPW.println(presetAM[2]);
        outPW.println(presetAM[3]);
        outPW.println(presetAM[4]);
        //FM Presets
        outPW.println(presetFM[0]);
        outPW.println(presetFM[1]);
        outPW.println(presetFM[2]);
        outPW.println(presetFM[3]);
        outPW.println(presetFM[4]);
        outPW.close( );
    }
    
    //Change Band
    public void ChangeBand(){
        if (currentBand.equals("AM") ){
            currentBand = "FM";   
        }
        else {
            currentBand = "AM";
        }
    }
    
    //Increase Frequency
    public void IncreaseFrequency(){
    if (currentBand.equals("AM"))
        if (currentFreqAM < 1700)
        currentFreqAM += 10;
    if (currentBand.equals("FM")){
        if(currentFreqFM <108.0) 
        currentFreqFM += 0.2;
    }
       
    }
    
    //Decrease Frequency
    public void DecreaseFrequency(){
    if (currentBand.equals("AM"))
        if (currentFreqAM > 540)
        currentFreqAM -= 10;
    if (currentBand.equals("FM")){
        if(currentFreqFM >87.5) 
        currentFreqFM -= 0.2;
    }
       
    }
    
    //Increase Volume
    public void IncreaseVolume(){
    if (volume < 100)    
        volume += 1;
    }
    
    //Decrease Volume
    public void DecreaseVolume(){
    if (volume > 0)    
        volume -= 1;
    }
    
    //Set Preset 
    public void SetPreset(int presetChoice){
        if (currentBand.equals("AM")) {
            presetAM[presetChoice] = currentFreqAM;
        } else {
            currentFreqFM = presetFM[presetChoice];
    }
    }
    
    //Select Preset 
    public void SelectPreset(int presetChoice){
        if (currentBand.equals("AM")) {
            currentFreqAM = presetAM[presetChoice];
        } else {
            currentFreqFM = presetFM[presetChoice];
    } 
    }
    
    //Display Status
    public void DisplayStatus() {
        if (currentBand.equals("AM")) {
            System.out.printf("Current Band: %s | Frequency: %d kHz | Volume: %d%n", currentBand, currentFreqAM, volume);
        } else {
            System.out.printf("Current Band: %s | Frequency: %.1f MHz | Volume: %d%n", currentBand, currentFreqFM, volume);
        }
        System.out.print("AM Presets: ");
        for (int cnt = 0; cnt < presetAM.length; cnt++) {
            System.out.printf("%d: %d kHz ", cnt + 1, presetAM[cnt]);
        }
        System.out.println();
        System.out.print("FM Presets: ");
        for (int cnt = 0; cnt < presetFM.length; cnt++) {
            System.out.printf("%d: %.1f MHz ", cnt + 1, presetFM[cnt]);
        }
        System.out.println("\n");
    }
}
