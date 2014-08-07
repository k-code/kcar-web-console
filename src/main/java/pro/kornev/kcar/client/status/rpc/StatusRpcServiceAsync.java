package pro.kornev.kcar.client.status.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pro.kornev.kcar.shared.Power;

/**
 * Status RPC Async service
 */
public interface StatusRpcServiceAsync {
    void ping(AsyncCallback<Boolean> callback);
    void getPower(AsyncCallback<Power> callback);
}
