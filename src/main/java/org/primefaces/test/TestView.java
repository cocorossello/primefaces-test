package org.primefaces.test;


import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class TestView implements Serializable {

    private String param;

    public String doSomething() throws IOException {
        System.out.println("param: " + param + " jsessionid: " + Faces.getSessionId());
        if (param == null) {
            Faces.getResponse().sendError(500, "Error!");
            Faces.responseComplete();
        }
        return param;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
