package dev.namd.rbpoc.util;

import dev.namd.rbpoc.RBPOCPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.Collection;

public class PopulateRecipes {

    public static Collection<NamespacedKey> namespacedKeys;

    public static void PopRps() {

        ArrayList<NamespacedKey> ls = new ArrayList<>();
        byte ind1 = 0;
        byte ind2 = 1;
        for (Material mat : Material.values()) {
            if (mat.isEmpty()) continue;
            if (!mat.isItem()) continue;
            NamespacedKey key = new NamespacedKey(RBPOCPlugin.plugin, mat.getKey().getKey());
            ls.add(key);
            String rcp = String.format("%1$2d,%2$2d", ind1, ind2).replaceAll("0", " ");
            ShapedRecipe shapedRecipe = prep(rcp, key, mat);

            Bukkit.addRecipe(shapedRecipe);
            ind2++;
            if (ind2 >= 100) {
                ind2 = 1;
                ind1++;
            }
        }

        namespacedKeys = ls;
    }

    public static ShapedRecipe prep(String rcp, NamespacedKey key, Material mat) {
        ShapedRecipe srcp = new ShapedRecipe(key, new ItemStack(mat));
        srcp = srcp.shape(rcp.split(","));
        if (rcp.contains("1")) srcp.setIngredient('1', Material.AMETHYST_SHARD);
        if (rcp.contains("2")) srcp.setIngredient('2', Material.COPPER_INGOT);
        if (rcp.contains("3")) srcp.setIngredient('3', Material.DIAMOND);
        if (rcp.contains("4")) srcp.setIngredient('4', Material.EMERALD);
        if (rcp.contains("5")) srcp.setIngredient('5', Material.IRON_INGOT);
        if (rcp.contains("6")) srcp.setIngredient('6', Material.GOLD_INGOT);
        if (rcp.contains("7")) srcp.setIngredient('7', Material.RESIN_BRICK);
        if (rcp.contains("8")) srcp.setIngredient('8', Material.NETHERITE_INGOT);
        if (rcp.contains("9")) srcp.setIngredient('9', Material.LAPIS_LAZULI);
        return srcp;
    }

}
