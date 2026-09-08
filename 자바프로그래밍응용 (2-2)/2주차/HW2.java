import java.io.File;

public class HW2 {
	static boolean isChanged = false;
	
	public static void changeName(File dir, String originName, String targetName) {
		File[] subFiles = dir.listFiles();
		
		for(int i = 0; i < subFiles.length; i++) {
			File fileBefore = subFiles[i];
			
			File fileAfter = new File(fileBefore.getParent() + '\\' + targetName);
			boolean isFile = fileBefore.isFile();
			
//			fileBefore.renameTo(fileAfter);
			
			if (fileBefore.getName().equals(originName)) {
				if (isFile) {
					System.out.printf("%s를 %s로 변경함. [파일]\n", fileBefore, fileAfter);
					fileBefore.renameTo(fileAfter);
				}
				else {
					System.out.printf("%s를 %s로 변경함. [디렉토리]\n", fileBefore, fileAfter);
					fileBefore.renameTo(fileAfter);
				}
				
				isChanged = true;
			}
			
			try {
				if (fileBefore.listFiles().length > 0) {
					changeName(fileBefore, originName, targetName);
				}
			}
			catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.out.printf("%s의 디렉토리를 찾을 수 없음 !!!\n", args[0]);
			return;
		}
		
		changeName(file, args[1], args[2]);
		
		if (!isChanged) {
			System.out.println("Test를 검색할 수 없음\r\n");
		}
	}
}