package data;

/**
 * Encryption类的作用是进行重要信息的加密与解密
 * 
 * @author Thpffcj
 *
 */
public class Encryption {

	/**
	 * 
	 * @param input String型，表示加密前的数据
	 * @return output String型，表示加密后的数据
	 */
	public String encryption(String input){
		String output = "";
		if(input == null){
			return null;
		}
		for(int i=0; i<input.length(); i++){
			char temp = (char) (input.charAt(i)+'0'+i);
			output += temp;
		}
		return output;
	}
	
	public String decryption(String input){
		String output = "";
		if(input == null){
			return null;
		}
		for(int i=0; i<input.length(); i++){
			char temp = (char) (input.charAt(i)-'0'-i);
			output += temp;
		}
		return output;
	}
	
}
