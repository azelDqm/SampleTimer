package azel.sampleTimer;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class STThread extends Thread{

	private ICommandSender sender = null;
	private MinecraftServer server = null;

	public STThread(ICommandSender par2, MinecraftServer server)
	{
		this.sender = par2;
		this.server = server;
	}

	public void run()
	{
		SampleTimer.threadProc = 1;
		SampleTimer.threadCount = 0

				;
		while(SampleTimer.threadProc == 1)
		{
			//ブロードキャストメッセージの送信
			STUtil.doBroadcastMessage2(String.valueOf(SampleTimer.threadCount), this.sender, this.server, SampleTimer.threadCount);
			SampleTimer.threadCount++;

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		SampleTimer.threadCount = -1;
		STUtil.doBroadcastMessage2(String.valueOf(SampleTimer.threadCount), this.sender, this.server, SampleTimer.threadCount);
		//タイマー処理終了後に処理を行いたい場合はここに。
	}
}
