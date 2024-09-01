package calculadora;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class calculadora2 extends JFrame  {
	
	//arranque
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora2 frame = new calculadora2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	double resultado;
	private JButton ac,del,equal,suma,rest,mult,division,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bpunt; //botones operativos
	private JTextField display;
	
	public calculadora2() { // constructor de la ventana 
		setTitle("Calculadora");//como es metodo inicia en minus y cuando hay espacio usas mayus,los parentesis tienen los parametros
		setLayout(null); // para no usar plantillas,las plantillas permiten tener caracteristicas preconfiguradas
		setBounds(100,100,330,650); //Se puede rellenar con 4 valores  enteros,si no tienes plantillas,usas pixeles : posicion en eje X,posicion eje Y,Ancho,Alto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//es para poder tener la posibilidad de cerrar la ventana,para tener el boton y no crear demonios
		setResizable(false);// si es true puedes cambiar el tamano,si es false no puedes
		setLocationRelativeTo(null); //en set bounds puedes poner en 0 valor X y Y
		getContentPane().setBackground(Color.DARK_GRAY);

		
		
		//elementos de la ventana
		
		display= new JTextField();//invocas el constructor
		display.setBounds(10,10,300,125);
		display.setBackground(new Color(28,76,150)); //fondo
		display.setForeground(Color.WHITE); //letra
		display.setHorizontalAlignment(JTextField.RIGHT); //texto centrado
		display.setFont(new Font("Arial", Font.BOLD, 55)); // fuente y tamano con negrila
		display.setBackground(Color.DARK_GRAY);
		display.setEditable(false); //para que no se pueda usar el teclado en el display
		/*int thickness = 3; // Grosor del borde en píxeles,creas una variable y esa la metes en .setBorder
		display.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, thickness)); //borde gris con grosor
		display.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //borde gris*/
		display.setBorder(BorderFactory.createEmptyBorder()); //para que no tenga borde
		add(display);
		
		//primera fila de botones
		ac= new JButton("AC");//invocas el constructor
		ac.setBounds(50,180,45,45);
		ac.setBorder(null); //para quitar los bordes
		ac.setBackground(Color.GRAY); // para color de fondo import java.awt.Font;
		ac.setForeground(Color.WHITE); // color de texto importar import java.awt.Color;
	    ac.setFont(new Font("Roboto", Font.BOLD, 28)); //tipo de texto y en negrilla
	    ac.addActionListener(new ActionListener() { //hacer acciones con los botones
	        public void actionPerformed(ActionEvent e) { //lo llamas cuando hay eventos con los botones
	            display.setText(" "); //que cuando el boton se presione,se vacie el jtextfield
	        }
	    });
		add(ac);

		del= new JButton("DEL");
		del.setBounds(140,180,45,45);
		del.setBorder(null); 
		del.setBackground(Color.GRAY); 
		del.setForeground(Color.WHITE); 
		del.setFont(new Font("Roboto", Font.BOLD, 20));
		del.addActionListener(new ActionListener() { //permite hacer acciones en los botones
		    public void actionPerformed(ActionEvent e) { //Este es el método actionPerformed que se llama cuando ocurre un evento de acción en el botón.
		        String currentText = display.getText(); //Esta línea obtiene el texto actual en el cuadro de texto display y lo almacena en la variable currentText.
		        if (currentText.length() > 0) { //Esta línea verifica si la longitud del texto actual en el cuadro de texto display es mayor que 0.
		            display.setText(currentText.substring(0, currentText.length() - 1)); //Si la longitud del texto actual en el cuadro de texto display es mayor que 0, esta línea establece el texto en el cuadro de texto como el texto actual menos el último carácter.
		        }
		    }
		});
		add(del);
		
		equal= new JButton("=");
		equal.setBounds(230,180,45,45);
		equal.setBorder(null); 
		equal.setBackground(Color.GRAY); 
		equal.setForeground(Color.WHITE); 
		equal.setFont(new Font("Roboto", Font.BOLD, 28));
		add(equal);
		
		equal.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { //hacer acciones con los botones
		        String currentText = display.getText(); //lo que este impreso en ese display,se almacena en la variable current text
		        if (currentText.contains("+")) { //ve si hay un + para separar las cantidades en 2 strings
		            String[] numbers = currentText.split("\\+");//divide en dos strings apenas vea ese signo
		            float result = Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]); //hace la operacion
		            display.setText(String.valueOf(result)); //imprime la variable result que contiene la respuesta
		        } else if (currentText.contains("-")) { //ve si hay un - para separar las cantidades en 2 strings
		            String[] numbers = currentText.split("-"); //divide en dos strings apenas vea ese signo
		            float result = Float.parseFloat(numbers[0]) - Float.parseFloat(numbers[1]);//hace la operacion
		            display.setText(String.valueOf(result));//imprime la variable result que contiene la respuesta
		        } else if (currentText.contains("x")) {//ve si hay un * para separar las cantidades en 2 strings
		            String[] numbers = currentText.split("x");//divide en dos strings apenas vea ese signo 
		            float result = Float.parseFloat(numbers[0]) * Float.parseFloat(numbers[1]);//hace la operacion
		            display.setText(String.valueOf(result));//imprime la variable result que contiene la respuesta
		        } else if (currentText.contains("/")) {//divide en dos strings apenas vea ese signo 
		            String[] numbers = currentText.split("/"); //ve si hay un / para separar las cantidades en 2 strings
		            float result = Float.parseFloat(numbers[0]) / Float.parseFloat(numbers[1]);//hace la operacion
		            display.setText(String.valueOf(result));//imprime la variable result que contiene la respuesta
		        }
		    }
		});
		
		//segunda fila
		suma= new JButton("+");
		suma.setBounds(50,245,45,45);
		suma.setBorder(null); 
		suma.setBackground(Color.GRAY); 
		suma.setForeground(Color.WHITE); 
		suma.setFont(new Font("Roboto", Font.BOLD, 28));
		suma.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "+");
		    }
		});

		add(suma);
		
		
		
		rest= new JButton("-");
		rest.setBounds(140,245,45,45);
		rest.setBorder(null); 
		rest.setBackground(Color.GRAY); 
		rest.setForeground(Color.WHITE); 
		rest.setFont(new Font("Roboto", Font.BOLD, 28));
		rest.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "-");
		    }
		});
		add(rest);
		
		mult= new JButton("X");
		mult.setBounds(230,245,45,45);
		mult.setBorder(null); 
		mult.setBackground(Color.GRAY); 
		mult.setForeground(Color.WHITE); 
		mult.setFont(new Font("Roboto", Font.BOLD, 28));
		mult.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "x");
		        
		    }
		});
		add(mult);
		
		//tercera fila
		
		division= new JButton("/");
		division.setBounds(50,310,45,45);
		division.setBorder(null); 
		division.setBackground(Color.GRAY); 
		division.setForeground(Color.WHITE); 
		division.setFont(new Font("Roboto", Font.BOLD, 28));
		division.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "/");
		    }
		});
		add(division);
		
		b0= new JButton("0");
		b0.setBounds(140,310,45,45);
		b0.setBorder(null); 
		b0.setBackground(Color.GRAY); 
		b0.setForeground(Color.WHITE); 
		b0.setFont(new Font("Roboto", Font.BOLD, 28));
		b0.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "0");
		    }
		});
		add(b0);
		
		bpunt= new JButton(".");
		bpunt.setBounds(230,310,45,45);
		bpunt.setBorder(null); 
		bpunt.setBackground(Color.GRAY); 
		bpunt.setForeground(Color.WHITE); 
		bpunt.setFont(new Font("Roboto", Font.BOLD, 28));
		bpunt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + ".");
		    }
		});
		add(bpunt);
		
		//cuarta fila 
		
		b1 = new JButton("1");
		b1.setBounds(50, 375, 45, 45);
		b1.setBorder(null);
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Arial", Font.BOLD, 28));
		b1.addActionListener(new ActionListener() { //esto permite imprimir el numero que tu quieres,es una interfaz que permite  recibir eventos de acción. Cuando ocurre un evento de acción en el botón (por ejemplo, cuando se presiona el botón), se llama al método actionPerformed del ActionListener 
		    public void actionPerformed(ActionEvent e) { //Este es el método actionPerformed que se llama cuando ocurre un evento de acción en el botón.
		        display.setText(display.getText() + "1"); //Esta línea establece el texto en el cuadro de texto display como el texto actual más “1”. En otras palabras, cuando se presiona el botón b1, se agrega “1” al final del texto actual en el cuadro de texto display.
		    }
		});
		add(b1);

		
		b2= new JButton("2");
		b2.setBounds(140,375,45,45);
		b2.setBorder(null); 
		b2.setBackground(Color.GRAY); 
		b2.setForeground(Color.WHITE); 
		b2.setFont(new Font("Arial", Font.BOLD, 28));
		b2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "2");
		    }
		});
		add(b2);
		
		b3= new JButton("3");
		b3.setBounds(230,375,45,45);
		b3.setBorder(null); 
		b3.setBackground(Color.GRAY); 
		b3.setForeground(Color.WHITE); 
		b3.setFont(new Font("Arial", Font.BOLD, 28));
		b3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "3");
		    }
		});
		add(b3);
		
		// quinta fila
		
		b4= new JButton("4");
		b4.setBounds(50,440,45,45);
		b4.setBorder(null); 
		b4.setBackground(Color.GRAY); 
		b4.setForeground(Color.WHITE); 
		b4.setFont(new Font("Arial", Font.BOLD, 28));
		b4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "4");
		    }
		});
		add(b4);
		
		b5= new JButton("5");
		b5.setBounds(140,440,45,45);
		b5.setBorder(null); 
		b5.setBackground(Color.GRAY); 
		b5.setForeground(Color.WHITE); 
		b5.setFont(new Font("Arial", Font.BOLD, 28));
		b5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "5");
		    }
		});
		add(b5);
		
		b6= new JButton("6");
		b6.setBounds(230,440,45,45);
		b6.setBorder(null); 
		b6.setBackground(Color.GRAY); 
		b6.setForeground(Color.WHITE); 
		b6.setFont(new Font("Arial", Font.BOLD, 28));
		add(b6);
		b6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "6");
		    }
		});
		//sexta fila
		
		b7= new JButton("7");
		b7.setBounds(50,505,45,45);
		b7.setBorder(null); 
		b7.setBackground(Color.GRAY); 
		b7.setForeground(Color.WHITE); 
		b7.setFont(new Font("Arial", Font.BOLD, 28));
		b7.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "7");
		    }
		});
		add(b7);
		
		b8= new JButton("8");
		b8.setBounds(140,505,45,45);
		b8.setBorder(null); 
		b8.setBackground(Color.GRAY); 
		b8.setForeground(Color.WHITE); 
		b8.setFont(new Font("Arial", Font.BOLD, 28));
		b8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "8");
		    }
		});
		add(b8);
		
		b9= new JButton("9");
		b9.setBounds(230,505,45,45);
		b9.setBorder(null); 
		b9.setBackground(Color.GRAY); 
		b9.setForeground(Color.WHITE); 
		b9.setFont(new Font("Arial", Font.BOLD, 28));
		b9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        display.setText(display.getText() + "9");
		    }
		});
		add(b9);
		
		
	}


	

}
