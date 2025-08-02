package dev.namd.rbpoc.listener;

import dev.namd.rbpoc.util.PopulateRecipes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ShapedRecipe;


public class PrepareRecipeListener implements Listener {

    @EventHandler
    public void onPrepareResult(PrepareItemCraftEvent event) {
        Player player = (Player) event.getView().getPlayer();
        if (!(event.getRecipe() instanceof ShapedRecipe recipe)) return;
        player.sendMessage(recipe.getKey().getNamespace() + ":" + recipe.getKey().getKey());

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().discoverRecipes(PopulateRecipes.namespacedKeys);
    }

}
