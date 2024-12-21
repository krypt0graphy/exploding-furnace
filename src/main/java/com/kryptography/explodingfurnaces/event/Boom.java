package com.kryptography.explodingfurnaces.event;


import com.kryptography.explodingfurnaces.ExplodingFurnaces;
import com.kryptography.explodingfurnaces.registry.ItemInit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

@Mod.EventBusSubscriber(modid = ExplodingFurnaces.MODID)
public class Boom {

    @SubscribeEvent
    public static void checkGunpowder (TickEvent.PlayerTickEvent event){
        if(event.player instanceof Player){
            Level level = event.player.level();
            Player player =  event.player;
            IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
            for (int i = 0; i < inventory.getSlots(); i++)
                if(inventory.getStackInSlot(i).getItem() == ItemInit.HOT_GUNPOWDER.get()) {
                    inventory.extractItem(i, inventory.getSlotLimit(i), false);
                    level.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
                }
        }
    }

    }

