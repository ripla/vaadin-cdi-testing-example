package org.risto.vaadin.cdi.test;

import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import javax.inject.Inject;

@CDIUI
public class MyUI extends UI {

    @Inject
    TestPresenter presenter;
    @Inject
    CDIViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);

        navigator.navigateTo("test");
    }
}