import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("Islabonita - An Jone.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = " ";

            while (!response.equals("Q")) {
                System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
                System.out.println("Do you want play?");
                response = scanner.next();

                switch (response) {
                    case("P"): clip.start();break;
                    case("S") : clip.stop(); break;
                    case("R"): clip.setMicrosecondPosition(0); break;
                    case("Q"): clip.close();
                    default: System.out.println("It's not a valid response.");
                }
            }
            System.out.println("Bye.Bye.");




        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }
}
