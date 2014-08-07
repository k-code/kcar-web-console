package pro.kornev.kcar.client.status.power;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import pro.kornev.kcar.client.View;
import pro.kornev.kcar.client.status.rpc.StatusRpcService;
import pro.kornev.kcar.client.status.rpc.StatusRpcServiceAsync;
import pro.kornev.kcar.shared.Power;

/**
 * Power presenter
 */
public class PowerPresenter implements View.Presenter {

    private final StatusRpcServiceAsync rpcService;

    private final PowerView view;

    public PowerPresenter() {
        rpcService = GWT.create(StatusRpcService.class);
        view = new PowerView();
        view.setPresenter(this);
    }

    @Override
    public void go(HasWidgets container) {
        container.add(view.asWidget());
        //powerUpdater.scheduleRepeating(1000);
    }

    private Timer powerUpdater = new Timer() {
        @Override
        public void run() {
            rpcService.getPower(callback);
        }
    };

    AsyncCallback<Power> callback = new AsyncCallback<Power>() {
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
