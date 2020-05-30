package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Horarios;

public class Program {

public static void main(String[] args) {
	
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	String horario="",dla="";
	char c='s';
	
	while (c != 'n') {
		try {
			System.out.printf("Digite o horario do Voo 'HHMM':  ");
				horario = sc.next();
			
			System.out.print("Digite quantos minutos sera a DLA 'HHMM': ");
				dla = sc.next();
			
			Horarios horarios = new Horarios(horario,dla);
				
			System.out.println("----------------------------------------");
			System.out.println(horarios);
			
			
			}
		catch (NumberFormatException e) {
			System.out.println("Erro de formato... "
		 	   		+ "\n"
		 			+ "digite como no exemplo! \n"
		 	   		+ e.getMessage());
		    }
		System.out.println("----------------------------------------");
		System.out.print("Deseja repetir (s/n)? ");
		c = sc.next().charAt(0);
		Horarios.clearScreen();;
		
	}
	sc.close();
}

}

   