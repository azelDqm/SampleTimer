package azel.sampleTimer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = SampleTimer.MODID, version = SampleTimer.VERSION)
public class SampleTimer
{
	@Instance("sample_timer")
	public static SampleTimer instance;

    public static final String MODID = "sample_timer";
    public static final String VERSION = "1.0";

    public static int threadProc = 0;
    public static int threadCount = -1;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//PacketHandler.init();
	}

	@EventHandler
	public void setver(FMLServerStartingEvent event)
	{
		//タイマー制御用コマンドの登録
		event.registerServerCommand(new STCommand());
	}
}
