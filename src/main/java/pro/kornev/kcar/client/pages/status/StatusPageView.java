package pro.kornev.kcar.client.pages.status;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * Status page view
 */
public class StatusPageView extends Composite implements StatusPagePresenter.Display {

    interface ThisUiBinder extends UiBinder<Widget, StatusPageView> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField FlowPanel pingPanel;
    @UiField FlowPanel powerPanel;

    public StatusPageView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public HasWidgets getPingPanel() {
        return pingPanel;
    }

    @Override
    public HasWidgets getPowerPanel() {
        return powerPanel;
    }
}
