package pro.kornev.kcar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import pro.kornev.kcar.client.pages.MainPagePresenter;
import pro.kornev.kcar.client.status.ping.PingPresenter;
import pro.kornev.kcar.client.status.power.PowerPresenter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class KcarWebConsoleEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        HandlerManager eventBus = new HandlerManager(null);

        MainPagePresenter mainPagePresenter = new MainPagePresenter();

        mainPagePresenter.go(RootLayoutPanel.get());
    }

}
