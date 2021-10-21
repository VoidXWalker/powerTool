package com.voidxwalker.powertool;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
    public static Item POWER_TOOL;

    @Override
    public void onInitialize() {
        Item.Settings s = (new Item.Settings()).group(ItemGroup.TOOLS).fireproof();
        s.maxDamage(1000000000);
        POWER_TOOL= new SwordItem(ToolMaterials.NETHERITE, 5, -2.0F,s);
        Registry.register(Registry.ITEM, new Identifier("wooden_hoe"), POWER_TOOL);
    }
}
