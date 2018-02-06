package cn.com.start.DPF.aio;

public class StaticData {

	public static void main(String args[]) {
		Thread thread = new Thread(new DataRelay());
		thread.start();
	}
}
