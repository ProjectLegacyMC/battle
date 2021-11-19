package projectlegacy.battle;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class ChestListener implements Listener {


    private Battle battle;

    public ChestListener(Battle battle) {
        this.battle = battle;
    }

    public void runnableR1(Player p) {
        new BukkitRunnable() {

            @Override
            public void run() {



            }
        }.runTaskTimer(battle, 0, 20);

    }
}
