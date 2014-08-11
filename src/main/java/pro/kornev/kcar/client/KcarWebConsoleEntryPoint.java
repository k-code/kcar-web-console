package pro.kornev.kcar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import pro.kornev.kcar.client.pages.main.MainPagePresenter;

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
