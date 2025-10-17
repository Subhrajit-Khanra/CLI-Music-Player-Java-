package MusicPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main
{
    public static void main ( String[] args )
    {
        String path = "MusicPlayer/Nebula - The Grey Room _ Density & Time.wav";        
        File file = new File(path);

        try(Scanner sc = new Scanner(System.in);
            AudioInputStream audio = AudioSystem.getAudioInputStream(file))
        {
            Clip clip = AudioSystem.getClip();
            clip.open(audio);

            String response="";
            while (!response.equals("Q"))
            {
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter your choice: ");

                response = sc.next().toUpperCase();

                switch(response)
                {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default  -> System.out.println("Invalid Choice!");
                }
            }
        }
        catch(UnsupportedAudioFileException e)
        {
            System.out.println("Audio file is not supported");
        }
        catch(LineUnavailableException e )
        {
            System.out.println("Unable to access audio resource");
        }
        catch(IOException e )
        {
            System.out.println("Something went Wrong!");
        }
        finally
        {
            System.out.println("Bye!👋");
        }
    }
}
