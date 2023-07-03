package org.primefaces.test;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
    }

    public List<SomeBean> getSomeBeans() {
        return List.of(new SomeBean("some string!"));
    }

    public void confirm() {
        addMessage("Confirmed", "You have accepted");
    }


    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public class SomeBean {
        private String someString;

        public SomeBean() {
        }

        public SomeBean(String someString) {
            this.someString = someString;
        }

        public String getSomeString() {
            return someString;
        }
    }
}
