package me.uquark.quarkcore.reflect;

import me.uquark.quarkcore.QuarkCore;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionHelper {
    public static Field resolveField(Class<?> clazz, String yarn, String obfuscated) {
        boolean found = false;
        Field field = null;

        try {
            field = clazz.getDeclaredField(obfuscated);
            found = true;
        } catch (NoSuchFieldException ignored) {}
        if (found) {
            field.setAccessible(true);
            return field;
        }
        else
            QuarkCore.LOGGER.warn(obfuscated + " not found. Are we in debug environment?");

        try {
            field = clazz.getDeclaredField(yarn);
            found = true;
        } catch (NoSuchFieldException ignored) {}
        if (found)
            field.setAccessible(true);
        else
            QuarkCore.LOGGER.error(yarn + " not found");

        return field;
    }

    public static Method resolveMethod(Class<?> clazz, String yarn, String obfuscated, Class<?>... args) {
        boolean found = false;
        Method method = null;

        try {
            method = clazz.getDeclaredMethod(obfuscated, args);
            found = true;
        } catch (NoSuchMethodException ignored) {}
        if (found) {
            method.setAccessible(true);
            return method;
        }
        else
            QuarkCore.LOGGER.warn(obfuscated + " not found. Are we in debug environment?");

        try {
            method = clazz.getDeclaredMethod(yarn, args);
            found = true;
        } catch (NoSuchMethodException ignored) {}
        if (found)
            method.setAccessible(true);
        else
            QuarkCore.LOGGER.error(yarn + " not found");

        return method;
    }

    public static void setFinal(Object target, Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(target, newValue);
    }
}
