import java.util.Arrays;

/**
 * Check whether the class declares public parameterless constructor
 */
class ConstructorChecker {

    public boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        long count = Arrays.stream(clazz.getConstructors())
                .filter(c -> c.getParameterCount() == 0)
                .count();
        return count > 0;
    }

}
