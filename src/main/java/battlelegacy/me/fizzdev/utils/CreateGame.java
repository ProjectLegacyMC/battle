package battlelegacy.me.fizzdev.utils;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.io.File;

public class CreateGame {

    public void loadSchematic(File name, World world, Vector pos) {
        boolean allowUndo = true;
        EditSession editSession = ClipboardFormats.findByFile(name).load(name).paste(world, pos);
    }
}
