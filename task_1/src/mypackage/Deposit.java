package mypackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Deposit {
	String name; 		// имя
	String surname; 	// фамилия
	int id; 			// номер счета
	double amount; 		// размер депозита
	double percentage; 	// процент
	
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
	
	// Сортировка массива deposits (пузырьковая)
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
		// Массив объектов класса Deposit
		Deposit deposits[] = new Deposit[14];
		
		 deposits[0] = new Deposit("Андрей", "Романович", 7895, 10000, 5.5);
		 deposits[1] = new Deposit("Лена", "Елисеева", 123, 50000, 6.5);
		 deposits[2] = new Deposit("Коля", "Романов", 1234, 50000, 6.5);
		 deposits[3] = new Deposit("Вика", "Игнатова", 2345, 150000, 4.5);
		 deposits[4] = new Deposit("Денис", "Козлов", 3456, 10000, 6.5);
		 deposits[5] = new Deposit("Максим", "Масленников", 1234, 50000, 3.5);
		 deposits[6] = new Deposit("Роман", "Баранов", 4567, 500000, 3.4);
		 deposits[7] = new Deposit("Валерий", "Пяткина", 5678, 1250000, 6.7);
		 deposits[8] = new Deposit("Олеся", "Остапенко", 6789, 20000, 2.5);
		 deposits[9] = new Deposit("Костя", "Гурко", 7890, 55000, 7.5);
		 deposits[10] = new Deposit("Сережа", "Наумов", 7891, 120000, 2.52);
		 deposits[11] = new Deposit("Саша", "Потапов", 7892, 11000, 3.51);
		 deposits[12] = new Deposit("Рома", "Остапенко", 7893, 1000, 1.5);
		 deposits[13] = new Deposit("Алена", "Елисеева", 7894, 15000, 0.5);
	
		 // Сортировка массива по номеру счета
		 Sort(deposits, new Comparator<Deposit>() {
		        @Override
		        public int compare(Deposit o1, Deposit o2) {
		            return (o1.id - o2.id);
		        }
		    });
		 
		// Вывод отсортированного массива в консоль
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 System.out.printf("\n");
		 
		// Сортировка массива по размеру вклада
				 Sort(deposits, new Comparator<Deposit>() {
				        @Override
				        public int compare(Deposit o1, Deposit o2) {
				            return (int)((o1.amount - o2.amount)*100);
				        }
				    });
		 
		// Вывод отсортированного массива в консоль
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 System.out.printf("\n");
		 
		// Сортировка массива по проценту вклада
		 Sort(deposits, new Comparator<Deposit>() {
		        @Override
		        public int compare(Deposit o1, Deposit o2) {
		            return (int)((o1.percentage - o2.percentage)*100);
		        }
		    });
		 
		 // Вывод отсортированного массива в консоль
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 System.out.printf("\n");
		 
		// Сортировка массива по фамилии
		 Sort(deposits, new Comparator<Deposit>() {
		        @Override
		        public int compare(Deposit o1, Deposit o2) {
		            return o1.surname.compareTo(o2.surname);
		        }
		    });
		 
		// Вывод отсортированного массива в консоль
		 for (Deposit deposit: deposits) {
			 deposit.print();
		 }
		 
		 // Запись отсортированного массива в файл data.txt
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
