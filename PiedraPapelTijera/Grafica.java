package PiedraPapelTijera;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class Marco extends JFrame{
	public Marco() {
			
		setTitle("Piedra, Papel, Tijeras.  Javier Garcia Herrera");
		setSize(800,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//Agregamos la Lamina.
		Lamina miLamina= new Lamina();
		add(miLamina);
		
		setVisible(true);
	}
}
	

class Lamina extends JPanel implements ActionListener{
	

	String contadorH;
	String contadorB;
	JLabel contBot;
	JLabel contadorHuman;


	public Image ImagenFondo;
	public URL fondo;
	public Image ImagenVS;
	public URL urlVS;
	
	private JButton botonTijera;
	private JButton botonPiedra;
	private JButton botonPapel;
	
	
	JLabel piedra;
	JLabel papel;
	JLabel tijeras;
	
	JLabel piedraBot;
	JLabel papelBot;
	JLabel tijerasBot;
	
	JButton exportarPartida;
	
	public Lamina() {
			
		setLayout(null);
			
		//Fondo
		fondo=this.getClass().getResource("/PiedraPapelTijera/up.jpg");
		ImagenFondo= new ImageIcon(fondo).getImage();
			
	
		//Creaci�n de Botones
		 botonPiedra= new JButton("Piedra");
		 botonPapel= new JButton("Papel");
		 botonTijera= new JButton("Tijera");
		 
		add(botonPiedra);add(botonPapel);add(botonTijera);
		
	
		// Imagen de resultados
		 piedra = new JLabel(new ImageIcon("src/PiedraPapelTijera/piedra.png"));
		 piedra.setBounds(50, 50, 250, 250);
		 add(piedra);
		 piedra.setVisible(false);
		 
		 papel = new JLabel(new ImageIcon("src/PiedraPapelTijera/papel.png"));
		 papel.setBounds(30, 70, 250, 250);
		 add(papel);
		 papel.setVisible(false);
		 
		 tijeras = new JLabel(new ImageIcon("src/PiedraPapelTijera/tijeras.png"));
		 tijeras.setBounds(60, 80, 220, 220);
		 add(tijeras);
		 tijeras.setVisible(false);
		
		 
		// Imagen de resultados Bot
		 piedraBot = new JLabel(new ImageIcon("src/PiedraPapelTijera/piedra.png"));
		 piedraBot.setBounds(520, 80, 250, 250);
		 add(piedraBot);
		 piedraBot.setVisible(false);
				 
		 papelBot = new JLabel(new ImageIcon("src/PiedraPapelTijera/papel.png"));
		 papelBot.setBounds(520, 80, 250, 250);
		 add(papelBot);
		 papelBot.setVisible(false);
				 
		 tijerasBot = new JLabel(new ImageIcon("src/PiedraPapelTijera/tijeras.png"));
		 tijerasBot.setBounds(520, 80, 220, 220);
		 add(tijerasBot);
		 tijerasBot.setVisible(false);
		 
		 
		 
		 
		//Piedra
		botonPiedra.setSize(130,30);
		botonPiedra.setLocation(210, 355);
		botonPiedra.addActionListener(Boton1);
		
		
		//Papel
		botonPapel.setSize(130,30);
		botonPapel.setLocation(335,355);
		botonPapel.addActionListener(Boton2);
		
		//Tijeta
		botonTijera.setSize(120,30);
		botonTijera.setLocation(462,355);
		botonTijera.addActionListener(Boton3);
		
		
		//Fuentes
		Font comicSans= new Font("Comic Sans MS",1,30);
		
		
		//Marcadores y contador
		JLabel textoHumano= new JLabel();
		contadorHuman= new JLabel();
		textoHumano.setText("Marcador: ");
		textoHumano.setSize(300,60);
		textoHumano.setForeground(Color.orange.brighter());
		textoHumano.setLocation(20, 20);
		textoHumano.setFont(comicSans);
	
		contadorHuman.setText("0");
		contadorHuman.setSize(300,60);
		contadorHuman.setForeground(Color.white);
		contadorHuman.setLocation(195, 20);
		contadorHuman.setFont(comicSans);
		add(textoHumano);add(contadorHuman);
		
		//Este es el marcador del Bot
		JLabel textoBot= new JLabel();
		contBot= new JLabel();
		textoBot.setText("Marcador: ");
		textoBot.setSize(300,60);
		textoBot.setForeground(Color.orange.brighter());
		textoBot.setLocation(510, 20);
		textoBot.setFont(comicSans);
		
		contBot.setForeground(Color.white);
		contBot.setText("0");
		contBot.setSize(300,60);
		contBot.setLocation(685, 20);
		contBot.setFont(comicSans);
		add(textoBot);add(contBot);
		
		//Creamos un boton para exportar la partida
		exportarPartida= new JButton("Guardar");
		add(exportarPartida);
		exportarPartida.setBounds(300, 10, 100, 30);
		exportarPartida.addActionListener(Boton4);
		
		//Creamos un boton para importar la partida
		exportarPartida= new JButton("Cargar");
		add(exportarPartida);
		exportarPartida.setBounds(398, 10, 90, 30);
		exportarPartida.addActionListener(Boton5);	

		
}
		
		
	// Este PaintComponent pinta el Fondo
	public void paintComponent(Graphics graphic) {
		
		graphic.drawImage(ImagenFondo,0,0,getWidth(),getHeight(),null);
		
		//Simbolo VS
		graphic.drawImage(ImagenVS, 300, 70, 200, 200,null);
		setOpaque(false);
			
		File miImagenVS= new File("src/PiedraPapelTijera/2.png");
		
		// Capturamos las excepciones.
		try {
			ImagenVS= ImageIO.read(miImagenVS);
		} catch (IOException e) {
			System.out.println("No hay imagen");
		}	
		
	}
	
	// actualizamos contadores
	
	public void actualizarContador() {
		Icon iconoWinBot= new ImageIcon("src/PiedraPapelTijera/robotIcon.jpg");
		Icon iconoWinHuman= new ImageIcon("src/PiedraPapelTijera/hWin.jpg");
		
		contadorH= String.valueOf(Algoritmos.resultadoHumano());
		contadorB= String.valueOf(Algoritmos.resultadoBot());
		contadorHuman.setText(contadorH);
		contBot.setText(contadorB);
		
		// Pintamos cuando nos acerquemos a ganar
		if (Integer.parseInt(contadorH)>6 && Integer.parseInt(contadorH)<10 )
			contadorHuman.setForeground(Color.red);
		else if (Integer.parseInt(contadorH)==10) {
			Algoritmos.dameResHumano(0); Algoritmos.setResulBot(0);
			contadorHuman.setText("0");
			contBot.setText("0");
			contadorHuman.setForeground(Color.white);
			contBot.setForeground(Color.white);
			JOptionPane.showMessageDialog(getRootPane(), "", "Ganador: Humano", JOptionPane.PLAIN_MESSAGE, iconoWinHuman);
			
		}
		
		if (Integer.parseInt(contadorB)>6 && Integer.parseInt(contadorB)<10) 
			contBot.setForeground(Color.red);
		else if (Integer.parseInt(contadorB)==10) {
			Algoritmos.dameResHumano(0); Algoritmos.setResulBot(0);
			contadorHuman.setText("0");
			contBot.setText("0");
			contadorHuman.setForeground(Color.white);
			contBot.setForeground(Color.white);
			JOptionPane.showMessageDialog(getRootPane(), "", "Ganador: Bot", JOptionPane.PLAIN_MESSAGE, iconoWinBot);
		}
	}
	
	
	/*
	 * Creamos un pintado del resultado Bot.
	 */
	public void printBot() {
		int i= Algoritmos.getVBot();
		
		if (i==1)
			piedraBot.setVisible(true);
		else if (i==2)
			papelBot.setVisible(true);
		else
			tijerasBot.setVisible(true);
	}
	// limpiamos pantalla
	public void clearBot() {
		piedraBot.setVisible(false);
		papelBot.setVisible(false);
		tijerasBot.setVisible(false);
	}
	
	//Guardamos los datos de la partida
	public void guardarGame() throws IOException {
		FileOutputStream escribirFichero= new FileOutputStream("guardar1.txt");
		String marcadorGuardar=contadorH+" "+contadorB;
		for (int i=0;i<marcadorGuardar.length();i++)
			escribirFichero.write((int) marcadorGuardar.charAt(i));
		escribirFichero.close();
	}
	
	//Guardamos los datos de la partida
		public void cargarGame() throws IOException {
			FileInputStream leerFichero= new FileInputStream("guardar1.txt");
			int tam= leerFichero.available();
			int contadorHumano;
			int contadorBot;
			
			String c="";
			
			for (int i=0;i<tam;i++) {
				c+=(char) leerFichero.read();
			}
			leerFichero.close();
			
			contadorHumano= Integer.parseInt(c.substring(0,c.indexOf(" ")));
			contadorBot= Integer.parseInt(c.substring(c.indexOf(" ")+1));
			
			Algoritmos.dameResHumano(contadorHumano);
			Algoritmos.setResulBot(contadorBot);
			
			actualizarContador();
		}
	
	

	//Eventos de JButtons
	
	ActionListener Boton1= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			piedra.setVisible(true);
			printBot();
			Algoritmos.dameGanador(1);
			piedra.setVisible(false);
			clearBot();
			actualizarContador();
			
		}
	};

	ActionListener Boton2= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			papel.setVisible(true);
			printBot();
			Algoritmos.dameGanador(2);	
			papel.setVisible(false);
			clearBot();
			actualizarContador();
			
		}
	};
	
	ActionListener Boton3= new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tijeras.setVisible(true);
			printBot();
			Algoritmos.dameGanador(3);	
			tijeras.setVisible(false);
			clearBot();
			actualizarContador();
		}
	};
	
	ActionListener Boton4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				guardarGame();
				JOptionPane.showMessageDialog(null,"El juego se ha guardado correctamente");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	};
	
	ActionListener Boton5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				cargarGame();
				JOptionPane.showMessageDialog(null,"El juego se ha cargado correctamente");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	};
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	
}
	
	

public class Grafica {
	
	//metodo para sacar Interfaz Grafica
	public static Marco iniciarGame() {
		Marco miMarco= new Marco();
		return miMarco;
	}
}

