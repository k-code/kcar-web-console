package pro.kornev.kcar.client.status.ping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Composite;

/**
 * Ping widget
 */
public class PingWidget extends Composite {

    interface ThisUiBinder extends UiBinder<Widget, PingWidget> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField Button pingButton;
    @UiField Label pingResultHolder;

    public PingWidget() {
        initWidget(uiBinder.createAndBindUi(this));

        pingButton.setText("Ping");
        pingResultHolder.setText("failed");
    }


    @UiHandler("pingButton")
    void handleClick(ClickEvent e) {
        pingResultHolder.setText("success");
    }
}
