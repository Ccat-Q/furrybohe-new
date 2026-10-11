package com.bulefire.furrybohe.module.villager.furtrader.trade;

import com.bulefire.furrybohe.common.registry.FurryBoHeItemsRegister;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FurTraderTrades {
    public static void registerFurTraderTrade(@NotNull Int2ObjectMap<List<VillagerTrades.ItemListing>> trades) {
        trades.get(1).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.LEATHER, 4),
                new ItemStack(Items.EMERALD, 1),
                10,
                2,
                0.05F
        ));
        
        trades.get(1).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(FurryBoHeItemsRegister.COTTON_SEEDS_REGISTER.get(), 5),
                10,
                2,
                0.05F
        ));
        
        trades.get(1).add(new VillagerTrades.ItemListing() {
            @Override
            public @NotNull MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource rand) {
                DyeColor[] colors = DyeColor.values();
                DyeColor randomColor = colors[rand.nextInt(colors.length)];
                ItemStack dyeStack = new ItemStack(DyeItem.byColor(randomColor), 2);
                
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        dyeStack,
                        16,
                        2,
                        0.05f
                );
            }
        });
        
        trades.get(1).add((trader, rand) -> new MerchantOffer(
                new ItemStack(FurryBoHeItemsRegister.RESIN_FRAGMENT_REGISTER.get(), 12),
                new ItemStack(Items.EMERALD, 1),
                10,
                2,
                0.05F
        ));
        
        trades.get(2).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 8),
                new ItemStack(Items.LEATHER, 3),
                10,
                2,
                0.05F
        ));
        
        trades.get(2).add((trader, rand) -> new MerchantOffer(
                new ItemStack(FurryBoHeItemsRegister.COTTON_REGISTER.get(), 13),
                new ItemStack(Items.EMERALD, 1),
                10,
                2,
                0.05F
        ));
        
        trades.get(2).add(new VillagerTrades.ItemListing() {
            @Override
            public @NotNull MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource rand) {
                DyeColor[] colors = DyeColor.values();
                DyeColor randomColor = colors[rand.nextInt(colors.length)];
                ItemStack dyeStack = new ItemStack(DyeItem.byColor(randomColor), 5);
                
                return new MerchantOffer(
                        dyeStack,
                        new ItemStack(Items.EMERALD, 1),
                        16,
                        2,
                        0.05f
                );
            }
        });
        
        trades.get(2).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 7),
                new ItemStack(FurryBoHeItemsRegister.RESIN_REGISTER.get(), 2),
                10,
                2,
                0.05F
        ));
        
        trades.get(3).add(new VillagerTrades.ItemListing() {
            @Override
            public @NotNull MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource rand) {
                ItemStack furStack = new ItemStack(FurryBoHeItemsRegister.COLOR_FUR_REGISTER.get(DyeColor.WHITE.getName()).get(), 5);
                int damage = rand.nextIntBetweenInclusive(10, 50);
                furStack.setDamageValue(damage);
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, 41),
                        furStack,
                        10,
                        2,
                        0.05F
                );
            }
        });
        
        trades.get(3).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.WHITE_WOOL, 11),
                new ItemStack(Items.EMERALD, 3),
                10,
                2,
                0.05F
        ));
        
        trades.get(3).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 15),
                new ItemStack(FurryBoHeItemsRegister.SHAPE_RESIN_REGISTER.get(), 2),
                10,
                2,
                0.05F
        ));
        
        trades.get(3).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 19),
                new ItemStack(FurryBoHeItemsRegister.RESIN_COLLECTOR_REGISTER.get(), 1),
                10,
                2,
                0.05F
        ));
        
        trades.get(4).add(new VillagerTrades.ItemListing() {
            @Override
            public @NotNull MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource rand) {
                DyeColor[] colors = DyeColor.values();
                DyeColor randomColor = colors[rand.nextInt(colors.length)];
                ItemStack dyeStack = new ItemStack(DyeItem.byColor(randomColor), 1);
                ItemStack furStack = new ItemStack(FurryBoHeItemsRegister.COLOR_FUR_REGISTER.get(randomColor.getName()).get(), 1);
                
                int damage = rand.nextIntBetweenInclusive(20, 60);
                furStack.setDamageValue(damage);
                
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, 60),
                        dyeStack,
                        furStack,
                        10,
                        2,
                        0.05F
                );
            }
        });
        
        trades.get(4).add(new VillagerTrades.ItemListing() {
            @Override
            public @NotNull MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource rand) {
                DyeColor[] colors = DyeColor.values();
                DyeColor randomColor = colors[rand.nextInt(colors.length)];
                ItemStack furStack = new ItemStack(FurryBoHeItemsRegister.COLOR_FUR_REGISTER.get(randomColor.getName()).get(), 1);
                
                return new MerchantOffer(
                        new ItemStack(Items.EMERALD, 64),
                        new ItemStack(Items.EMERALD, 52),
                        furStack,
                        10,
                        2,
                        0.05F
                );
            }
        });
    }
}
