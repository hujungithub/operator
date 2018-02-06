package cn.com.start.DPF.car;


public class CarObject implements Runnable{
	
	private CarRealState carInfo;
	private boolean flag = true;
	
	//构造
	public CarObject(CarRealState carInfo){
		this.carInfo = carInfo;
	} 
	
	
	public void doCheck(){
		int carState = carInfo.getCarState();
		while(flag){
			if(carState == 0){
				// 车子处在空闲状态
				System.out.println("什么都不干");
			}else if(carState == 1){
				// 车子处在预约状态
			}else if(carState ==2){
				//车子处在行驶状态
				//改变车子的状态电压电流				
			}else{
				//车子处在故障状态
			}
			
			
		}
	}
	@Override
	public void run() {
		doCheck();
		
	}

}
