package pro.kornev.kcar.client.widgets.status.power;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Power status view
 */
public class PowerView extends Composite implements PowerPresenter.Display {

    @UiTemplate("PowerView.ui.xml")
    interface ThisUiBinder extends UiBinder<Widget, PowerView> {}
    private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

    @UiField TextBox voltsHolder;
    @UiField TextBox amperesHolder;

    private final NumberFormat fmt;

    public PowerView() {
        initWidget(uiBinder.createAndBindUi(this));
        fmt = NumberFormat.getDecimalFormat();
        fmt.overrideFractionDigits(3);

        update(0f, 0f);
    }

    @Override
    public void update(float volts, float amperes) {
        voltsHolder.setText(fmt.format(volts));
        amperesHolder.setText(fmt.format(amperes));
    }

}
