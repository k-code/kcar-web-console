package pro.kornev.kcar.client.pages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import pro.kornev.kcar.client.Action;

/**
 * Main page view
 */
public class MainPageView extends Composite implements MainPagePresenter.Display {

    interface ThisUiBinder extends UiBinder<Widget, MainPageView> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField FlowPanel contentPanel;

    private Action showStatusPageAction;
    private Action showVideoPageAction;

    public MainPageView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public HasWidgets getContentPanel() {
        return contentPanel;
    }

    @Override
    public void setStatusButtonAction(Action action) {
        showStatusPageAction = action;
    }

    @Override
    public void setVideoButtonAction(Action action) {
        showVideoPageAction = action;
    }

    @SuppressWarnings("unused")
    @UiHandler("statusButton")
    void onStatusButton(ClickEvent event) {
        showStatusPageAction.execute();
    }

    @SuppressWarnings("unused")
    @UiHandler("videoButton")
    void onVideoButton(ClickEvent event) {
        showVideoPageAction.execute();
    }
}
