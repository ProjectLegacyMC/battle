package battlelegacy.me.fizzdev.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();
        String msg = e.getMessage();
        int level = 0;
        String levelColour = "";

        if (p.hasPermission("pl.colour") || p.hasPermission("pl.staff")) {
            msg = ChatColor.translateAlternateColorCodes('&', msg);
        }

        // basic staff chat I guess

        if (msg.startsWith("!") && p.hasPermission("pl.staffchat")) {
            e.setCancelled(true);
            for (Player player : p.getServer().getOnlinePlayers()) {
                if (player.hasPermission("pl.staffchat")) {
                    if (msg.substring(1).equalsIgnoreCase("")) {
                        player.sendMessage(ChatColor.RED + "You can not send an empty staffchat message!");
                    }
                    player.sendMessage(p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg.substring(1));
                }
            }
        }

        // yummy spaghetti code

        if (p.hasPermission("rank.sponsor")) {
            if (p.hasPermission("rank.sponsor.1")) {
                level = 1;
                levelColour = "b";
            }
            if (p.hasPermission("rank.sponsor.2")) {
                level = 2;
                levelColour = "e";
            }
            if (p.hasPermission("rank.sponsor.3")) {
                level = 3;
                levelColour = "6";
            }
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&" + levelColour + "[Sponsor]" + level + " » " + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
        }
        else if (p.hasPermission("pl.staff")) {
            if (p.hasPermission("rank.administrator")) {
                e.setFormat(ChatColor.translateAlternateColorCodes('&', "&4[Admin]" + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
            }
            else if (p.hasPermission("rank.moderator")) {
                e.setFormat(ChatColor.translateAlternateColorCodes('&', "&c[Moderator] » " + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
            }
            else if (p.hasPermission("rank.helper")) {
                e.setFormat(ChatColor.translateAlternateColorCodes('&', "&5[Helper] » " + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
            }
            else if (p.hasPermission("rank.builder")) {
                e.setFormat(ChatColor.translateAlternateColorCodes('&', "&2[Builder] » " + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
            }
        }
        else if (p.hasPermission("rank.supporter")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', "&9[Supporter] » " + p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
        }
        else {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', p.getDisplayName() + ChatColor.DARK_GRAY + " » " + ChatColor.WHITE + msg));
        }
    }
}
