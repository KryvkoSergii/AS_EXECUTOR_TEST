package ua.com.smiddle.agent_scripting.core;

import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import sun.net.www.http.HttpClient;
import ua.com.smiddle.agent_scripting.core.model.AdmUser;

import java.io.Serializable;

/**
 * Created by srg on 27.06.16.
 */

public class Unit extends Thread implements Serializable {
    private AdmUser user;
    private PostMethod postMethod;


    public Unit(ThreadGroup group, String name, AdmUser user) {
        super(group, name);
        this.user = user;
        postMethod = new PostMethod();
    }

    @Override
    public void run() {
        super.run();


    }

}
