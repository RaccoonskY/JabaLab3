package MyEvents.Handlers;


import MyEvents.LogWriter;

public class ConsoleOutputReciever implements IEv {

    public LogWriter logWriter;
    public ConsoleOutputReciever(LogWriter lw){
        logWriter = lw;
    }
    public void Handler() {
        var response = "Console output call";
        System.out.printf("Event '%s' has occurred!\n", response);
        logWriter.LogString("Event 'Console output call' has occurred!");
    }
}
