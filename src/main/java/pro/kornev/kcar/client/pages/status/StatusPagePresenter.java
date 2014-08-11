package pro.kornev.kcar.client.pages.status;

import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.base.Presenter;
import pro.kornev.kcar.client.base.View;
import pro.kornev.kcar.client.widgets.status.ping.PingPresenter;
import pro.kornev.kcar.client.widgets.status.power.PowerPresenter;

/**
 * Status page presenter
 */
public class StatusPagePresenter extends Presenter {
    public interface Display extends View {
        HasWidgets getPingPanel();
        HasWidgets getPowerPanel();
    }

    private final Display view;
    private final PingPresenter pingPresenter;
    private final PowerPresenter powerPresenter;

    public StatusPagePresenter() {
        view = new StatusPageView();
        pingPresenter = new PingPresenter();
        powerPresenter = new PowerPresenter();
    }

    @Override
    public void go(HasWidgets container) {
        super.go(container);
        container.add(view.asWidget());
        pingPresenter.go(view.getPingPanel());
        powerPresenter.go(view.getPowerPanel());
    }

    @Override
    public void hide() {
        super.hide();
        pingPresenter.hide();
        powerPresenter.hide();
    }
}
