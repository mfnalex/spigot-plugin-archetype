#if($addStaticGetter == "true" or ${dependJeffLib} == "true")
#set ($initBlock = "true")
#end
package ${package};

#if (${dependACF} == "true")
import co.aikar.commands.PaperCommandManager;
#end
#if (${dependJeffLib} == "true")
import com.jeff_media.jefflib.JeffLib;
#end
#if (${dependMockBukkit} == "true")
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.PluginDescriptionFile;
import java.io.File;
#end
import org.bukkit.plugin.java.JavaPlugin;

public class ${mainClass} extends JavaPlugin {
#if ($addStaticGetter == "true")

    private static ${mainClass} instance;
#end
#if ($initBlock == "true")

    {
#end
#if ($addStaticGetter == "true")
        instance = this;
#end
#if (${dependJeffLib} == "true")
        JeffLib.init(this);
#if (${dependNMS} == "true")
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
#if (${dependMockBukkit} == "true")

    /**
     * Required for MockBukkit
     */
    public ${mainClass}() {}

    /**
    * Required for MockBukkit
    */
    protected ${mainClass}(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
#end

    @Override
    public void onEnable() {
#if (${dependACF} == "true")

        PaperCommandManager acf = new PaperCommandManager(this);
#end
#if (${dependSpigotUpdateChecker} == "true")

        checkForUpdates();
#end

    }

#if (${dependSpigotUpdateChecker} == "true")
        private void checkForUpdates() {
            final String spigotResourceId = "59773";
            final String downloadLink = "https://www.spigotmc.org/resources/chestsort-api.59773/";
            final String donationLink = "https://paypal.me/mfnalex";
            final String changelogLink = "https://www.spigotmc.org/resources/chestsort-api.59773/updates";

            new UpdateChecker(this, UpdateCheckSource.SPIGOT, spigotResourceId)
            .setDownloadLink(downloadLink)
            .setDonationLink(donationLink)
            .setChangelogLink(changelogLink)
            .setNotifyOpsOnJoin(true)
            .setUserAgent(UserAgentBuilder.getDefaultUserAgent())
            .checkNow();
        }

#end
}
