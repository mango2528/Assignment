/**
 * 학생 클래스이다.
 * ㅋ
 */
public class Student {
	private String	name, number;
	private int		kor, eng, math;
	private float	avg;
	private char	grade;
	
//	public Student() {
//		name = number = null;
//		grade = 'F';
//	}
	
	public Student(String _Name, String _Number, int _Kor, int _Eng, int _Math) {
		name = _Name;
		number = _Number;
		kor = _Kor;
		eng = _Eng;
		math = _Math;
		
		setAverage();
	}
	
	public void setStudent(String _Name, String _Number, int _Kor, int _Eng, int _Math) {
		name = _Name;
		number = _Number;
		kor = _Kor;
		eng = _Eng;
		math = _Math;
		
		setAverage();
	}
	
	public String toString() {
		return String.format("%s[%s] %d %d %d 과목 평균 : %.2f", name, number, kor, eng, math, avg);
	}
	
	public void setPoint(Integer k, Integer e, Integer m) {
		if (k != null) {
			kor = k;
		}
		
		if (e != null) {
			eng = e;
		}
		
		if (m != null) {
			math = m;
		}
		
		setAverage();
	}
	
	/**
	 * 평균 반환
	 * @return 학생의 평균
	 */
	public float getAverage() {
		return avg;
	}
	
	public static Student[] sort(Student[] s, boolean asc) {
		
	}
	
	public static boolean maxLast(Student[] s, int size, int asc) {
		
	}
	
	public static boolean compare(Student[] s, int i, int j, boolean asc, int type) {
		
	}
	
	private void setAverage() {
		avg = (kor + eng + math) / 3.0f;
	}
}
