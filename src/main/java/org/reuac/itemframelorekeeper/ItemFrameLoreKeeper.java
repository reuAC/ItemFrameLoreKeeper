package org.reuac.itemframelorekeeper;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class ItemFrameLoreKeeper extends JavaPlugin {
    static ItemFrameLoreKeeper main;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);
        Bukkit.getPluginCommand("itemframelorekeeper").setExecutor(new MainCommand());

        saveDefaultConfig();
        loadConfig();

        main = this;
    }

    private String makeColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void loadConfig() {
        List<String> lore = getConfig().getStringList("lores");
        List<String> lore_make = new ArrayList<>();
        String name = getConfig().getString("name");
        boolean glow = getConfig().getBoolean("glow");
        ItemStack item = new ItemStack(Material.ITEM_FRAME);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(makeColor(name));
            if (glow) {
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            for (String s : lore) {
                lore_make.add(makeColor(s));
            }
            meta.setLore(lore_make);
            item.setItemMeta(meta);
        }

        NBTItem nbti = new NBTItem(item);
        NBTCompound entityTag = nbti.addCompound("EntityTag");
        entityTag.setByte("Invisible", (byte) 1);

        MainListener.mainItem = nbti.getItem();
    }

    @Override
    public void onDisable() {

    }
}
