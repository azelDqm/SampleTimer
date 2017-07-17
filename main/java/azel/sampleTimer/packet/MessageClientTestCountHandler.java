package azel.sampleTimer.packet;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import azel.sampleTimer.SampleTimer;

public class MessageClientTestCountHandler implements IMessageHandler<MessageClientTestCount, IMessage> {

    @Override//IMessageHandlerのメソッド
    public IMessage onMessage(MessageClientTestCount message, MessageContext ctx) {
    	//サーバーから受け取った値をクライアント側で同期を取る
    	int pat = message.data;

        SampleTimer.threadCount = pat;

        //サーバーへ送った際に、EntityPlayerインスタンス（EntityPlayerMPインスタンス）はこのように取れる。
        return null;
    }
}
