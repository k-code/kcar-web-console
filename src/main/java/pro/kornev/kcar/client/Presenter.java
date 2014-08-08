package pro.kornev.kcar.client;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Presenter interface
 */
public interface Presenter {
    void go(final HasWidgets container);
    void hide();
}
