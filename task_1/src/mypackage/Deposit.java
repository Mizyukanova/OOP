package mypackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Deposit {
	String name; 		// ���
	String surname; 	// �������
	int id; 			// ����� �����
	double amount; 		// ������ ��������
	double percentage; 	// �������
	
	public Deposit(String name, String surname, int id, double amount, double percentage) {
		this.name=name;
		this.surname=surname;
		this.id=id;
		this.amount=amount;
		this.percentage=percentage;
	}
	
	void print() {
		System.out.printf("%15s %15s %04d %10.2f %5.2f\n", name, surname, id, amount, percentage);
	}
	
	void printToFile (PrintStream stream) {
		stream.printf("%15s %15s %04d %10.2f %5.2f\n", name, surname, id, amount, percentage);
	}
	
	// ���������� ������� deposits (�����������)
	static void Sort (Deposit[] deposits, Comparator<Deposit> comparator) {
		
		 for (int i = 0; i < deposits.length; i++)
		 {
			 int j_max = i;
			 for (int j = i + 1; j < deposits.length; j++)
			 {
				 if ( comparator.compare(deposits[j_max], deposits[j]) > 0)
				 {
					 j_max = j;
				 }
			 }	
			 Deposit temp = deposits[i];
			 deposits[i] = deposits[j_max];
			 deposits[j_max] = temp;
		 }	
	}
	
	public static void main(String[] args) {
		// ������ �������� ������ Deposit
		Deposit deposits[] = new Deposit[14];
		
		 deposits[0] = new Deposit("������", "���������", 7895, 10000, 5.5);
		 deposits[1] = new Deposit("����", "��������", 123, 50000, 6.5);
		 deposits[2] = new Deposit("����", "�������", 1234, 50000, 6.5);
		 deposits[3] = new Deposit("����", "��������", 2345, 150000, 4.5);
		 deposits[4] = new Deposit("�����", "������", 3456, 10000, 6.5);
		 deposits[5] = new Deposit("������", "�����������", 1234, 50000, 3.5);
		 deposits[6] = new Deposit("�����", "�������", 4567, 500000, 3.4);
		 deposits[7] = new Deposit("�������", "�������", 5678, 1250000, 6.7);
		 deposits[8] = new Deposit("�����", "���������", 6789, 20000, 2.5);
		 deposits[9] = new Deposit("�����", "�����", 7890, 55000, 7.5);
		 deposits[10] = new Deposit("������", "������", 7891, 120000, 2.52);
		 deposits[11] = new Deposit("����", "�������", 7892, 11000, 3.51);
		 deposits[12] = new Deposit("����", "���������", 7893, 1000, 1.5);
		 deposits[13] = new Deposit("�����", "��������", 7894, 15000, 0.5);
	
		 // ���������� ������� �� ������ �����
		 Sort(deposits, new Comparator<Deposit>() {
		        @Override
		        public int compare(Deposit o1, Deposit o2) {
		            return (o1.id - o2.id);
		        }
		    });
		 
		// ����� ���������������� ������� � �������
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 System.out.printf("\n");
		 
		// ���������� ������� �� ������� ������
				 Sort(deposits, new Comparator<Deposit>() {
				        @Override
				        public int compare(Deposit o1, Deposit o2) {
				            return (int)((o1.amount - o2.amount)*100);
				        }
				    });
		 
		// ����� ���������������� ������� � �������
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 System.out.printf("\n");
		 
		// ���������� ������� �� �������� ������
		 Sort(deposits, new Comparator<Deposit>() {
		        @Override
		        public int compare(Deposit o1, Deposit o2) {
		            return (int)((o1.percentage - o2.percentage)*100);
		        }
		    });
		 
		 // ����� ���������������� ������� � �������
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 System.out.printf("\n");
		 
		// ���������� ������� �� �������
		 Sort(deposits, new Comparator<Deposit>() {
		        @Override
		        public int compare(Deposit o1, Deposit o2) {
		            return o1.surname.compareTo(o2.surname);
		        }
		    });
		 
		// ����� ���������������� ������� � �������
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 
		 // ������ ���������������� ������� � ���� data.txt
		 try {
			 PrintStream out = new PrintStream(new File("D:/data.txt"));
			 for (Deposit deposit: deposits)
			 {
				 deposit.printToFile(out);
			 }
		 } catch (FileNotFoundException e) {
			 System.err.println(e.getMessage());
		 }
	}
}
