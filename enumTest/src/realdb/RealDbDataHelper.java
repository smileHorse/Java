package realdb;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Stack;

public class RealDbDataHelper {

    /**
     * 设置实时库对象的字段值
     * @param data 实时库对象
     * @param values 字段值集合
     * @return true: 设置成功 false: 设置失败
     */
    public static boolean setDataValues(RealDbData data, List<String> values)
    {
        if (values.size() != data.getFieldCount()) {
            return false;
        }

        // 获取data的继承结构
        Stack<Class> classStack = new Stack<>();
        getParentClasses(data, classStack);

        // 设置data的字段值
        int index = 0;
        while (!classStack.isEmpty()) {
            Class current = classStack.pop();
            Field[] fields = current.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            try {
                for (Field field : fields) {
                    field.set(data, values.get(index++));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public static boolean getDataValues(RealDbData data, List<String> values)
    {
        // 获取data的继承结构
        Stack<Class> classStack = new Stack<>();
        getParentClasses(data, classStack);

        // 设置data的字段值
        int index = 0;
        while (!classStack.isEmpty()) {
            Class current = classStack.pop();
            Field[] fields = current.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            try {
                for (Field field : fields) {
                    values.add(field.get(data).toString());
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    /**
     * 获取实时库对象的继承层次
     * @param data 实时库对象
     * @param parentes 自身类及其父类的堆栈
     */
    private static void getParentClasses(RealDbData data, Stack<Class> parentes) {
        // 获取data的继承结构
        Class currClass = data.getClass();
        parentes.push(currClass);

        Class parentClass = currClass.getSuperclass();
        while (parentClass != null
                && !parentClass.getName().equals("java.lang.Object"))
        {
            parentes.push(parentClass);
            parentClass = parentClass.getSuperclass();
        }
    }
}
