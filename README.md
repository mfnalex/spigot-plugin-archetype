This is a maven archetype ("template project") to quickly create a new Spigot plugin from scratch.

## Features
- Automatically creates a whole project setup including main class, plugin.yml and pom.xml
- Set a custom package name, main class name, plugin name, ...
- Set a custom Spigot version to use (e.g. "1.19.3")
- Choose whether you want to use NMS or not
  - If you use NMS, it automatically adds the mojang mapping stuff to your pom.xml if using 1.17+
- Choose which dependencies you want to add, and automatically shade them when needed (JeffLib, Vault (todo), ...)

## Usage
You simply have to clone this repo, then `mvn install` it. After that, you can use the archetype to create a new project.

```shell
git clone https://github.com/JEFF-Media-GbR/maven-spigot-plugin
cd maven-spigot-plugin
mvn install
```

Then, you can create a new project using the archetype:

```shell
mvn archetype:generate -DarchetypeArtifactId=spigot-plugin -DarchetypeGroupId=com.jeff_media -DarchetypeVersion=1.0.0-SNAPSHOT
```