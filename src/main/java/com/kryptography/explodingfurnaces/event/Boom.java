package com.kryptography.explodingfurnaces.event;


import com.kryptography.explodingfurnaces.ExplodingFurnaces;
import com.kryptography.explodingfurnaces.registry.ItemInit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.PlayerMainInvWrapper;


@EventBusSubscriber(modid = ExplodingFurnaces.MODID)
public class Boom {

    @SubscribeEvent
    public static void checkGunpowder (PlayerTickEvent.Post event){
        if(event.getEntity() instanceof Player){
            Level level = event.getEntity().level();
            Player player =  event.getEntity();
            IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
            for (int i = 0; i < inventory.getSlots(); i++)
                if(inventory.getStackInSlot(i).getItem() == ItemInit.HOT_GUNPOWDER.get()) {
                    inventory.extractItem(i, inventory.getSlotLimit(i), false);
                    level.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
                }
        }
    }

    }

