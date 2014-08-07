package pro.kornev.kcar.client.status.ping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Composite;
import pro.kornev.kcar.client.View;

/**
 * Ping widget
 */
public class PingView extends Composite implements View<PingPresenter> {

    interface ThisUiBinder extends UiBinder<Widget, PingView> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField Button pingButton;
    @UiField Label pingResultHolder;

    private PingPresenter presenter;

    public PingView() {
        initWidget(uiBinder.createAndBindUi(this));

        pingButton.setText("Ping");
        pingResultHolder.setText("failed");
    }

    @Override
    public void setPresenter(PingPresenter presenter) {
        this.presenter = presenter;
    }

    public void setStatus(Boolean success) {
        if (success) {
            pingResultHolder.setText("success");
        } else {
            pingResultHolder.setText("failed");
        }
    }

    @UiHandler("pingButton")
    void onPingButton(ClickEvent e) {
        presenter.onPingClick();
    }
}
