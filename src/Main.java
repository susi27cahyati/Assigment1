import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.enigma.model.Direction;
import com.enigma.model.Robot;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Tentukan titik awal robot dan arah robot ex.(1,1,WEST): ");
        String koordinat = reader.readLine();
        String[] post = koordinat.split(",");

        Robot robot = new Robot(Integer.parseInt(post[0]),Integer.parseInt(post[1]), Direction.valueOf(post[2].toUpperCase()));
        System.out.print("Input gerakan robot- :");
        String gerak = reader.readLine();
        robot.commands(gerak);
        robot.run();
        System.out.println(robot.print());

    }
}
