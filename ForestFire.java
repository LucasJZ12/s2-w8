import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ForestFire {
    public static void main(String[] args) throws IOException{
        // Step 1: Read in the data file (forests.csv) and create Forest objects.
        //   - Open the CSV file.
        //   - Skip/read the header row.
        //   - Parse each line into fields and construct a Forest.
        //   - Store forests in an ArrayList: ArrayList<Forest> forests = ...
        ArrayList<Forest> forests = new ArrayList<Forest>();
        File f = new File("forests.csv");
        Scanner s = new Scanner(f);
        s.nextLine();
        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] temp = line.split(",");
            Forest forest = new Forest(temp[0], temp[1], temp[2], Double.parseDouble(temp[7]), Integer.parseInt(temp[9]), Integer.parseInt(temp[8]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6]));
            forests.add(forest);
        }
        s.close();

        // Step 2: Pick one forest to run the simulation.
        //   - Choose by index.
        //   - Start at least one burning tree to begin the fire.
        forests.get(0).getGrid()[0][0].setState(Tree.BURNING);
        forests.get(0).printGrid();
        // Step 3: Run the simulation.
        //   - Repeat spreadFire() for a fixed number of steps (or until fire ends).
        // while(forests.get(0).allBurned()){
        //     forests.get(0).spreadFire();
        // }
        // forests.get(0).printGrid();
        for(int i = 0; i< 2; i++){
            forests.get(0).spreadFire();
        }
        //   - At the end, print percentBurned() and summary stats.
        System.out.println(forests.get(0).percentBurned());
        //   - At the end of each simulation step, you should write the current state of the Tree[][] grid to a file

        // Step 4: We will vibe code our way to visualization

    }

}
