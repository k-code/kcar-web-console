package pro.kornev.kcar.client.status.ping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import pro.kornev.kcar.client.Action;

/**
 * Ping widget
 */
public class PingView extends Composite implements PingPresenter.Display {

    interface ThisUiBinder extends UiBinder<Widget, PingView> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField Button pingButton;
    @UiField Label pingResultHolder;

    private Action pingAction;

    public PingView() {
        initWidget(uiBinder.createAndBindUi(this));

        pingButton.setText("Ping");
        pingResultHolder.setText("failed");
    }

    @Override
    public void setPingAction(Action action) {
        pingAction = action;
    }

    @Override
    public void setStatus(boolean success) {
        if (success) {
            pingResultHolder.setText("success");
        } else {
            pingResultHolder.setText("failed");
        }
    }

    @SuppressWarnings("unused")
    @UiHandler("pingButton")
    void onPingButton(ClickEvent event) {
        pingAction.execute();
    }
}
