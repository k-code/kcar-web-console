package pro.kornev.kcar.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import pro.kornev.kcar.client.widgets.status.rpc.StatusRpcService;
import pro.kornev.kcar.shared.widgets.status.Power;
import pro.kornev.kcar.shared.widgets.status.exception.PingTimeOutException;

import java.util.Random;

/**
 * Status RPC service implementation
 */
@SuppressWarnings("serial")
public class StatusRpcServiceImpl extends RemoteServiceServlet implements StatusRpcService {
    private final Random random = new Random();

    @Override
    public float ping() throws PingTimeOutException {
        float pingTime = random.nextFloat();
        if (pingTime < 0.9f) {
            return pingTime;
        }
        throw new PingTimeOutException();
    }

    @Override
    public Power getPower() {
        Power power = new Power();
        power.setVolts(random.nextFloat()*10);
        power.setAmperes(random.nextFloat());
        return power;
    }
}
