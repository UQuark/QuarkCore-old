package me.uquark.quarkcore.potion;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;

public class BrewingRecipeHelper {
    public static boolean registerPotionRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistry.registerPotionRecipe(input, item, output);
        return true;
    }

    public static boolean registerPotionType(Item item) {
        BrewingRecipeRegistry.registerPotionType(item);
        return true;
    }

    public static boolean registerItemRecipe(Item input, Item ingredient, Item output) {
        BrewingRecipeRegistry.registerItemRecipe(input, ingredient, output);
        return true;
    }
}
