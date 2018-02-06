package cn.com.start.webBack.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {
	public String MD5pwd(String source,String salt,int hashIterations){
		//构造方法中：
		//第一个参数：明文，原始密码 
		//第二个参数：盐，通过使用随机数
		//第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		String password_md5 = md5Hash.toString();
		return password_md5;
	}
}
