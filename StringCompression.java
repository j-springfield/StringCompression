import java.util.ArrayList;
import java.math.*;

public class StringCompression {
	private static ArrayList<String> compressedString = new ArrayList<String>();
	
	public static void setInitialString(String s){
		boolean isLegalString = true;
		for(int illegalCharBeforeLowercaseAlphabet = 0; illegalCharBeforeLowercaseAlphabet < 97; illegalCharBeforeLowercaseAlphabet++){
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == (char)illegalCharBeforeLowercaseAlphabet){
					isLegalString = false;
				}
			}
		}
		for(int illegalCharAfterLowercaseAlphabet = 123; illegalCharAfterLowercaseAlphabet < 128; illegalCharAfterLowercaseAlphabet++){
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == (char)illegalCharAfterLowercaseAlphabet){
					isLegalString = false;
				}
			}
		}
		if(isLegalString){
			compressedString.clear();
			compressedString.add(s);
		}
	}
	
	public static ArrayList<String> getCompressedString(){
		return compressedString;
	}
	
	public static ArrayList<String> compressString(ArrayList<String> stringToCompress){
		int maxCompressedLetters = 0;
		ArrayList<String> newString = new ArrayList<String>();
		int numberOfRepeatedLetters = 1;
		
		String [] arrayRepresentationOfString = (String[]) stringToCompress.toArray();
		for(int i = 0; i < arrayRepresentationOfString.length; i++){
			int numberCharsSame = 0;
			while(arrayRepresentationOfString[i].equals(arrayRepresentationOfString[i + numberCharsSame])){
				numberOfRepeatedLetters++;
				numberCharsSame++;
			}
			newString.add(arrayRepresentationOfString[i]);
			Integer number = new Integer(numberOfRepeatedLetters);
			newString.add(number.toString());
		}
		
		return compressedString;
	}
	
	public static void main(String[] args){
		setInitialString("aabbccc");
		compressString(getCompressedString());
		System.out.println(getCompressedString());
	}
}
