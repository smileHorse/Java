package realdb;

import java.lang.reflect.*;

public class LineData extends PowerSystemResourceData {

    private String ec_type;
    private String ec_rid;

    @Override
    public int getFieldCount() {
        int count = LineData.class.getDeclaredFields().length;
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
        int parentFieldCount = super.getFieldCount();
        Field[] fields = LineData.class.getDeclaredFields();
        int index = 0;
        for (Field field : fields) {
            field.set(this, values[parentFieldCount + (index++)]);
        }
    }

    public String getEc_type() {
        return ec_type;
    }

    public void setEc_type(String ec_type) {
        this.ec_type = ec_type;
    }

    public String getEc_rid() {
        return ec_rid;
    }

    public void setEc_rid(String ec_rid) {
        this.ec_rid = ec_rid;
    }
}
