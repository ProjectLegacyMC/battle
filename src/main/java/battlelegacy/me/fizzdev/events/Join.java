package battlelegacy.me.fizzdev.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Join implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GREEN + e.getPlayer().getName() + ChatColor.WHITE + " joined the game.");
    }

}
