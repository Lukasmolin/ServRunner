package ServRunner.model.server;

import java.io.IOException;

import ServRunner.model.runtime.CLIExecution;
import ServRunner.model.runtime.RuntimeWrapper;

/**
 * ServerStarter
 */
public class ServerManager extends RuntimeWrapper{

    public ServerManager(String folderPath) {
        super(folderPath);
    }

    public CLIExecution updateGit() throws IOException{
        return super.executeCommand("git pull");
    }

    public CLIExecution gradleBootrun() throws IOException {
        return super.executeCommand("./gradlew.bat bootrun");
    }   
    
}