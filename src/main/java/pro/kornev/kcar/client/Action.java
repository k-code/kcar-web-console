package pro.kornev.kcar.client;

/**
 * Action interface. To do some client action Presenter should create the Action and set their to View. And View should
 * do Action.execute() in method with annotation @UiHandler. Usually in Action.execute() method should be called one of
 * RPC method. So async callback should be implemented in Presenter
 */
public interface Action {
    void execute();
}
