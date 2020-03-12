package ServRunner.model.runtime;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Nullable;

/**
 *
 * @author gleiph
 */
public class CLIExecute {
    
    public static CLIExecution execute(String command, String directory) throws IOException {
        System.out.println("Executing: "+command+"\nPath: "+directory);
        CLIExecution execution = new CLIExecution(command);
        
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec(command, null,
                new File(directory));

        String s;

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(exec.getErrorStream()));

        // read the output from the command
        while ((s = stdInput.readLine()) != null) {
            execution.addOutput(s);
        }

        // read any errors from the attempted command
        while ((s = stdError.readLine()) != null) {
            execution.addError(s);
        }
        
        return execution;
    }
    
}