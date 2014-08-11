package pro.kornev.kcar.client.base;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Base abstract presenter class
 */
public abstract class Presenter {
    protected HasWidgets container;

    public void go(final HasWidgets container) {
        hide();
        this.container = container;
        this.container.clear();
    }

    public void hide() {
        if (container != null) {
            container.clear();
        }
        container = null;
    }
}
