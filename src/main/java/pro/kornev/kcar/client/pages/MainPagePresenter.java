package pro.kornev.kcar.client.pages;

import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.Action;
import pro.kornev.kcar.client.Presenter;
import pro.kornev.kcar.client.View;
import pro.kornev.kcar.client.widgets.status.ping.PingPresenter;
import pro.kornev.kcar.client.widgets.status.power.PowerPresenter;

/**
 * Main page presenter
 */
public class MainPagePresenter implements Presenter {

    public interface Display extends View {
        HasWidgets getContentPanel();
        void setStatusButtonAction(Action action);
        void setVideoButtonAction(Action action);
    }

    private final Display view;
    private final PingPresenter pingPresenter;
    private final PowerPresenter powerPresenter;

    private HasWidgets container;

    public MainPagePresenter() {
        view = new MainPageView();
        pingPresenter = new PingPresenter();
        powerPresenter = new PowerPresenter();

        view.setStatusButtonAction(createShowPage(pingPresenter));
        view.setVideoButtonAction(createShowPage(powerPresenter));
    }

    @Override
    public void go(HasWidgets container) {
        hide();
        this.container = container;
        container.clear();
        container.add(view.asWidget());
    }

    @Override
    public void hide() {
        if (container != null) {
            container.clear();
        }
    }

    private Action createShowPage(final Presenter presenter) {
        return new Action() {
            @Override
            public void execute() {
                pingPresenter.hide();
                powerPresenter.hide();
                presenter.go(view.getContentPanel());
            }
        };
    }
}
