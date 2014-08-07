package pro.kornev.kcar.client.status.ping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.Presenter;
import pro.kornev.kcar.client.View;
import pro.kornev.kcar.client.status.rpc.StatusRpcService;
import pro.kornev.kcar.client.status.rpc.StatusRpcServiceAsync;

/**
 * Ping presenter
 */
public class PingPresenter implements Presenter {

    private final Display view;
    private final StatusRpcServiceAsync rpcService;

    public interface Display extends View {
        void setStatus(boolean success);
        HasClickHandlers getPingButton();
    }

    public PingPresenter() {
        view = new PingView();
        rpcService = GWT.create(StatusRpcService.class);
    }

    @Override
    public void go(HasWidgets container) {
        bind();
        container.clear();
        container.add(view.asWidget());
    }

    public void onPingClick() {
        rpcService.ping(pingCallback);
    }

    private void bind() {
    }

    private AsyncCallback<Boolean> pingCallback = new AsyncCallback<Boolean>() {
        @Override
        public void onFailure(Throwable throwable) {
            Window.alert("Ping FAILED\n" + throwable.getMessage());
        }

        @Override
        public void onSuccess(Boolean success) {
            view.setStatus(success);
        }
    };

}
