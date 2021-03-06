package com.gmail.gogobebe2.gunslinger.selection.define;

import com.gmail.gogobebe2.gunslinger.command.Command;
import com.gmail.gogobebe2.gunslinger.command.RecursiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public final class SelectionMainCommand extends RecursiveCommand {
    @Override
    protected Map<String, Command> initializeLegalSubCommands() {
        Map<String, Command> subCommands = new HashMap<>();
        subCommands.put("confirm", new SelectionConfirmCommand());
        subCommands.put("delete", new SelectionDeleteCommand());
        subCommands.put("wand", new SelectionWandCommand());
        subCommands.put("setspawn", new SelectionSetspawnCommand());
        return subCommands;
    }

    @Override
    protected void onCommand(CommandSender commandSender, String[] args) {
        if (!commandSender.hasPermission("gs.select")) {
            commandSender.sendMessage(ChatColor.RED + "Error! You do not have permission to use this command!");
            return;
        }
        super.onCommand(commandSender, args);
    }
}
