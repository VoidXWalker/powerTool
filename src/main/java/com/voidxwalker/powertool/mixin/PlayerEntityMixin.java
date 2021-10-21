package com.voidxwalker.powertool.mixin;

import com.voidxwalker.powertool.Main;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Shadow @Final public PlayerInventory inventory;

    @Redirect(method = "isUsingEffectiveTool", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isToolRequired()Z"))
    public boolean isUsingEffectiveTool(BlockState instance) {
        if(this.inventory.getMainHandStack().getItem().equals(Main.POWER_TOOL)){
            return false;
        }
        return instance.isToolRequired();
    }
    @Redirect(method = "getBlockBreakingSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerInventory;getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F"))
    public float getBlockBreakingSpeed(PlayerInventory instance, BlockState block) {
        if(this.inventory.getMainHandStack().getItem().equals(Main.POWER_TOOL)){
            return 9.0F;
        }
        return instance.getBlockBreakingSpeed(block);
    }
}
