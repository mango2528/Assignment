import java.io.File;

public class HW1 {
	public static void listDirectory(File dir, int depth) {
		File[] subFiles = dir.listFiles();
		int curDepth = depth;
		
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			boolean isFile = f.isFile();
			
			for (int j = 0; j < curDepth; j++) {
				System.out.printf(" ");
			}
			
			if (curDepth > 0) {
				System.out.printf("\u27A5");
			}
			
			if (isFile) {
				System.out.printf("%s <%d bytes> (%s) [수정일 : %tF %tI:%tM:%tS (%tp)]\n", f.getName(), f.length(), "파일", t, t, t, t, t);
			}
			else {
				System.out.printf("%s (%s) [수정일 : %tF %tI:%tM:%tS (%tp)]\n", f.getName(), "디렉토리", t, t, t, t, t);
			}		
			
			try {
				if (f.listFiles().length > 0) {
					listDirectory(f, curDepth + 1);
				}
			}
			catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.out.printf("%s의 디렉토리는 존재하지 않음!!\n", args[0]);
			return;
		}
		
		listDirectory(file, 0);
	}
}