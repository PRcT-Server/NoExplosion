package me.linstar.noexplosion;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod("noexplosion")
public class NoExplosion {
    public NoExplosion() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
