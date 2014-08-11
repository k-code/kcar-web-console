package pro.kornev.kcar.client.widgets.status.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pro.kornev.kcar.shared.widgets.status.Power;
import pro.kornev.kcar.shared.widgets.status.exception.PingTimeOutException;

/**
 * Status RPC service interface
 */
@RemoteServiceRelativePath("statusRpcService")
public interface StatusRpcService extends RemoteService {
    float ping() throws PingTimeOutException;
    Power getPower();
}
