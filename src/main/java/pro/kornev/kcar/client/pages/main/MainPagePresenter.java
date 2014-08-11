package pro.kornev.kcar.client.pages.main;

import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.base.Action;
import pro.kornev.kcar.client.base.Presenter;
import pro.kornev.kcar.client.base.View;
import pro.kornev.kcar.client.pages.status.StatusPagePresenter;
import pro.kornev.kcar.client.widgets.status.ping.PingPresenter;
import pro.kornev.kcar.client.widgets.status.power.PowerPresenter;

/**
 * Main page presenter
 */
public class MainPagePresenter extends Presenter {

    public interface Display extends View {
        HasWidgets getContentPanel();
        void setStatusButtonAction(Action action);
        void setVideoButtonAction(Action action);
    }

    private final Display view;

    private Presenter currentPagePresenter;

    public MainPagePresenter() {
        view = new MainPageView();

        view.setStatusButtonAction(createShowPageAction(new StatusPagePresenter()));
    }

    @Override
    public void go(HasWidgets container) {
        super.go(container);
        container.add(view.asWidget());
    }

    @Override
    public void hide() {
        super.hide();
        if (currentPagePresenter != null) {
            currentPagePresenter.hide();
        }
    }

    private Action createShowPageAction(final Presenter pagePresenter) {
        return new Action() {
            @Override
            public void execute() {
                if (currentPagePresenter != null) {
                    currentPagePresenter.hide();
                }
                currentPagePresenter = pagePresenter;
                pagePresenter.go(view.getContentPanel());
            }
        };
    }
}
