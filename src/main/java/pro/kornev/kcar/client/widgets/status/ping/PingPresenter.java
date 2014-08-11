package pro.kornev.kcar.client.widgets.status.ping;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.base.Action;
import pro.kornev.kcar.client.base.Presenter;
import pro.kornev.kcar.client.base.View;
import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcService;
import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcServiceAsync;
import pro.kornev.kcar.shared.widgets.status.exception.PingTimeOutException;

/**
 * Ping presenter
 */
public class PingPresenter extends Presenter {

    public interface Display extends View {
        void setTime(float time);
        void timeout();
        void setPingAction(Action action);
    }

    private final Display view;
    private final StatusRpcServiceAsync rpcService;
    private final Action pingAction;
    private final Timer pingTimer;

    public PingPresenter() {
        rpcService = GWT.create(StatusRpcService.class);
        pingAction = createPingAction();
        pingTimer = createPingTimer();
        view = new PingView();
        view.setPingAction(pingAction);
    }

    @Override
    public void go(HasWidgets container) {
        super.go(container);
        container.add(view.asWidget());
        pingTimer.scheduleRepeating(3000);
    }

    @Override
    public void hide() {
        super.hide();
        if (pingTimer != null) {
            pingTimer.cancel();
        }
    }

    private Action createPingAction() {
        return new Action() {
            @Override
            public void execute() {
                rpcService.ping(createPingCallBack());
            }
        };
    }

    private AsyncCallback<Float> createPingCallBack() {
        return new AsyncCallback<Float>() {
            @Override
            public void onFailure(Throwable throwable) {
                if (throwable instanceof PingTimeOutException) {
                    view.timeout();
                }
                else {
                    Window.alert("Server error");
                }
            }

            @Override
            public void onSuccess(Float time) {
                view.setTime(time);
            }
        };
    }

    private Timer createPingTimer() {
        return new Timer() {
            @Override
            public void run() {
                pingAction.execute();
            }
        };
    }
}
