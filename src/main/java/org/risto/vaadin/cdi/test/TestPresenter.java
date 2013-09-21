package org.risto.vaadin.cdi.test;

import javax.inject.Inject;

class TestPresenter {

    @Inject
    TestView view;

    public TestView getView() {
        return view;
    }

    boolean foo() {
        return true;
    }
}
