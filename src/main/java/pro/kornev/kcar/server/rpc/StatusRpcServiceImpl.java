package pro.kornev.kcar.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import pro.kornev.kcar.client.status.rpc.StatusRpcService;

import java.util.Random;

/**
 * Status RPC service implementation
 */
@SuppressWarnings("serial")
public class StatusRpcServiceImpl extends RemoteServiceServlet implements StatusRpcService {

    @Override
    public boolean ping() {
        Random random = new Random();
        return random.nextFloat() < 0.5f;
    }
}
