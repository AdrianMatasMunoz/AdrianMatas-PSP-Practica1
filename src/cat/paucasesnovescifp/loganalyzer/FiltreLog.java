package cat.paucasesnovescifp.loganalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Procés Fill!
public class FiltreLog {
    public static void main(String[] args) {
        System.out.println("test");
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String curLine = input.readLine();
            int errorCount = 0;
            while(curLine != null) {
                for(String word : curLine.split(" ")) {
                    if(word.toLowerCase().equals("error")) {
                        errorCount++;
                    }
                }
                curLine = input.readLine();
            }
            System.out.println(errorCount);
        } catch(IOException ex) {
            System.err.println("Error llegint l'input.");
        }
    }
}
