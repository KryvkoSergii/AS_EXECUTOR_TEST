package ua.com.smiddle.agent_scripting.core;


import ua.com.smiddle.agent_scripting.core.model.json.executor.ExecutorRequest;

/**
 * Created by srg on 27.06.16.
 */

public class AppInitializer {

    public static void main(String[] args) {
        Executor e = new Executor();
        e.setUserCount(30);
        e.setDEBUG_LEVEL(0);
        e.setHost("http://172.22.2.34:80/AgentScripting");
        e.setScriptID(9L);
        e.prepare();
        e.execute();
    }
}
