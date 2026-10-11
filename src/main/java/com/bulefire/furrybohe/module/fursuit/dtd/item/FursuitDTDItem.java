package com.bulefire.furrybohe.module.fursuit.dtd.item;

import com.bulefire.furrybohe.FurryBoHe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FursuitDTDItem extends Item {
    public static final String SHAPED_KEY = FurryBoHe.MODID + ":shaped";
    
    public FursuitDTDItem(Properties properties) {
        super(properties);
    }
    
    public static boolean isShaped(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null && tag.getBoolean(SHAPED_KEY);
    }
    
    public static void setShaped(@NotNull ItemStack stack, boolean shaped) {
        if (shaped) {
            stack.getOrCreateTag().putBoolean(SHAPED_KEY, true);
            return;
        }
        
        CompoundTag tag = stack.getTag();
        if (tag == null) {
            return;
        }
        tag.remove(SHAPED_KEY);
        if (tag.isEmpty()) {
            stack.setTag(null);
        }
    }
    
    @Override
    public @NotNull String getDescriptionId(@NotNull ItemStack stack) {
        return getDescriptionId() + (isShaped(stack) ? "_shaped" : "_unshaped");
    }
}
