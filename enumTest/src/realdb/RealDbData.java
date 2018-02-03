package realdb;

import java.lang.reflect.Field;

public abstract class RealDbData {
    private String mrid;

    public int getFieldCount()
    {
        int count = RealDbData.class.getDeclaredFields().length;
        return count;
    }

    public void setValues(String[] values) throws IllegalAccessException
    {
        if (values.length != getFieldCount()) {
            System.out.println("values.length: " + values.length
                    + "!= getFieldCount()" + getFieldCount());
            return;
        }

        Field[] fields = RealDbData.class.getDeclaredFields();
        int index = 0;
        for (Field field : fields) {
            field.set(this, values[index++]);
        }
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }
}
