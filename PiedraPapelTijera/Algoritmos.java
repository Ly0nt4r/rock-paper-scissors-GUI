package PiedraPapelTijera;

import javax.swing.JOptionPane;

public class Algoritmos {
	
	 static int resulBot=0;
	 static int resulHuman=0;
	 
	 static int valBot = (int) (Math.random()*3+1);;
	
	public static int getVBot() {
		return valBot;
	}
	
	public static int resultadoHumano() {
		return resulHuman;
	}
	public static int resultadoBot() {
		return resulBot;
	}
	
	public static int dameResHumano(int i) {
		return Algoritmos.resulHuman=i;
	}
	
	public static void dameGanador(int valor) { 
		
		
		int valorHumano=valor;
		int valorBot=valBot;
		
		
		// PIEDRA (1) - PAPEL (2) - TIJERA (3)
		
		if (valorHumano==valorBot)
			JOptionPane.showMessageDialog(null, "EMPATE!");
		else if (valorHumano==1 && valorBot==3 || valorHumano==2 && valorBot==1 || valorHumano==3 && valorBot==2) {
			JOptionPane.showMessageDialog(null, "Ganador PLAYER!"); resulHuman++;
		}
		else if (valorHumano==1 && valorBot==2 || valorHumano==2 && valorBot==3 || valorHumano==3 && valorBot==1) {
			JOptionPane.showMessageDialog(null, "Ganador BOT!"); resulBot++;
		}
		
		valBot= (int) (Math.random()*3+1);
	}


	public static void setResulBot(int resulBot) {
		Algoritmos.resulBot = resulBot;
	}
	
}
