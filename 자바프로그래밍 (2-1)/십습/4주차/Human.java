public class Human {
	public String name;
	public String occupation;
	public int age;
	public char gender;
	public char bloodType;
	
	public void setHuman(String _Name, String _Occupation, int _Age, char _Gender, char _BloodType) {
		name = _Name;
		occupation = _Occupation;
		age = _Age;
		gender = _Gender;
		bloodType = _BloodType;
	}
	
	public void speakMe() {
		System.out.printf("I'm %s, and my job is %s. I'm %d years old and my gender is %c, my blood type is %c.\n", 
				name, occupation, age, gender, bloodType);
	}
}
