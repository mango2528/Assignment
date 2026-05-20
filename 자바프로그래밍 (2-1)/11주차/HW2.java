import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class HW2 {
	public static void main(String[] args) throws FileNotFoundException {
		File acc = new File(args[0]);
		File cus = new File(args[1]);
		
		if (!acc.exists() && !cus.exists()) {
			System.out.printf("%s, %s 파일 없음.", args[0], args[1]);
			System.exit(-1);
		}
		else if (!acc.exists() && cus.exists()) {
			System.out.printf("%s 파일 없음.", args[0]);
			System.exit(-1);
		}
		else if (acc.exists() && !cus.exists()){
			System.out.printf("%s 파일 없음.", args[1]);
			System.exit(-1);
		}
		
		Scanner scannerAcc = new Scanner(acc);
		Scanner scannerCus = new Scanner(cus);
		Scanner lineAcc;
		Scanner lineCus;
		
		Account[] accounts = new Account[1];
		Customer[] customers = new Customer[1];
		
		int indexAcc = 0;
		int indexCus = 0;
		
		while (scannerAcc.hasNextLine()) {
			lineAcc = new Scanner(scannerAcc.nextLine());
			
			if (indexAcc >= accounts.length) {
				accounts = Arrays.copyOf(accounts, accounts.length * 2);
			}
			
			accounts[indexAcc] = new Account(lineAcc.next(), lineAcc.next(), lineAcc.next(), lineAcc.nextInt());
			
			indexAcc++;
		}
		
		while (scannerCus.hasNextLine()) {
			lineCus = new Scanner(scannerCus.nextLine());
			
			if (indexCus >= customers.length) {
				customers = Arrays.copyOf(customers, customers.length * 2);
			}
			
			String[] temp = new String[1];
			int tempIndex = 0;
			
			customers[indexCus] = new Customer(lineCus.next(), lineCus.next(), lineCus.next(), lineCus.next(), lineCus.next(), temp);
			
			while (lineCus.hasNext()) {
				if (tempIndex == temp.length) {
					temp = Arrays.copyOf(temp, temp.length + 1);
				}
				
				temp[tempIndex] = lineCus.next();
				tempIndex++;
			}
			
			customers[indexCus].accounts = temp;
			
			indexCus++;
		}
		
		// ******************************
		
		accounts = trimArray(accounts);
		customers = trimArray(customers);
		transfer(findAccountByNO(accounts, args[3]), findAccountByNO(accounts, args[4]), Integer.parseInt(args[5]));
		// deposit(findAccountByNO(accounts, args[3]), Integer.parseInt(args[4]));
		// withdraw(findAccountByNO(accounts, args[3]), Integer.parseInt(args[4]));
		
		scannerAcc.close();
		scannerCus.close();
	}
	
	public static Account[] trimArray(Account[] arr) {
		Account[] temp = arr;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				temp = Arrays.copyOf(arr, i);
				return temp;
			}
		}
		
		return temp;
	}
	
	public static Customer[] trimArray(Customer[] arr) {
		Customer[] temp = arr;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				temp = Arrays.copyOf(arr, i);
				return temp;
			}
		}
		
		return temp;
	}
	
	public static Account findAccountByNO(Account[] arr, String no) {	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].no.equals(no)) {
				return arr[i];
			}
		}
		
		return new Account(no);
	}
	
	public static void print(Account[] acc, Customer[] cus) {		
		for (int i = 0; i < acc.length; i++) {
			System.out.println(acc[i]);
			
			for (int j = 0; j < cus.length; j++) {
				boolean flag = false;
				
				for (int k = 0; k < cus[j].accounts.length; k++) {
					if (acc[i].no.equals(cus[j].accounts[k])) {
						System.out.println(cus[j]);
						flag = true;
						break;
					}
				}
				
				if (flag) {
					break;
				}
			}
		}
	}
	
	public static void transfer(Account a, Account b, int amount) {
		if (a.isNull && b.isNull) {
			System.out.printf("계좌번호 %s, %s인 통장 없음.", a.no, b.no);
			System.exit(-1);
		}
		else if (a.isNull && !b.isNull) {
			System.out.printf("계좌번호 %s인 통장 없음.", a.no);
			System.exit(-1);
		}
		else if (!a.isNull && b.isNull){
			System.out.printf("계좌번호 %s인 통장 없음.", b.no);
			System.exit(-1);
		}
		
		if (a.balance < amount) {
			System.out.printf("<이체 %d원> ", amount);
			System.out.printf("[%s-%s:잔액(%d원)]", a.no, a.type, a.balance);
			System.out.printf(" 잔액부족. 이체 실패 !!!");
		}
		else {
			a.balance -= amount;
			b.balance += amount;
			
			System.out.printf("<이체 %d원> ", amount);
			System.out.printf("[%s-%s:잔액(%d원)]", a.no, a.type, a.balance);
			System.out.printf(" -> ");
			System.out.printf("[%s-%s:잔액(%d원)]", b.no, b.type, b.balance);
		}
	}
	
	public static void deposit(Account a, int amount) {
		if (a.isNull) {
			System.out.printf("계좌번호 %s인 통장 없음.", a.no);
			System.exit(-1);
		}
		
		int temp = a.balance;
		
		a.balance += amount;
		
		System.out.printf("<입금 %d원> ", amount);
		System.out.printf("[%s-%s:잔액(%d원)]", a.no, a.type, temp);
		System.out.printf(" -> ");
		System.out.printf("[%s-%s:잔액(%d원)]",a.no, a.type, a.balance);
	}
	
	public static void withdraw(Account a, int amount) {
		if (a.isNull) {
			System.out.printf("계좌번호 %s인 통장 없음.", a.no);
			System.exit(-1);
		}
		
		if (a.balance < amount) {
			System.out.printf("<출금 %d원> ", amount);
			System.out.printf("[%s-%s:잔액(%d원)]", a.no, a.type, a.balance);
			System.out.printf(" 잔액 부족. 출금 실패 !!!");
		}
		else {
			int temp = a.balance;
			
			a.balance -= amount;
			
			System.out.printf("<출금 %d원> ", amount);
			System.out.printf("[%s-%s:잔액(%d원)]", a.no, a.type, temp);
			System.out.printf(" -> ");
			System.out.printf("[%s-%s:잔액(%d원)]",a.no, a.type, a.balance);
		}
	}
}

class Account {
	String type;
	String no;
	String date;
	int balance;
	boolean isNull = false;
	
	public Account(String type, String no, String date, int balance) {
		this.type = type;
		this.no = no;
		this.date = date;
		this.balance = balance;
	}
	
	public Account(String no) {
		this.no = no;
		this.isNull = true;
	}
	
	public String toString() {
		return String.format("[%s-%s] 개설날짜[%s] 잔액[%d]", type, no, date, balance);
	}
	
	public static void printAccounts(Account[] arr) {
		for (Account a : arr) {
			System.out.println(a);
		}
	}
}

class Customer {
	String name;
	String no;
	String gender;
	String phone;
	String address;
	String[] accounts;
	
	public Customer(String name, String no, String gender, String phone, String address, String[] accounts) {
		this.name = name;
		this.no = no;
		this.gender = gender.equals("m") ? "남" : "여";
		this.phone = phone;
		this.address = address;
		this.accounts = accounts;
	}
	
	public String toString() {
		return String.format("	: 계좌주[%s[%s:%s] [전화:%s][주소:%s]]", name, no, gender, phone, address);
	}
	
	public static void printCustomers(Customer[] arr) {
		for (Customer c : arr) {
			System.out.println(c);
		}
	}
}