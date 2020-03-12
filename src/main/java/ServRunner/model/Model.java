package ServRunner.model;

import ServRunner.model.runtime.CLIExecution;
import ServRunner.model.server.ServerManager;

/**
 * Model
 */
public class Model {

    private ServerManager sm;

    public Model(){
        sm = new ServerManager(System.getProperty("user.dir"));
    }

    public Model(String path){
        sm = new ServerManager(path);
    }

    public String update(){
        CLIExecution exec;
        try {
            exec = sm.updateGit();
        } catch (Exception e) {
            return e.toString();    
        }
        if(exec != null){
            String rtn = "";
            for(String s : exec.getOutput())
                rtn+="\n"+s;

            for(String s : exec.getError())
                rtn += "\n"+s;

            return rtn;
        }
        return "ERRO!!!";
    }

    public String run(){
        CLIExecution exec;
        try {
            exec = sm.gradleBootrun();
        } catch (Exception e) {
            return e.toString();    
        }
        if(exec != null){
            String rtn = "";
            for(String s : exec.getOutput())
                rtn+="\n"+s;

            for(String s : exec.getError())
                rtn += "\n"+s;

            return rtn;
        }
        return "ERRO!!!";
    }
}