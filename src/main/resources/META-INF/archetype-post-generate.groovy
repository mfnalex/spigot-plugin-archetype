import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)
Properties properties = request.properties

boolean useMockBukkit = ((String)properties.get("dependMockBukkit")).equalsIgnoreCase("true")
boolean useKotlin = ((String)properties.get("useKotlin")).equalsIgnoreCase("true")

String packageName = properties.get("package")
String packagePath = packageName.replace(".", "/")

if (!useMockBukkit) {
    Files.deleteIfExists projectPath.resolve("src/test/java/" + packagePath + "/" + (String)properties.get("mainClass") + "Test.java")
}

def mainDir = new File(new File(projectPath.toFile(), "src"), "main")
if (useKotlin) {
    new File(mainDir, "java").deleteDir()
} else {
    new File(mainDir, "kotlin").deleteDir()
}