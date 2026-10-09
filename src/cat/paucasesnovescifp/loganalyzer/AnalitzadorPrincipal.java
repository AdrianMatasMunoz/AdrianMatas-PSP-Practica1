package cat.paucasesnovescifp.loganalyzer;

// Procés Pare!

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AnalitzadorPrincipal {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./build/classes/", "cat.paucasesnovescifp.loganalyzer.FiltreLog");
        try {
            Process process = pb.start();
            BufferedReader in = process.inputReader();
            BufferedWriter out = process.outputWriter();
            
            System.out.println(in.readLine());
            in.close();
            out.close();
        } catch(IOException ex) {
            System.err.println("Hi ha hagut un error.");
        }
    }
}
