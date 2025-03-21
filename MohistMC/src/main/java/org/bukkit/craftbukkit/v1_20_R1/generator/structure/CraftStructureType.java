package org.bukkit.craftbukkit.v1_20_R1.generator.structure;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.craftbukkit.v1_20_R1.util.CraftNamespacedKey;
import org.bukkit.generator.structure.StructureType;

public class CraftStructureType extends StructureType {

    public static StructureType minecraftToBukkit(net.minecraft.world.level.levelgen.structure.StructureType<?> minecraft) {
        ResourceLocation resourceLocation = BuiltInRegistries.STRUCTURE_TYPE.getKey(minecraft);
        if (minecraft == null || resourceLocation == null) {
            return null;
        }
        return Registry.STRUCTURE_TYPE.get(CraftNamespacedKey.fromMinecraft(resourceLocation));
    }

    public static net.minecraft.world.level.levelgen.structure.StructureType<?> bukkitToMinecraft(StructureType bukkit) {
        if (bukkit == null) {
            return null;
        }

        return ((CraftStructureType) bukkit).getHandle();
    }

    private final NamespacedKey key;
    private final net.minecraft.world.level.levelgen.structure.StructureType<?> structureType;

    public CraftStructureType(NamespacedKey key, net.minecraft.world.level.levelgen.structure.StructureType<?> structureType) {
        this.key = key;
        this.structureType = structureType;
    }

    public net.minecraft.world.level.levelgen.structure.StructureType<?> getHandle() {
        return structureType;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }
}
