package ua.com.smiddle.agent_scripting.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import ua.com.smiddle.agent_scripting.core.model.AdmUser;
import ua.com.smiddle.agent_scripting.core.model.JacksonUtil;
import ua.com.smiddle.agent_scripting.core.model.json.executor.ExecutorRequest;

import java.util.Base64;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * Created by srg on 27.06.16.
 */
@SuppressWarnings(value = "all")
public class Unit extends Thread implements Serializable {
    private AdmUser user;
    private String url;
    private HttpClient client;
    private PostMethod startPostMethod;
    private PostMethod nextPostMethod;
    private int DEBUG_LEVEL = -1;
    private StringRequestEntity re;
    private int iteartion = 0;


    //Constructors
    public Unit(ThreadGroup group, String name, AdmUser user, String url, int DEBUG_LEVEL, Long scriptID) {
        super(group, name);
        this.user = user;
        this.url = url;
        this.DEBUG_LEVEL = DEBUG_LEVEL;
        client = new HttpClient();
        startPostMethod = new PostMethod(this.url + "/script_executor/script_start");
        nextPostMethod = new PostMethod(this.url + "/script_executor/script_next");
        setCredentials();

        ExecutorRequest er = new ExecutorRequest();
        er.setScriptId(scriptID);
        er.setAgentId(user.getAgentId());
        re = createRequestEntity(er);
    }


    //Getters and setters


    //Methods
    @Override
    public void run() {
        if (DEBUG_LEVEL > 0) System.out.printf("Starting running. UserID=%s" + '\n', user.getId());
        try {
            startPostMethod.setRequestHeader("Content-Type", "application/json");
            startPostMethod.setRequestHeader("Accept", "*/*");
            startPostMethod.setRequestEntity(re);

            if (DEBUG_LEVEL > 2) printHeaders(startPostMethod, true);
            executeMethod(startPostMethod);
            String s = startPostMethod.getResponseBodyAsString();
            String value = null;
            if ((DEBUG_LEVEL > 0) && (startPostMethod.getResponseHeader("RETURNED_MESSAGE") != null) && (startPostMethod.getResponseHeader("RETURNED_MESSAGE").getValue() != null)) {
                value = startPostMethod.getResponseHeader("RETURNED_MESSAGE").getValue();
                System.out.printf("RETURNED_MESSAGE: %s" + '\n', StringUtils.newStringUtf8(Base64.getDecoder().decode(value)));
            }
            if (DEBUG_LEVEL > 1) System.out.printf("UserID=%s Response StartMethod: %s" + '\n', user.getId(), s);
            if (DEBUG_LEVEL > 2) printHeaders(startPostMethod, false);
            startPostMethod.releaseConnection();
            iteartion++;
            if (this.isInterrupted()) return;
            int index = 0;
            nextPostMethod.setParameter("Content-Type", "application/json");
            while (s != null && !s.trim().isEmpty()) {
                nextPostMethod.setRequestEntity(re);
                if (this.isInterrupted()) break;
                executeMethod(nextPostMethod);
                s = nextPostMethod.getResponseBodyAsString();
                if ((DEBUG_LEVEL > 1) && (nextPostMethod.getResponseHeader("RETURNED_MESSAGE") != null) && (nextPostMethod.getResponseHeader("RETURNED_MESSAGE").getValue() != null)) {
                    value = nextPostMethod.getResponseHeader("RETURNED_MESSAGE").getValue();
                    System.out.printf("RETURNED_MESSAGE: %s" + '\n', StringUtils.newStringUtf8(Base64.getDecoder().decode(value)));
                }
                iteartion++;
                if (DEBUG_LEVEL > 1) System.out.printf("UserID=%s Response NextMethod: %s" + '\n', user.getId(), s);
                if (nextPostMethod.getStatusCode() != 200) index++;
                if (index > 0) break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        startPostMethod.releaseConnection();
        if (DEBUG_LEVEL > 0) System.out.printf("UserID=%s exit, responces=%s" + '\n', user.getId(), iteartion);
    }

    private void setCredentials() {
        client.getParams().setAuthenticationPreemptive(true);
        Credentials credentials = new UsernamePasswordCredentials(user.getUsername(), "password");
        client.getState().setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM, AuthPolicy.BASIC),
                credentials);

    }

    private String executeMethod(PostMethod method) {
        String responce = null;
        try {
            client.executeMethod(method);
            if (DEBUG_LEVEL > 1) System.out.printf("UserID=%s. Code: %s " + '\n', user.getId(), method.getStatusCode());
            responce = method.getResponseBodyAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printHeaders(PostMethod method, boolean isRequestHeaders) {
        if (isRequestHeaders) {
            System.out.printf("UserID=%s. Request headers:" + '\n', user.getId());
            for (Header h : method.getRequestHeaders()) {
                System.out.print(h.toString());
            }
        } else {
            System.out.printf("UserID=%s. Response headers:" + '\n', user.getId());
            for (Header h : method.getResponseHeaders()) {
                System.out.print(h.toString());
            }
        }
    }

    private StringRequestEntity createRequestEntity(Object body) {
        StringRequestEntity re = null;
        try {
            re = new StringRequestEntity(JacksonUtil.objectToJson(body), "application/json", "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(re.getContent());
        return re;
    }

}
