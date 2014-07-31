package pro.kornev.kcar.server.rpc;

import pro.kornev.kcar.client.rpc.RpcService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
  
  public String testCallServer(String input) throws IllegalArgumentException {
    return input + " server call works";
  }

}
