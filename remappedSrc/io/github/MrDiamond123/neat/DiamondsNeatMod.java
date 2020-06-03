package io.github.MrDiamond123.neat;

import io.github.MrDiamond123.neat.item.NeatItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;

public class DiamondsNeatMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		new NeatItems();
		System.out.println("Hello Fabric world!");
	}
}
