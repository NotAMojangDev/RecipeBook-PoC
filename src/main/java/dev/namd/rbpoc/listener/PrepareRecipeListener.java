package dev.namd.rbpoc.listener;

import com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent;
import dev.namd.rbpoc.util.PopulateRecipes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PrepareRecipeListener implements Listener {

    @EventHandler
    public void onPrepareResult(PlayerRecipeBookClickEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(event.getRecipe().getNamespace() + ":" + event.getRecipe().getKey());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().discoverRecipes(PopulateRecipes.namespacedKeys);
    }

}
