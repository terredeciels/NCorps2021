package jvm.BigDec;

import java.math.BigDecimal;

public class Corps {


    private BigDecimal[] param = new BigDecimal[6];

    public Corps(BigDecimal[] param) {
        this.param = param;
    }

    public BigDecimal[] getParam() {
        return param;
    }
}

