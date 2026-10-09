package cat.paucasesnovescifp.loganalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Procés Fill!
public class FiltreLog {
    public static void main(String[] args) {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            int errorCount = 0;
            ArrayList<String> logs = new ArrayList<>();
            String inputLine = input.readLine();
            while(!inputLine.equals(";")) {
                logs.add(inputLine);
                inputLine = input.readLine();
            }
            
            for(String curLine : logs) {
                for(String word : curLine.split(" ")) {
                    if(word.toLowerCase().contains("error")) {
                        errorCount++;
                    }
                }
            }
            System.out.println(errorCount);
        } catch(IOException ex) {
            System.err.println("Error llegint l'input.");
        }
    }
}
