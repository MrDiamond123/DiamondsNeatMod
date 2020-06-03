package io.github.MrDiamond123.neat;

import io.github.MrDiamond123.neat.enchantment.ExplosiveTouchEnchantment;
import io.github.MrDiamond123.neat.item.NeatItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DiamondsNeatMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		// Enchantments (Will move to new class later)
		Enchantment EXPLOSIVE_TOUCH;
		EXPLOSIVE_TOUCH = Registry.register(Registry.ENCHANTMENT,
				new Identifier("diamondsneat", "explosive_touch"),
				new ExplosiveTouchEnchantment(
						Enchantment.Rarity.VERY_RARE,
						EnchantmentTarget.WEAPON,
						new EquipmentSlot[]{
								EquipmentSlot.MAINHAND
						}
						)
		);



		new NeatItems();

		System.out.println("Hello Fabric world!");
	}
}
