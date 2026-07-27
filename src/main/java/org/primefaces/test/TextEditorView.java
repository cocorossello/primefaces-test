package org.primefaces.test;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class TextEditorView implements Serializable {
    private boolean editing = false;
    private String text;

    public void startEdit() {
        editing = true;
    }

    public void save() {
        editing = false;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
