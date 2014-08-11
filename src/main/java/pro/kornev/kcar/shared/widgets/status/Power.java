package pro.kornev.kcar.shared.widgets.status;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Power data
 */
public class Power implements IsSerializable {
    private float volts;
    private float amperes;

    public Power() {
        volts = 0;
        amperes = 0;
    }

    public float getVolts() {
        return volts;
    }

    public void setVolts(float volts) {
        this.volts = volts;
    }

    public float getAmperes() {
        return amperes;
    }

    public void setAmperes(float amperes) {
        this.amperes = amperes;
    }
}
