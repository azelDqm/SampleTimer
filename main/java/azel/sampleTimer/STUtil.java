package azel.sampleTimer;

import java.util.Iterator;
import java.util.List;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import azel.sampleTimer.packet.MessageClientTestCount;
import azel.sampleTimer.packet.PacketHandler;

public class STUtil {

	public static void doBroadcastMessage(String par1, ICommandSender sender, MinecraftServer server)
	{
        if (par1 != null)
        {
        	//サーバー上の全プレイヤーにメッセージ送信
            server.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.announcement", new Object[] {sender.getDisplayName(), par1}));
        }
	}

	public static void doBroadcastMessage2(String par1, ICommandSender sender, MinecraftServer server, int count)
	{
        if (par1 != null)
        {
        	//サーバー上の全プレイヤーにメッセージ送信
            List<EntityPlayerMP> pList = server.getPlayerList().getPlayerList();
            for (Iterator<EntityPlayerMP> it = pList.iterator(); it.hasNext();){
            	EntityPlayerMP ep = it.next();
            	PacketHandler.INSTANCE.sendTo(new MessageClientTestCount(count), ep);
            	ep.addChatComponentMessage(new TextComponentTranslation("chat.type.announcement", new Object[] {sender.getDisplayName(), par1}));
            }
        }
	}
}
