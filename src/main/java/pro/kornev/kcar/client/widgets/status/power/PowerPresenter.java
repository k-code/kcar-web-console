package pro.kornev.kcar.client.widgets.status.power;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.base.Presenter;
import pro.kornev.kcar.client.base.View;
import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcService;
import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcServiceAsync;
import pro.kornev.kcar.shared.Power;

/**
 * Power presenter
 */
public class PowerPresenter extends Presenter {

    interface Display extends View {
        void update(float volts, float amperes);
    }

    private final StatusRpcServiceAsync rpcService;
    private final Display view;

    private Timer powerUpdater;

    public PowerPresenter() {
        rpcService = GWT.create(StatusRpcService.class);
        view = new PowerView();
        powerUpdater = createPowerTimer();
    }

    @Override
    public void go(HasWidgets container) {
        super.go(container);
        container.add(view.asWidget());
        powerUpdater.scheduleRepeating(1000);
    }

    @Override
    public void hide() {
        super.hide();
        if (powerUpdater.isRunning()) {
            powerUpdater.cancel();
        }
    }

    private AsyncCallback<Power> createPowerCallback() {
        return new AsyncCallback<Power>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Update power was FAILED\n" + caught.getMessage());
            }

            @Override
            public void onSuccess(Power result) {
                view.update(result.getVolts(), result.getAmperes());
            }
        };
    }

    private Timer createPowerTimer() {
        return new Timer() {
            @Override
            public void run() {
                rpcService.getPower(createPowerCallback());
            }
        };
    }
}
