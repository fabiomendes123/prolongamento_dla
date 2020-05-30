package entities;

public class Horarios {

	public String takeOff;
	public String totalMinuts;
	
	public Horarios(String takeOff, String totalMinuts) {
		this.takeOff = takeOff;
		this.totalMinuts = totalMinuts;
	}
	public String getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(String takeOff) {
		this.takeOff = takeOff;
	}
	public String getTotalMinuts() {
		return totalMinuts;
	}
	public void setTotalMinuts(String totalMinuts) {
		this.totalMinuts = totalMinuts;
	}

	
	public int newTakeoffHr () {
		int novahr=0;
		
		String mm1 = takeOff.substring(2, 4);
	    String hh1 = takeOff.substring(0, 2);
	    String dla1m = totalMinuts.substring(2, 4);
	    String dla2h = totalMinuts.substring(0, 2);
	    
	    int min1 = Integer.valueOf(mm1);
	    int hor1 = Integer.valueOf(hh1);
	    int dlatimemin = Integer.valueOf(dla1m);
	    int dlatimehor = Integer.valueOf(dla2h);
	    
	    if (dlatimehor<1 && dlatimemin<46){
			   System.out.println("Valor inferior a 46 minutos ");
	   			}

	    else if ((dlatimemin+min1)<60 && dlatimehor==0) {
		   	novahr = (hor1);
           	}
	   else if ((dlatimemin+min1)>=60 && dlatimehor>=1) {
		   	novahr = (hor1+dlatimehor+1);
		   	}
	   else if ((dlatimemin+min1)>=60 && dlatimehor<1) {
	   	   novahr = (hor1+1);
		   }
	   else if ((dlatimemin+min1)<60 && dlatimehor>0) {
       		novahr = (hor1+dlatimehor);
       	   }
	   if (novahr>=24) {
	   novahr=novahr-24;
	   }
	   return novahr;
			   
	}
	public int newTakeoffMin () {
		int novomin=0;
		String mm1 = takeOff.substring(2, 4);
	    String dla1m = totalMinuts.substring(2, 4);
	    String dla2h = totalMinuts.substring(0, 2);
	    
	    int min1 = Integer.valueOf(mm1);
	    int dlatimemin = Integer.valueOf(dla1m);
	    int dlatimehor = Integer.valueOf(dla2h);
	    
	    if (dlatimehor<1 && dlatimemin<46){
			   System.out.println("favor recomeçar...");
	   			}
		
	    else if ((dlatimemin+min1)<60 && dlatimehor==0) {
		   	novomin = (min1+dlatimemin);
           	}
	   else if ((dlatimemin+min1)>=60 && dlatimehor>=1) {
		   	novomin = (dlatimemin+min1-60);
		   	}
	   else if ((dlatimemin+min1)>=60 && dlatimehor<1) {
	   	   novomin = (dlatimemin+min1-60);
		   }
	   else if ((dlatimemin+min1)<60 && dlatimehor>0) {
       		novomin = (min1+dlatimemin);
       	   }
	return novomin;    
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NOVO HORARIO: ");
		sb.append(newTakeoffHr() +" Horas " + newTakeoffMin() + " Minutos\n ");
		sb.append("---------------------------------------\n");
		sb.append("NOVO HORARIO ZULU: ");
		sb.append((newTakeoffHr()+3) +" Horas (+3) " + newTakeoffMin() + " Minutos\n ");
		return sb.toString();
	
	}
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");  //cls
		System.out.flush();
	}
}