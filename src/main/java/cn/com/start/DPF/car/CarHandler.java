package cn.com.start.DPF.car;



public class CarHandler implements Runnable {

	public CarHandler() {
		
		// 查询数据
		Thread thread = new Thread(new CarRelay());
		thread.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("查询数据成功");
	}

	@Override
	public void run() {
		// 为每一个车建立一个线程对象
		System.out.println("准备建立汽车线程");
	}
}