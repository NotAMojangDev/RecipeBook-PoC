package dev.namd.rbpoc;

import dev.namd.rbpoc.listener.PrepareRecipeListener;
import dev.namd.rbpoc.util.PopulateRecipes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RBPOCPlugin extends JavaPlugin {

    public static RBPOCPlugin plugin;

    @Override
    public void onEnable() {
        RBPOCPlugin.plugin = this;
        Bukkit.clearRecipes();
        PopulateRecipes.PopRps();
        Bukkit.getServer().getPluginManager().registerEvents(new PrepareRecipeListener(), this);
    }

}
