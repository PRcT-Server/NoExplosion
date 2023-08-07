package me.linstar.noexplosion.mixin;

import me.linstar.noexplosion.Config;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(Explosion.class)
public abstract class ExplosionMixin {
    @Shadow @Final @Nullable private Entity source;

    @Mutable
    @Shadow @Final private Explosion.BlockInteraction blockInteraction;

    @Shadow public abstract void clearToBlow();

    @Inject(method = "explode", at=@At("HEAD"))
    public void explode(CallbackInfo ci){
        if (source == null){
            return;
        }
        String id = source.getEncodeId();
        if (Config.BLACK_LIST.get().contains(id)){
            blockInteraction = Explosion.BlockInteraction.NONE;
        }
    }

    @Inject(method = "finalizeExplosion", at = @At("TAIL"))
    public void finalizeExplosion(boolean p_46076_, CallbackInfo ci){
        if (source == null){
            return;
        }
        String id = source.getEncodeId();
        if (Config.BLACK_LIST.get().contains(id)){
            clearToBlow();
        }
    }
}
