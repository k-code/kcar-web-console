package pro.kornev.kcar.client.status.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Status RPC service interface
 */
@RemoteServiceRelativePath("statusRpcService")
public interface StatusRpcService extends RemoteService {
    boolean ping();
}
