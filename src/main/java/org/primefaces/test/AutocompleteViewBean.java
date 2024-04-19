package org.primefaces.test;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AutocompleteViewBean implements Serializable {
    private String value;
    public List<String> complete(String query) {
        return List.of("Result 1", "Result 2", "Result 3");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
