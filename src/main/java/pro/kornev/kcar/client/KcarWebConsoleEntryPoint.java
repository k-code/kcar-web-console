package pro.kornev.kcar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import pro.kornev.kcar.client.status.widgets.ping.PingWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class KcarWebConsoleEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(new HTML("GWT App has loaded.<br/>"));

        RootPanel.get().add(new PingWidget());
    }

}
