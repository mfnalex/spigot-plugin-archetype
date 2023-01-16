#set ($zero = 0)
#set ($majorVersion = $zero.parseInt($spigotVersion.split('\.')[0]))
#set ($minorVersion = $zero.parseInt($spigotVersion.split('\.')[1]))
package ${package};

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import ${package}.${mainClass};
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ${mainClass}Test {

    private ServerMock server;
    private ${mainClass} plugin;

    @Before
    public void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(${mainClass}.class);
    }

    @After
    public void tearDown() {
#if ($minorVersion >= 15)
        MockBukkit.unmock();
#else
        MockBukkit.unload();
#end
    }

    @Test
    public void test() {
        Assert.assertNotNull(plugin);
    }

}
