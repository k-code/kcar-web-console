package pro.kornev.kcar.client.widgets.status.power;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.Presenter;
import pro.kornev.kcar.client.View;
import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcService;
import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcServiceAsync;
import pro.kornev.kcar.shared.Power;

/**
 * Power presenter
 */
public class PowerPresenter implements Presenter {

    interface Display extends View {
        void update(float volts, float amperes);
    }

    private final StatusRpcServiceAsync rpcService;
    private final Display view;

    private HasWidgets container;
    private Timer powerUpdater;

    public PowerPresenter() {
        rpcService = GWT.create(StatusRpcService.class);
        view = new PowerView();
        powerUpdater = createPowerTimer();
    }

    @Override
    public void go(HasWidgets container) {
        hide();
        this.container = container;
        container.clear();
        container.add(view.asWidget());
        powerUpdater.scheduleRepeating(1000);
    }

    @Override
    public void hide() {
        if (powerUpdater.isRunning()) {
            powerUpdater.cancel();
        }
        if (container != null) {
            container.clear();
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
