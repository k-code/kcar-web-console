package pro.kornev.kcar.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import pro.kornev.kcar.client.status.rpc.StatusRpcService;
import pro.kornev.kcar.shared.Power;

import java.util.Random;

/**
 * Status RPC service implementation
 */
@SuppressWarnings("serial")
public class StatusRpcServiceImpl extends RemoteServiceServlet implements StatusRpcService {
    private final Random random = new Random();

    @Override
    public boolean ping() {
        return random.nextFloat() < 0.5f;
    }

    @Override
    public Power getPower() {
        Power power = new Power();
        power.setVolts(random.nextFloat()*10);
        power.setAmperes(random.nextFloat());
        return power;
    }
}
