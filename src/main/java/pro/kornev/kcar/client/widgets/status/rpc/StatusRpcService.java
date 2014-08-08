package pro.kornev.kcar.client.widgets.status.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pro.kornev.kcar.shared.Power;

/**
 * Status RPC service interface
 */
@RemoteServiceRelativePath("statusRpcService")
public interface StatusRpcService extends RemoteService {
    boolean ping();
    Power getPower();
}
