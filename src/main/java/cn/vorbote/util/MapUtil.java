package cn.vorbote.util;

// import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * This util class can be used for automatic conversion
 * between dictionaries/maps and objects
 * @author vorbote
 * @since 0.0.1.PRE
 */
// @Slf4j
public class MapUtil {

    private static final String DT_SHORT = "short";
    private static final String DT_INT = "int";
    private static final String DT_LONG = "long";
    private static final String DT_BYTE = "byte";
    private static final String DT_CHAR = "char";
    private static final String DT_BOOL = "boolean";
    private static final String DT_FLOAT = "float";
    private static final String DT_DOUBLE = "double";
    
    private static final String CLASS_STRING = "class java.lang.String";
    private static final String CLASS_BIG_DECIMAL = "class java.math.BigDecimal";
    private static final String CLASS_DATE = "class java.util.Date";
    private static final String CLASS_INTEGER = "class java.lang.Integer";
    private static final String CLASS_SHORT = "class java.lang.Short";
    private static final String CLASS_LONG = "class java.lang.Long";
    private static final String CLASS_BYTE = "class java.lang.Byte";
    private static final String CLASS_CHAR = "class java.lang.Character";
    private static final String CLASS_FLOAT = "class java.lang.Float";
    private static final String CLASS_DOUBLE = "class java.lang.Double";
    private static final String CLASS_BOOL = "class java.lang.Boolean";


    /**
     * Dynamically convert object to dictionary/map
     * @param obj Objects that need to be converted to Map
     * @return Converted HashMap
     * @throws Exception Any Exception could be generated while converting
     */
    public static Map<String, Object> SetMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.get(obj) != null) {
                map.put(field.getName(), field.get(obj));
            }
        }

        return map;
    }

    /**
     * Convert Map to Object
     * @param map Map data to be convert
     * @param obj Target object should be explicitly given to a special
     *            instantiated object
     */
    public static void SetObject(Map<String, Object> map, Object obj) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String entryValue = entry.getValue().toString();
                    // 根据字段名获取字段
                    Field field = obj.getClass().getDeclaredField(entry.getKey());

                    // 判断类中对应字段的Class
                    switch (field.getGenericType().toString()) {
                        case DT_SHORT:
                        case CLASS_SHORT:
                            entry.setValue(Short.parseShort(entryValue));
                            break;
                        case DT_INT:
                        case CLASS_INTEGER:
                            entry.setValue(Integer.parseInt(entryValue));
                            break;
                        case DT_LONG:
                        case CLASS_LONG:
                            entry.setValue(Long.parseLong(entryValue));
                            break;
                        case DT_FLOAT:
                        case CLASS_FLOAT:
                            entry.setValue(Float.parseFloat(entryValue));
                            break;
                        case DT_DOUBLE:
                        case CLASS_DOUBLE:
                            entry.setValue(Double.parseDouble(entryValue));
                            break;
                        case DT_CHAR:
                        case CLASS_CHAR:
                            entry.setValue(entryValue.charAt(0));
                            break;
                        case DT_BYTE:
                        case CLASS_BYTE:
                            entry.setValue(Byte.parseByte(entryValue));
                            break;
                        case DT_BOOL:
                        case CLASS_BOOL:
                            entry.setValue(Boolean.parseBoolean(entryValue));
                            break;
                        case CLASS_STRING:
                            entry.setValue(entryValue);
                            break;
                        case CLASS_BIG_DECIMAL:
                            entry.setValue(BigDecimal.valueOf(Double.parseDouble(entryValue)));
                            break;
                        case CLASS_DATE:
                            entry.setValue(DateUtil.TimestampToDate(entryValue));
                            break;


                        default:
                            // log.error("暂时不支持此类型！");
                    }

                    // 设置值
                    SetFieldValue(entry.getKey(), obj, entry.getValue());
                } catch (Exception e) {
                    // logger.warn("hash to object fail", e);
                    System.err.println("hash to object fail");
                    // log.error("Hash to Object failure, cause: " + e.getCause());
                }
            }
        }
    }


    /**
     * Get the specified field value, equivalent to
     * <code>obj.getFieldName</code>
     * @param fieldName Field name
     * @param obj object
     * @return A string of the object corresponding
     *  to the object value
     * @throws Exception Abnormalities that may appear, such as
     *  <code>java.lang.NullPointerException</code>, etc.
     */
    public static String GetFieldValue(String fieldName, Object obj) throws Exception {
        try {
            String methodName = getMethodName("get", fieldName);
            Method method = getDeclaredMethod(obj, methodName);
            if (method != null) {
                method.setAccessible(true);
                return defaultObject(method.invoke(obj));
            }
        } catch (Exception ex) {
            // log.error("获取对象失败: {}", ex.getLocalizedMessage());
            throw new Exception("获取对象值失败!");
        }
        return "";
    }


    /**
     * Set the specified field value, which is equivalent to
     * <code>obj.setFieldName(fieldValue)</code>
     * @param fieldName Field name
     * @param obj The object will be set
     * @param fieldValue Field Value
     * @throws Exception Any Exception could be generated while converting
     */
    public static void SetFieldValue(String fieldName, Object obj, Object fieldValue) throws Exception {
        try {
            String methodName = getMethodName("set", fieldName);
            Method method = getDeclaredMethod(obj, methodName, fieldValue.getClass());
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, fieldValue);
            }
        } catch (Exception ex) {
            // log.error("设置对象值失败:{}", ex.getCause().toString());
            throw new Exception("设置对象值失败!");
        }
    }

    /**
     * 获取方法名称
     * @param prefix 方法名前缀
     * @param fieldName 字段名
     */
    private static String getMethodName(String prefix, String fieldName) {
        return prefix + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }


    /**
     * 根据对象、方法名与参数类型查找方法
     * @param object 对象
     * @param methodName 方法名
     * @param parameterTypes 参数类型
     */
    private static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        Method method;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception ignored) { }
        }
        return null;
    }

    /**
     * 设置默认值
     */
    private static String defaultObject(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return String.valueOf(obj);
        }
    }
}
