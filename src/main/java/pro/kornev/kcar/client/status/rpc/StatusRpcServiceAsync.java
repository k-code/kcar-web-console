package pro.kornev.kcar.client.status.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Status RPC Async service
 */
public interface StatusRpcServiceAsync {
    void ping(AsyncCallback<Boolean> callback);
}
