import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class HW {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.out.printf("파일 %s 없음\n", args[0]);
			System.exit(-1);
		}
		
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\|");
		Scanner line;
		
		Person[] person = new Person[10];
		
		int index = 0;
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			line.useDelimiter("\\|");
			
			if (index >= person.length) {
				person = Arrays.copyOf(person, person.length * 2);
			}
			
			String type = line.next();
			
			switch (type) {
			case "학부" :
				person[index] = new Under(line.next(), line.next(), line.next(), line.next(), line.next());
				break;
				
			case "석사" :
				person[index] = new MS(line.next(), line.next(), line.next(), line.next(), line.next());
				break;
				
			case "박사" :
				person[index] = new PhD(line.next(), line.next(), line.next(), line.next(), line.next());
				break;
				
			case "조교" :
				person[index] = new Assistant(line.next(), line.next(), line.next(), line.next(), line.next());
				break;
				
			case "교수" :
				person[index] = new Professor(line.next(), line.next(), line.next(), line.next(), line.next());
				break;
			}
			
			index++;
		}
		
		// ****************************************
		
		person = trimArray(person);
		
		if (args[1].equals("print")) {
			try {				
				if (args[2].charAt(6) == '-') {
					printSSNO(person, args[2]);
				}
				else if (args[2].equals("student") || args[2].equals("staff") || args[2].equals("professor")) {
					printClass(person, args[2]);
				}
			}
			catch (Exception e) {
				try {	
					if (args[2].equals("student") || args[2].equals("staff") || args[2].equals("professor")) {
						printClass(person, args[2]);
					}
					else {
						printName(person, args[2]);
					}
				}		
				catch (Exception ee) {					
					print(person);
				}
			}
		}
		else if (args[1].equals("sort")) {
			sort(person, args[2]);
			print(person);
		}
		
		scanner.close();
	}
	
	private static Person[] trimArray(Person[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				return Arrays.copyOf(arr, i);
			}
		}
		
		return arr;
	}
	
	private static void print(Person[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private static void printSSNO(Person[] arr, String no) {
		for (Person p : arr) {
			if (p.no.equals(no)) {
				System.out.println(p);
			}
		}
	}
	
	private static void printName(Person[] arr, String name) {
		for (Person p : arr) {
			if (p.name.equals(name)) {
				System.out.println(p);
			}
		}
	}
	
	private static void printClass(Person[] arr, String className) {	
		for (Person p : arr) {
			switch (className) {
			case "student" :
				if (p instanceof Student) {
					System.out.println(p);
				}
				
				break;
			case "staff" :
				if (p instanceof Staff) {
					System.out.println(p);
				}
				
				break;
			case "professor" :
				if (p instanceof Professor) {
					System.out.println(p);
				}
				
				break;
			}
		}
	}
	
	private static void sort(Person[] arr, String option) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				switch (option) {
				case "ssno" :
					if (arr[j].no.compareTo(arr[j + 1].no) > 0) {
						Person temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
					
					break;
				case "name" :
					if (arr[j].name.compareTo(arr[j + 1].name) > 0) {
						Person temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
					
					break;
				case "birthdate" :
					if (arr[j].date.compareTo(arr[j + 1].date) > 0) {
						Person temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
					
					break;
				case "address" :
					if (arr[j].address.compareTo(arr[j + 1].address) > 0) {
						Person temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
					
					break;
				default :
					System.out.println("명령어 오류");
					System.exit(-1);
				}
			}
		}
	}
}

abstract class Person {
	public String no;
	public String name;
	public String date;
	public String phone;
	public String address;
	
	public Person() { }
	
	public Person(String no, String name, String date, String phone, String address) {
		this.no = no;
		this.name = name;
		this.date = date;
		this.phone = phone;
		this.address = address;
	}
	
	public abstract String toString();
}

class Student extends Person {
	public int yearEnroll; // 나이 대비 +19 ~ +24
	public String major;
	
	private enum Major {
		NETWORK("정보통신공학과", 0),
		SECURITY("정보보안학과", 1),
		AI("인공지능학과", 2),
		COMPUTER("컴퓨터공학과", 3),
		SOFTWARE("소프트웨어공학과", 4);
		
		private final String label;
		private final int id;
		
		Major(String label, int id) {
			this.label = label;
			this.id = id;
		}
		
		public String label() {
			return label;
		}
		
		public int code() {
			return id;
		}
		
		private static Major findMajorByID(int id) {
			for (Major m : Major.values()) {
				if (m.id == id) {
					return m;
				}
			}
			
			return null;
		}
	}
	
	/**
	 * 입학 기간 생성
	 */
	private int generateYearEnroll(String date) {	
		Random random = new Random();
		int y = Integer.parseInt(date.split("-")[0]);
		
		int year = y + 19 + random.nextInt(5 + 1);
		
		return year;
	}
	
	public Student() { }
	
	public Student(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		
		this.yearEnroll = generateYearEnroll(date);
		this.major = Major.findMajorByID(random.nextInt(Major.values().length)).label();
	}
	
	@Override
	public String toString() {
		return String.format("|학부|%s|%s|%s|%s|%s|%d|%s|", this.no, this.name, this.date,
				this.phone, this.address, this.yearEnroll, this.major);
	}
}

class Staff extends Person {
	public String major;
	
	private enum Major {
		NETWORK("정보통신공학과", 0),
		SECURITY("정보보안학과", 1),
		AI("인공지능학과", 2),
		COMPUTER("컴퓨터공학과", 3),
		SOFTWARE("소프트웨어공학과", 4);
		
		private final String label;
		private final int id;
		
		Major(String label, int id) {
			this.label = label;
			this.id = id;
		}
		
		public String label() {
			return label;
		}
		
		public int code() {
			return id;
		}
		
		private static Major findMajorByID(int id) {
			for (Major m : Major.values()) {
				if (m.id == id) {
					return m;
				}
			}
			
			return null;
		}
	}
	
	public Staff( ) { }
	
	public Staff(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		
		this.major = Major.findMajorByID(random.nextInt(Major.values().length)).label();
	}
	
	@Override
	public String toString() {
		return String.format("|교직원|%s|%s|%s|%s|%s|%s|", this.no, this.name, this.date,
				this.phone, this.address, this.major);
	}
}

class Under extends Student {
	public int Grade;
	public String club;
	
	private enum Club {
		NONE("없음", 0),
		SOCIAL("시사토론부", 1),
		BROADCAST("방송부", 2),
		EXPERIMENT("과학실험부", 3),
		CAPITAL("경제경영탐구반", 4),
		BAND("밴드부", 5),
		ART("미술부", 6),
		VOLUNTEER("봉사활동반", 7),
		SPORT("스포츠부", 8);
		
		private final String label;
		private final int id;
		
		Club(String label, int id) {
			this.label = label;
			this.id = id;
		}
		
		public String label() {
			return label;
		}
		
		public int code() {
			return id;
		}
		
		private static Club findClubByID(int id) {
			for (Club c : Club.values()) {
				if (c.id == id) {
					return c;
				}
			}
			
			return null;
		}
	}
	
	public Under() { }
	
	public Under(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		this.Grade = 1 + random.nextInt(4);
		
		this.club = Club.findClubByID(random.nextInt(Club.values().length)).label();
	}
	
	public String toString() {
		return String.format("|학부생|%s|%s|%s|%s|%s|%s|%s|%s|", this.no, this.name, this.date,
				this.phone, this.address, this.yearEnroll,
				this.major, this.club);
	}
}

class Graduate extends Student {
	public String research;
	
	private enum Research {
		NETWORK("네트워크", 0),
		SECURITY("정보보안", 1),
		DATABASE("데이터베이스", 2),
		AI("인공지능", 3),
		COMPUTER("컴퓨터공학", 4),
		SOFTWARE("소프트웨어공학", 5),
		DATASCIENCE("데이터과학", 6),
		BIOINFORMATICS("생명정보학", 7),
		CRYPTOGRAPHY("암호학", 8),
		GRAPHICS("컴퓨터그래픽스", 9);
		
		private final String label;
		private final int id;
		
		Research(String label, int id) {
			this.label = label;
			this.id = id;
		}
		
		public String label() {
			return label;
		}
		
		public int code() {
			return id;
		}
		
		private static Research findResearchByID(int id) {
			for (Research r : Research.values()) {
				if (r.id == id) {
					return r;
				}
			}
			
			return null;
		}
	}
	
	public Graduate() { }
	
	public Graduate(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		this.research = Research.findResearchByID(random.nextInt(Research.values().length)).label();
	}
	
	@Override
	public String toString() {
		return String.format("|대학원생|%s|%s|%s|%s|%s|%s|", this.no, this.name, this.date,
				this.phone, this.address, this.research);
	}
}

class Assistant extends Staff {
	public String part;
	
	private enum Part {
		PREDECESSOR("전임", 0),
		WORK("근로", 1),
		PARTTIME("시간제", 2);
		
		private final String label;
		private final int id;
		
		Part(String label, int id) {
			this.label = label;
			this.id = id;
		}
		
		public String label() {
			return label;
		}
		
		public int code() {
			return id;
		}
		
		private static Part findPartByID(int id) {
			for (Part p : Part.values()) {
				if (p.id == id) {
					return p;
				}
			}
			
			return null;
		}
	}
	
	public Assistant() { }
	
	public Assistant(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		this.part = Part.findPartByID(random.nextInt(Part.values().length)).label();
	}
	
	@Override
	public String toString() {
		return String.format("|조교|%s|%s|%s|%s|%s|%s|", this.no, this.name, this.date,
				this.phone, this.address, this.part);
	}
}

class Professor extends Staff {
	public String major;
	public String locationLab;
	
	private enum Major {
		NETWORK("네트워크", 0),
		SECURITY("정보보안", 1),
		DATABASE("데이터베이스", 2),
		AI("인공지능", 3),
		COMPUTER("컴퓨터공학", 4),
		SOFTWARE("소프트웨어공학", 5),
		DATASCIENCE("데이터과학", 6),
		BIOINFORMATICS("생명정보학", 7),
		CRYPTOGRAPHY("암호학", 8),
		GRAPHICS("컴퓨터그래픽스", 9);
		
		private final String label;
		private final int id;
		
		Major(String label, int id) {
			this.label = label;
			this.id = id;
		}
		
		public String label() {
			return label;
		}
		
		public int code() {
			return id;
		}
		
		private static Major findMajorByID(int id) {
			for (Major m : Major.values()) {
				if (m.id == id) {
					return m;
				}
			}
			
			return null;
		}
	}
	
	private String generateLabLocation() {
		enum Building {
			FIRST("제1공학관", 0),
			SECOND("제2공학관", 1);
			
			private final String label;
			private final int id;
			
			Building(String label, int id) {
				this.label = label;
				this.id = id;
			}
			
			public String label() {
				return label;
			}
			
			public int code() {
				return id;
			}
			
			private static Building findBuildingByID(int id) {
				for (Building b : Building.values()) {
					if (b.id == id) {
						return b;
					}
				}
				
				return null;
			}
		}
		
		Random random = new Random();
		
		int building = random.nextInt(Building.values().length);
		
		int room = (1 + random.nextInt(6)) * 100 +
				   (random.nextInt(2 + 1)) * 10 +
				   (random.nextInt(9 + 1));
		
		return String.format("%s %d호", Building.findBuildingByID(building).label, room);
	}
	
	public Professor() { }
	
	public Professor(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		this.major = Major.findMajorByID(random.nextInt(Major.values().length)).label();
		
		this.locationLab = generateLabLocation();
	}
	
	@Override
	public String toString() {
		return String.format("|교수|%s|%s|%s|%s|%s|%s|%s|", this.no, this.name, this.date,
				this.phone, this.address, this.major, this.locationLab);
	}
}

class MS extends Graduate {
	public int semester;
	
	public MS() { }
	
	public MS(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		this.semester = 1 + random.nextInt(4);
	}
	
	@Override
	public String toString() {
		return String.format("|석사|%s|%s|%s|%s|%s|%d|", this.no, this.name, this.date,
				this.phone, this.address, this.semester);
	}
}

class PhD extends Graduate {
	public int years;
	
	public PhD() { }
	
	public PhD(String no, String name, String date, String phone, String address) {
		super(no, name, date, phone, address);
		
		Random random = new Random();
		this.years = 1 + random.nextInt(6);
	}
	
	@Override
	public String toString() {
		return String.format("|박사|%s|%s|%s|%s|%s|%d|", this.no, this.name, this.date,
				this.phone, this.address, this.years);
	}
}