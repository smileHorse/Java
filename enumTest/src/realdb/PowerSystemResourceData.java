package realdb;

import java.lang.reflect.Field;

public class PowerSystemResourceData extends RealDbData {

    private String psrType;

    @Override
    public int getFieldCount() {
        int count = PowerSystemResourceData.class.getDeclaredFields().length;
        return super.getFieldCount() + count;
    }

    public String getPsrType() {
        return psrType;
    }

    public void setPsrType(String psrType) {
        this.psrType = psrType;
    }
}
