package org.reuac.itemframelorekeeper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import static org.bukkit.Bukkit.getLogger;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length > 0) {
                String action = strings[0];

                switch (action.toLowerCase()) {
                    case "get":
                        HashMap<Integer, ItemStack> excess = player.getInventory().addItem(MainListener.mainItem);

                        if (!excess.isEmpty()) {
                            player.sendMessage("Your inventory is full!");
                        } else {
                            player.sendMessage("ItemFrame get!");
                        }
                        return true;
                    case "reload":
                        ItemFrameLoreKeeper.main.reloadConfig();
                        ItemFrameLoreKeeper.main.loadConfig();
                        player.sendMessage("ItemFrameLoreKeeper reloaded!");
                        return true;
                }
            }
        }else {
            ItemFrameLoreKeeper.main.reloadConfig();
            ItemFrameLoreKeeper.main.loadConfig();
            getLogger().info("ItemFrameLoreKeeper reloaded!");
        }

        return false;
    }
}
