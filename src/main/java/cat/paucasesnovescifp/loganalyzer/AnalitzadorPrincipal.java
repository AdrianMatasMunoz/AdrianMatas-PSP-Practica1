package cat.paucasesnovescifp.loganalyzer;

// Procés Pare!

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class AnalitzadorPrincipal {
    public static void main(String[] args) {
        String testTxt = "ERROR: File not found.\nLOG: Hello, world!\nWARNING: Hello, error?\nWARNING: Check error output and warning output files.";
        
        ProcessBuilder pbErr = new ProcessBuilder("java", "-cp", "./target/classes/", "cat.paucasesnovescifp.loganalyzer.FiltreLog", "ERROR");
        ProcessBuilder pbWarn = new ProcessBuilder("java", "-cp", "./target/classes/", "cat.paucasesnovescifp.loganalyzer.FiltreLog", "WARNING");
        try {
            Process processErr = pbErr.start();
            Process processWarn = pbWarn.start();
            
            BufferedReader inErr = processErr.inputReader();
            BufferedWriter outErr = processErr.outputWriter();
            BufferedReader inWarn = processWarn.inputReader();
            BufferedWriter outWarn = processWarn.outputWriter();
            
            pbErr.redirectError(new File("./errors_filtre.log"));
            pbWarn.redirectError(new File("./warnings_filtre.log"));
            
            outErr.write(testTxt+"\n");
            outErr.flush();
            outErr.close();
            
            outWarn.write(testTxt+"\n");
            outWarn.flush();
            outWarn.close();
            
            processErr.waitFor();
            int exitCodeErr = processErr.exitValue();
            
            processWarn.waitFor();
            int exitCodeWarn = processWarn.exitValue();
            
            int errorCount = Integer.parseInt(inErr.readLine());
            int warnCount = Integer.parseInt(inWarn.readLine());
            int generalExitCode = exitCodeErr | exitCodeWarn;
            
            inErr.close();
            inWarn.close();
            
            System.out.println("RESULTAT: ERRORS="+errorCount+" | WARNINGS="+warnCount+" | EXIT_CODE="+generalExitCode);
        } catch(IOException | InterruptedException ex) {
            System.err.println("Hi ha hagut un error.");
        }
    }
}
