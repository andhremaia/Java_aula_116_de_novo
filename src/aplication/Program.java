package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {
	public static void main(String args[]) throws ParseException {
		
		//Declaração dos objetos
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		Worker worker;
		HourContract contract;
		Department department;
		
		//Entradas dos dados do trabalhador
		System.out.print("Enter department name: ");
		String departmentName = sc.next();
		department = new Department(departmentName);
		System.out.print("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.next();
		System.out.print("Leve: ");
		String level = sc.next();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		//Cria um novo trabalhador e preenche seus campos com os dados que o usuario digitou
		worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, department);
		
		
		//Entrada dos dados do contrato do trabalhador
		System.out.println("How many contracts to this worker: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i ++) {
			System.out.print("Enter contract #" + (1 + i) + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
		    date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duratio (hours): ");
			int hours = sc.nextInt();
			
			//Cria o contrato com os dados que o usuario digitou
			contract = new HourContract(date, valuePerHour, hours);
			
			//Adiciona o contrato a lista de contrato do trabalhador
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));
		sc.close();
		
		
	}
}
