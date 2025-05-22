import javax.swing.*;
import java.awt.event.*;
public class TimerTest
{
    
    public static void main(String[] args){
        System.out.println("yuh");
        int[] i = {0};
        Timer[] timer = new Timer[1];
        timer[0] = new Timer(500,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(i[0]>=10){
                    timer[0].stop();
                }
                System.out.println("Tick!");
                i[0]++;
            }
        });
        timer[0].start();
    }
}
