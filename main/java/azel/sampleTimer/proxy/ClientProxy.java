package azel.sampleTimer.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import azel.sampleTimer.STHudSample;

public class ClientProxy extends CommonProxy{
    @Override
    public void registerGUI()
    {
    	MinecraftForge.EVENT_BUS.register(new STHudSample(Minecraft.getMinecraft()));
    }
}
