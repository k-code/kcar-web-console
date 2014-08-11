package pro.kornev.kcar.client.base;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is template for view. It is exists for copy-paste new view object
 * because I can't make base abstract class for view.
 */
public class BaseView extends Composite {

    interface ThisUiBinder extends UiBinder<Widget, BaseView> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);


    public BaseView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
