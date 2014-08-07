package pro.kornev.kcar.client;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base display interface for presenters
 */
public interface View<T extends View.Presenter> {
    interface Presenter {
        void go(final HasWidgets container);
    }

    Widget asWidget();

    void setPresenter(T presenter);
}
