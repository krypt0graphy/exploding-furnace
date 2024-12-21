package com.kryptography.explodingfurnaces;


import com.kryptography.explodingfurnaces.registry.ItemInit;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;



@Mod(ExplodingFurnaces.MODID)
public class ExplodingFurnaces {
    public static final String MODID = "explodingfurnaces";

    public ExplodingFurnaces(IEventBus bus) {
        ItemInit.ITEMS.register(bus);
    }
}
