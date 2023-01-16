#if($addStaticGetter == "true" or ${dep.JeffLib} == "true")
#set ($initBlock = "true")
#end
package ${package};

#if (${dep.ACF} == "true")
import co.aikar.commands.PaperCommandManager;
#end
#if (${dep.JeffLib} == "true")
import com.jeff_media.jefflib.JeffLib;
#end
#if (${dep.MockBukkit} == "true")
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.PluginDescriptionFile;
import java.io.File;
#end
import org.bukkit.plugin.java.JavaPlugin;

public class ${mainClass} extends JavaPlugin {
#if ($addStaticGetter == "true")

    private static MyPlugin instance;
#end
#if ($initBlock == "true")

    {
#end
#if ($addStaticGetter == "true")
        instance = this;
#end
#if (${dep.JeffLib} == "true")
        JeffLib.init(this);
#if (${dep.NMS} == "true")
        JeffLib.enableNMS();
#end
#end
#if($initBlock=="true")
    }
#end
#if ($addStaticGetter == "true")

    public static ${mainClass} getInstance() {
        return instance;
    }
#end
#if (${dep.MockBukkit} == "true")

    /**
     * Required for MockBukkit
     */
    public MyPlugin() {

    }

    /**
    * Required for MockBukkit
    */
    protected MyPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
#end

    @Override
    public void onEnable() {
#if (${dep.ACF} == "true")
        PaperCommandManager acf = new PaperCommandManager(this);
#end
    }

}
