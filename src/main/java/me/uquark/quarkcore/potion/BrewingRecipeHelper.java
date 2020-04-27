package me.uquark.quarkcore.potion;

import me.uquark.quarkcore.reflect.ReflectionHelper;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;

import java.lang.reflect.Method;

public class BrewingRecipeHelper {
    private static Method registerPotionRecipeMethod = null;
    private static Method registerPotionTypeMethod = null;

    static {
        initialize();
    }

    public static void initialize() {
        registerPotionRecipeMethod = ReflectionHelper.resolveMethod(
            BrewingRecipeRegistry.class,
            "registerPotionRecipe",
            "method_8074",
            Potion.class,
            Item.class,
            Potion.class
        );
        registerPotionTypeMethod = ReflectionHelper.resolveMethod(
            BrewingRecipeRegistry.class,
            "registerPotionType",
            "method_8080",
            Item.class
        );
    }

    public static boolean registerPotionRecipe(Potion input, Item item, Potion output) {
        if (registerPotionRecipeMethod == null)
            return false;
        try {
            registerPotionRecipeMethod.invoke(null, input, item, output);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean registerPotionType(Item item) {
        if (registerPotionTypeMethod == null)
            return false;
        try {
            registerPotionTypeMethod.invoke(null, item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
