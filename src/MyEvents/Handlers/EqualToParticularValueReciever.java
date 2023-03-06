package MyEvents.Handlers;

import MyEvents.LogWriter;

public class EqualToParticularValueReciever implements IEv {

    public LogWriter logWriter;

    public EqualToParticularValueReciever(LogWriter lw){
        logWriter = lw;
    }
    public void Handler(){
        var response = "Equality to the particular value";
        System.out.printf("Event '%s' has occurred!\n", response);
        logWriter.LogString("Event 'Equality to the particular value' has occurred!");
    }
}
