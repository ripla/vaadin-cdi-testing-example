/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.risto.vaadin.cdi.test;

import com.vaadin.cdi.internal.BeanStoreContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(Arquillian.class)
public class VaadinPresenterTest {

    @Inject
    TestPresenter presenter;

    @Produces
    TestView view = Mockito.mock(TestView.class);
    
    @Deployment
    public static JavaArchive createDeployment() {
        UI.setCurrent(new UI() {
            @Override
            protected void init(VaadinRequest request) {
                throw new UnsupportedOperationException("");
            }
        });
        return ShrinkWrap.create(JavaArchive.class).addClass(TestPresenter.class)
                .addClass(TestView.class)
                .addClass(BeanStoreContainer.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testPresenterMethod() {
        Assert.assertTrue(presenter.foo());
    }
}