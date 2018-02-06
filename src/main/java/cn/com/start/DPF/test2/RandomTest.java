package cn.com.start.DPF.test2;


public class RandomTest {

	//第一位不为0
	public static void main(String[] args) {
		String str = "";
		for(int i=0;i<20;i++){
			int x = (int)(Math.random()*10);
			if(i==0 && x==0){
				continue;
			}
			String s = x+"";
			str = str + s;
			
		}
		System.out.println(str);
	}//字符串

}
