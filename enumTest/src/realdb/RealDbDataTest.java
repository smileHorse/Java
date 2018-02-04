package realdb;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RealDbDataTest {

    public static void main(String[] args)
    {
        RealDbDataTest test = new RealDbDataTest();
        LineData lineData = new LineData();

        if (test.readFromFastdb(lineData)) {
            System.out.println("--- read successed!!!---");
        }
        else {
            System.out.println("--- read failed!!!---");
        }

        if (test.writeIntoFastdb(lineData)) {
            System.out.println("--- write successed!!!---");
        }
        else {
            System.out.println("--- write failed!!!---");
        }
    }

    private boolean readFromFastdb(LineData lineData)
    {
        List<String> values = new ArrayList<>();
        values.add("guid");
        values.add("Line");
        values.add("Substation");
        values.add("3636");

        boolean result = RealDbDataHelper.setDataValues(lineData, values);
        if (result) {
            System.out.println(lineData.getMrid() + ";" + lineData.getPsrType() + ";"
            + lineData.getEc_type() + ";" + lineData.getEc_rid());
        }
        return result;
    }

    private boolean writeIntoFastdb(LineData lineData)
    {
        List<String> values = new ArrayList<>();
        boolean result = RealDbDataHelper.getDataValues(lineData, values);
        if (result) {
            System.out.println(values.toString());
        }
        return result;
    }
}
