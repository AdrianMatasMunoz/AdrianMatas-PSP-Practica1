package cat.paucasesnovescifp.loganalyzer;

// Procés Pare!

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AnalitzadorPrincipal {
    public static void main(String[] args) {
        String testTxt = """
ERROR: File not found.
LOG: Hello, world!
WARNING: Hello, error?""";
        
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./build/classes/", "cat.paucasesnovescifp.loganalyzer.FiltreLog");
        try {
            Process process = pb.start();
            BufferedReader in = process.inputReader();
            BufferedWriter out = process.outputWriter();
            
            for(String line : testTxt.split("\n")) {
                out.write(line + "\n");
            }
            out.write(";\n");
            out.flush();
            process.waitFor();
            System.out.println(in.readLine());
            
            in.close();
            out.close();
        } catch(IOException | InterruptedException ex) {
            System.err.println("Hi ha hagut un error.");
        }
    }
}
