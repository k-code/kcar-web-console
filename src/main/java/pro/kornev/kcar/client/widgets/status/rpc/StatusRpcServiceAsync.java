package pro.kornev.kcar.client.widgets.status.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pro.kornev.kcar.shared.widgets.status.Power;

/**
 * Status RPC Async service
 */
public interface StatusRpcServiceAsync {
    void ping(AsyncCallback<Float> callback);
    void getPower(AsyncCallback<Power> callback);
}
