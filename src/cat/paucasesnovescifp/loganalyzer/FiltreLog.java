package cat.paucasesnovescifp.loganalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Procés Fill!
public class FiltreLog {
    public static void main(String[] args) {
        String countedWord = args.length > 0 ? args[0] : "ERROR";
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            int wordCount = 0;
            String curLine;
            while((curLine = input.readLine()) != null) {
                if(curLine.length() == 0) {
                    throw new IOException("Error: Text buit");
                }
                
                for(String word : curLine.split(" ")) {
                    if(word.toLowerCase().contains(countedWord.toLowerCase())) {
                        wordCount++;
                    }
                }
            }
            
            System.out.println(wordCount);
            System.exit(0);
        } catch(IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
}
