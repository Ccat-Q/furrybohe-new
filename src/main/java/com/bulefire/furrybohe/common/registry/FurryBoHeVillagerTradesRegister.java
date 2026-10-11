package com.bulefire.furrybohe.common.registry;

import com.bulefire.furrybohe.FurryBoHe;
import com.bulefire.furrybohe.module.villager.fursuitmaker.trade.FursuitMakerTrades;
import com.bulefire.furrybohe.module.villager.furtrader.trade.FurTraderTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=FurryBoHe.MODID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class FurryBoHeVillagerTradesRegister {
    
    @SubscribeEvent
    public static void registerVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == FurryBoHeVillagerProfessionRegister.FURSUIT_MAKER_PROFESSION_REGISTER.get())
            FursuitMakerTrades.registerFursuitMakerTrade(event.getTrades());
        else if (event.getType() == FurryBoHeVillagerProfessionRegister.FUR_TRADER_PROFESSION_REGISTER.get())
            FurTraderTrades.registerFurTraderTrade(event.getTrades());
    }
}
