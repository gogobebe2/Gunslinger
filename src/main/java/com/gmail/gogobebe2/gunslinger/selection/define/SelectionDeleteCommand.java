package com.gmail.gogobebe2.gunslinger.selection.define;

import com.gmail.gogobebe2.gunslinger.Main;
import com.gmail.gogobebe2.gunslinger.command.PlayerCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class SelectionDeleteCommand extends PlayerCommand {
    @Override
    protected void onCommand(Player player, String[] args) {
        String name;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "You did not enter an arena name as a parameter. This means you are deleting the lobby instead.");
            name = "LOBBY";
        }
        else name = args[0].toLowerCase();
        String worldName = player.getWorld().getName();
        Main plugin = Main.getInstance();
        if (!Main.getInstance().getConfig().isSet("Selections." + worldName + "." + name)) {
            player.sendMessage(ChatColor.RED + "Error! " + ChatColor.DARK_RED + name + ChatColor.RED
                    + " hasn't been set yet!");
            return;
        }
        plugin.getConfig().set("Selections." + worldName + "." + name, null);
        plugin.saveConfig();
        player.sendMessage(ChatColor.GREEN + "Selection " + ChatColor.DARK_GREEN + name + ChatColor.GREEN
                + " has been removed in world " + ChatColor.DARK_GREEN + worldName);
    }
}
