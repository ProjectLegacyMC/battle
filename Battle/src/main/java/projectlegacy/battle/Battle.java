package projectlegacy.battle;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Battle extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChestListener(this), this);

        getCommand("start").setExecutor(new battleStartCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
