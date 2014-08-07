package pro.kornev.kcar.client.status.widgets.ping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Composite;
import pro.kornev.kcar.client.status.rpc.StatusRpcService;
import pro.kornev.kcar.client.status.rpc.StatusRpcServiceAsync;

/**
 * Ping widget
 */
public class PingWidget extends Composite {

    interface ThisUiBinder extends UiBinder<Widget, PingWidget> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField Button pingButton;
    @UiField Label pingResultHolder;


    private StatusRpcServiceAsync statusService = GWT.create(StatusRpcService.class);

    public PingWidget() {
        initWidget(uiBinder.createAndBindUi(this));

        pingButton.setText("Ping");
        pingResultHolder.setText("failed");
    }


    @UiHandler("pingButton")
    void handleClick(ClickEvent e) {
        statusService.ping(pingCallback);
    }

    private AsyncCallback<Boolean> pingCallback = new AsyncCallback<Boolean>() {
        @Override
        public void onFailure(Throwable throwable) {
            Window.alert("Ping failed" + throwable);
        }

        @Override
        public void onSuccess(Boolean success) {
            if (success) {
                pingResultHolder.setText("success");
            } else {
                pingResultHolder.setText("failed");
            }
        }
    };
}
