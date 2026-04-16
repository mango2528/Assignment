public class Student_Info {
	public static void main(String[] args) {
		Student	s1 = new Student("경성대", "2026001", 90, 89, 100);
		Student s2 = new Student("홍길동", "2026002", 88, 78, 99);
		

		s1.setPoint(null, null, null);
		s2.setPoint(null, null, null);
		System.out.println(s1);
		System.out.println(s2);
	}
}
