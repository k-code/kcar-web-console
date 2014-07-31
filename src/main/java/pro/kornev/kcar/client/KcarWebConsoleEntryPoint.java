package pro.kornev.kcar.client;


import pro.kornev.kcar.client.rpc.RpcService;
import pro.kornev.kcar.client.rpc.RpcServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class KcarWebConsoleEntryPoint implements EntryPoint {

  /**
   * Sets up RPC
   */
  private final RpcServiceAsync rpcService = GWT.create(RpcService.class);

  @Override
  public void onModuleLoad() {
    RootPanel.get().add(new HTML("GWT App has loaded.<br/>"));
    
    rpcService.testCallServer("Hello...", new AsyncCallback<String>() {
      @Override
      public void onSuccess(String result) {
        RootPanel.get().add(new HTML(result));
      }
      
      @Override
      public void onFailure(Throwable caught) {
        RootPanel.get().add(new HTML("We have a leak Huston!"));
      }
    });
  }
  
}
