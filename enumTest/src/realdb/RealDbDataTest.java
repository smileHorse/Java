package realdb;

import java.lang.reflect.Field;
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
        String[] values = { "guid", "Line", "Substation", "3636" };

        try {
            setValue(lineData);
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }

        System.out.println(lineData.toString());

        return false;
    }

    private boolean writeIntoFastdb(LineData lineData)
    {

        return false;
    }

    private void setValue(Object object) throws IllegalAccessException
    {
        Stack<Class<?>> classStack = new Stack<>();
        Class currClass = object.getClass();
        if (currClass == null) {
            return;
        }
        classStack.push(currClass);

        Class parentClass = currClass.getSuperclass();
        while (parentClass != null
                && !parentClass.getName().equals("java.lang.Object"))
        {
            classStack.push(parentClass);
            parentClass = parentClass.getSuperclass();
        }

        while (!classStack.isEmpty()) {
            Class current = classStack.pop();
            Field[] fields = current.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
                field.set(object, "11");
            }
        }
    }
}
