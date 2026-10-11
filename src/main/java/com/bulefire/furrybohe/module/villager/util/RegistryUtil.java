package com.bulefire.furrybohe.module.villager.util;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 村民交易注册辅助工具。
 * <p>
 * 交易参数（最大使用次数、村民经验、价格浮动）统一在这里维护，避免各交易类硬编码；
 * {@link #offer} 在每次刷新交易时都会复制物品，防止多个村民共用同一个 ItemStack 实例。
 * 需要随刷新变化的交易（随机染料、随机损耗、随机 NBT 等）请自行构造物品后调用
 * {@link #createDefaultOffer}。
 */
public class RegistryUtil {
    /** 默认最大使用次数 */
    public static final int DEFAULT_MAX_USES = 10;
    
    /** 默认村民经验 */
    public static final int DEFAULT_VILLAGER_XP = 2;
    
    /** 默认价格浮动系数 */
    public static final float DEFAULT_PRICE_MULTIPLIER = 0.05F;
    
    /** 单输入交易：input -> output */
    @Contract(pure = true)
    public static VillagerTrades.@NotNull ItemListing offer(@NotNull ItemStack input, @NotNull ItemStack output) {
        return offer(input, output, DEFAULT_MAX_USES);
    }
    
    /** 单输入交易：input -> output，自定义最大使用次数 */
    @Contract(pure = true)
    public static VillagerTrades.@NotNull ItemListing offer(@NotNull ItemStack input, @NotNull ItemStack output, int maxUses) {
        return (trader, rand) -> createDefaultOffer(input.copy(), output.copy(), maxUses);
    }
    
    /** 双输入交易：input + extra -> output */
    @Contract(pure = true)
    public static VillagerTrades.@NotNull ItemListing offer(@NotNull ItemStack input, @NotNull ItemStack extra, @NotNull ItemStack output) {
        return (trader, rand) -> createDefaultOffer(input.copy(), extra.copy(), output.copy());
    }
    
    /** 单输入交易：input -> output */
    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull MerchantOffer createDefaultOffer(@NotNull ItemStack input, @NotNull ItemStack output) {
        return createDefaultOffer(input, output, DEFAULT_MAX_USES, DEFAULT_VILLAGER_XP, DEFAULT_PRICE_MULTIPLIER);
    }
    
    /** 单输入交易：input -> output，自定义最大使用次数 */
    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull MerchantOffer createDefaultOffer(@NotNull ItemStack input, @NotNull ItemStack output, int maxUses) {
        return createDefaultOffer(input, output, maxUses, DEFAULT_VILLAGER_XP, DEFAULT_PRICE_MULTIPLIER);
    }
    
    /** 双输入交易：input + extra -> output */
    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull MerchantOffer createDefaultOffer(@NotNull ItemStack input, @NotNull ItemStack extra, @NotNull ItemStack output) {
        return createDefaultOffer(input, extra, output, DEFAULT_MAX_USES, DEFAULT_VILLAGER_XP, DEFAULT_PRICE_MULTIPLIER);
    }
    
    @Contract(value = "_, _, _, _, _ -> new", pure = true)
    private static @NotNull MerchantOffer createDefaultOffer(@NotNull ItemStack input, @NotNull ItemStack output, int maxUses, int villagerXp, float priceMultiplier) {
        return new MerchantOffer(
                input,
                output,
                maxUses,
                villagerXp,
                priceMultiplier
        );
    }
    
    @Contract(value = "_, _, _, _, _, _ -> new", pure = true)
    private static @NotNull MerchantOffer createDefaultOffer(@NotNull ItemStack input, @NotNull ItemStack extra, @NotNull ItemStack output, int maxUses, int villagerXp, float priceMultiplier) {
        return new MerchantOffer(
                input,
                extra,
                output,
                maxUses,
                villagerXp,
                priceMultiplier
        );
    }
}
