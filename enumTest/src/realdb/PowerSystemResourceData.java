package realdb;

import java.lang.reflect.Field;

public class PowerSystemResourceData extends RealDbData {

    private String psrType;

    @Override
    public int getFieldCount() {
        int count = PowerSystemResourceData.class.getDeclaredFields().length;
        return super.getFieldCount() + count;
    }

    public void setValues(String[] values) throws IllegalAccessException
    {
        if (values.length != getFieldCount()) {
            System.out.println("values.length: " + values.length
                    + "!= getFieldCount()" + getFieldCount());
            return;
        }

        super.setValues(values);
//        int parentFieldCount = RealDbData.class.getSuperclass().getFieldCount();
//        Field[] fields = getClass().getDeclaredFields();
//        int index = 0;
//        for (Field field : fields) {
//            field.set(this, values[parentFieldCount + (index++)]);
//        }
    }

    public String getPsrType() {
        return psrType;
    }

    public void setPsrType(String psrType) {
        this.psrType = psrType;
    }
}
