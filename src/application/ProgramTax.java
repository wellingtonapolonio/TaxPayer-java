package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Copany;
import entities.Individual;
import entities.TaxPayer;



public class ProgramTax {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int num = sc.nextInt();
		for (int i=1; i<=num; i++) {
			System.out.print("Tax payer #"+ i + " date:");
			System.out.print("Individual or company (i/c)? ");
			char xT = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income:");
			double income = sc.nextDouble();
			
			if (xT == 'i') {
				System.out.print("Health expenditures:");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditures));
				
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfE  = sc.nextInt();
				list.add(new Copany(name, income, numberOfE));
			}
			
		}
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer x : list) {
			double t = x.Tax();
			System.out.println(x.getName()+ " $"+ String.format("%.2f",t));
			sum+=t;
			
		}
		System.out.println();
		
		System.out.println("TOTAL TAXES: $"+ String.format("%.2f", sum));
		
		sc.close();

	}

}
