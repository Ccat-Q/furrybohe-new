package com.bulefire.furrybohe.common.registry;

import com.bulefire.furrybohe.FurryBoHe;
import com.bulefire.furrybohe.module.material.furcraftingtable.recipe.FurRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FurryBoHeRecipeSerializerRegister {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FurryBoHe.MODID);
    
    public static final RegistryObject<RecipeSerializer<FurRecipe>> FUR_RECIPE_SERIALIZER =
            RECIPE_SERIALIZERS_REGISTER.register("fur_recipe", FurRecipe.Serializer::new);
}
