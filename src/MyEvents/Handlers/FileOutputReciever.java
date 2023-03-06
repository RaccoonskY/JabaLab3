package MyEvents.Handlers;

import MyEvents.LogWriter;

public class FileOutputReciever implements IEv {

    public LogWriter logWriter;

    public FileOutputReciever(LogWriter lw){
        logWriter = lw;
    }
    public void Handler() {
        var response = "File output call";
        System.out.printf("Event '%s' has occurred!\n", response);
        logWriter.LogString("Event 'File output call' has occurred!");
    }
}
