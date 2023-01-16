package ${package};

#if ($useACF == "true")
import co.aikar.commands.PaperCommandManager;
#end
#if ($useMockBukkit == "true")
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.PluginDescriptionFile;
import java.io.File;
#end
import org.bukkit.plugin.java.JavaPlugin;

public class ${mainClass} extends JavaPlugin {

#if ($useMockBukkit == "true")
    /**
    * Required for MockBukkit
    */
    protected MyPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
#end

    @Override
    public void onEnable() {
#if ($useACF == "true")
        PaperCommandManager acf = new PaperCommandManager(this);
#end
    }

}
