package azel.sampleTimer;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class STHudSample extends Gui
{
  private Minecraft mc;

  public STHudSample(Minecraft mc)
  {
    super();

    // We need this to invoke the render engine.
    this.mc = mc;
  }

  @SubscribeEvent
  public void onRenderPlayerStatus(RenderGameOverlayEvent event)
  {
		if(event.isCancelable() || (event.getType() != ElementType.EXPERIENCE && event.getType() != ElementType.JUMPBAR))
		{
		  return;
		}

		if(SampleTimer.threadCount == -1)
		{
			return;
		}
      ScaledResolution sr = new ScaledResolution(mc);
      int w = sr.getScaledWidth();
      int h = sr.getScaledHeight();


      if (true)
      {
          ResourceLocation reLoc = new ResourceLocation("SampleTimer","textures/gui/segnumber.png");
          String comboString = (new Integer(SampleTimer.threadCount)).toString();
          for(int cnt = 0; comboString.length() > cnt; cnt++ )
          {
          	char c = comboString.charAt(comboString.length()-(cnt + 1));
          	int fixVal = Character.getNumericValue(c);
          	int fixX = 0;
          	int fixY = 0;

      		fixX = (fixVal * 23);

          	mc.renderEngine.bindTexture(reLoc);
            this.drawTexturedModalRect(w - 4 - ((cnt + 1) * 23), 4, fixX, fixY, 23, 36);
          }
      }
  }
}
