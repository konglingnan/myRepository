package common;

public class StringUtil {

	public static boolean isEmptyOrNull(String str){
		if(str!=null||!"".equals(str)){
			return false;
		}
		return true;
	}
}
