package realdb;

import java.lang.reflect.Field;

public abstract class RealDbData {
    private String mrid;

    public int getFieldCount()
    {
        int count = RealDbData.class.getDeclaredFields().length;
        return count;
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }
}
