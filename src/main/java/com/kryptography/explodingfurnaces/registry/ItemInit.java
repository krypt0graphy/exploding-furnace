package com.kryptography.explodingfurnaces.registry;

import com.kryptography.explodingfurnaces.ExplodingFurnaces;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ItemInit {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplodingFurnaces.MODID);

        public static final DeferredItem<Item> HOT_GUNPOWDER = ITEMS.register("hot_gunpowder", () -> new Item(new Item.Properties().stacksTo(64)));
}
