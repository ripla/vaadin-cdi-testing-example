package org.risto.vaadin.cdi.test;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.Label;

@UIScoped
@CDIView("test")
public class TestViewImpl extends Label implements TestView {
    
    public TestViewImpl() {
        super("TestView");
    }
}
