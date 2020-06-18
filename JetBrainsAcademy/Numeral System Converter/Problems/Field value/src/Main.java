import java.lang.reflect.Field;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        for (Field field : object.getClass().getFields()) {
            if (field.getName().equals(fieldName)) {
                return field.get(object);
            }
        }
        return null;
    }
}