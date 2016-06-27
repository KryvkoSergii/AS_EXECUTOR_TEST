package ua.com.smiddle.agent_scripting.core;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import ua.com.smiddle.agent_scripting.core.model.AdmUser;

import java.io.Serializable;

/**
 * Created by srg on 27.06.16.
 */

public class Unit extends Thread implements Serializable {
    private AdmUser user;
    private PostMethod postMethod;
    private String url;
    private HttpClient client;



    public Unit(ThreadGroup group, String name, AdmUser user,String url) {
        super(group, name);
        this.user = user;
        client = new HttpClient();
        postMethod = new PostMethod();
        this.url = url;
    }

    @Override
    public void run() {
        setCredentials();
        scriptStart();
        scriptNext();
    }

    private void scriptStart(){
        PostMethod postMethod = new PostMethod(url+"/script_executor/script_start");
    }

    private void scriptNext(){}

    private void setCredentials(){
        client.getParams().setAuthenticationPreemptive(true);
        Credentials credentials = new UsernamePasswordCredentials(user.getUsername(), user.getPassword());
        client.getState().setCredentials(new AuthScope(null, -1, AuthScope.ANY_REALM), credentials);
    }

}
