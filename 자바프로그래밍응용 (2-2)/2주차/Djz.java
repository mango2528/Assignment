import java.io.File;

public class Djz {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\user4\\Desktop\\Assignment\\자바프로그래밍응용 (2-2)\\Assignment\\src");
		File[] fileLists = file.listFiles();
		
		for (int i = 0; i < fileLists.length; i++) {
			File f = fileLists[i];
			
			System.out.printf("%s <%s> [%d bytes] %d \n", f.getName(), f.isFile() ? "파일" : "디렉토리", f.length(), f.lastModified());
		}
		
		System.out.println(File.separator);
	}
}
