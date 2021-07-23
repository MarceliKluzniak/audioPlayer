package pl.mkluzniak;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException { //adding throws declaration

        Scanner scanner = new Scanner(System.in); //scanner for user to type sth to not terminate immediatly

        File file = new File("Vital-Whales-Unicorn-Heads.wav"); //create new file and add file music
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);//creating new audio stream
        Clip clip = AudioSystem.getClip(); //creating new clip
        clip.open(audioStream);//opening clip audio

        String response = ""; //blank response for user to type in

        while(!response.equals("Q")) { //while loop what wait for response of user
            System.out.println("P = play, S = Stop, R = Reset, Q = Quit"); //print legend for buttons
            System.out.print("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();//when users type in lower case letters it will read it as upper case

            switch(response) { //will examine what is type in ang match
                case ("P"): clip.start();//case that test if its play method
                    break;
                case ("S"): clip.stop();//case that test if its stop method
                    break;
                case ("R"): clip.setMicrosecondPosition(0);//case that test if its reset method
                    break;
                case ("Q"): clip.close();//case that test if its quit method
                    break;
                default: System.out.println("Not a valid response"); //if user type different letter program will detect it and print valid response
            }

        }
        System.out.println("Byeeee!"); //line that is print when user click q
    }
}