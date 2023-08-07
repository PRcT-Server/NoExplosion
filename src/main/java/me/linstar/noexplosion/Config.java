package me.linstar.noexplosion;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.ConfigValue<List<String>> BLACK_LIST;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("general");
        BLACK_LIST = builder.define("black_list", new ArrayList<>());
        builder.pop();
        CONFIG = builder.build();
    }
}
