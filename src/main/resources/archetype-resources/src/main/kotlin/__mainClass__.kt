package ${package}

import org.bukkit.plugin.java.JavaPlugin

class ${mainClass}: JavaPlugin() {
#if (${addStaticGetter} == "true")

    companion object {
        lateinit var instance: ${mainClass}
    }

    init {
        instance = this
    }
#end

    override fun onEnable() {

    }

}