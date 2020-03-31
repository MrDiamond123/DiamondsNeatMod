package io.github.MrDiamond123.neat.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class PlayerPearlItem extends Item {

    public PlayerPearlItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        Random random = new Random();
        List<? extends PlayerEntity> playerEntities = world.getPlayers();
        playerEntities.remove(playerEntity);

        if (playerEntities.size() >= 1) {
            PlayerEntity chosenPlayer = playerEntities.get(random.nextInt(playerEntities.size() - 1));

            playerEntity.addMessage(new TranslatableText("item.diamondsneat.player_pearl.success", chosenPlayer.getDisplayName().asString()), true);
            return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getMainHandStack());
        }
        return new TypedActionResult<>(ActionResult.FAIL, playerEntity.getMainHandStack());

    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> toolTip, TooltipContext tooltipContext) {
        toolTip.add(new TranslatableText("item.diamondsneat.player_pearl.tooltip"));
    }
}
