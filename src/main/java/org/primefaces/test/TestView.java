package org.primefaces.test;

import org.omnifaces.cdi.ViewScoped;

import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;

@Named
@ViewScoped
public class TestView implements Serializable {

    private BigDecimal decimal;

    public void init() {
        decimal = new BigDecimal("123.45");
    }


    public String getWhatever() {
        for (var i = 0; i < 999999; i++) {
            new Random().nextInt(decimal.hashCode());
        }
        return decimal.toString();
    }

}
