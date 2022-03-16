package battlelegacy.me.fizzdev;

import battlelegacy.me.fizzdev.events.Chat;
import battlelegacy.me.fizzdev.events.Join;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Chat(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
