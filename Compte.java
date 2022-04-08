package asterisk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Compte extends JFrame implements ActionListener {
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField Num;
	private JPasswordField Password;
	private JTextField context;
	private JButton btnADD = new JButton("ADD");
	private JButton btnAnnuler=new JButton("Cancel");
	private JButton btnRemove = new JButton("Remove");
	private JLabel lblNum;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private String num,nom,prenom,password,cont;
	private boolean ex,no,per;
	public Compte()
	{
		

		setForeground(Color.CYAN);
		getContentPane().setBackground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/voip/Desktop/icon projet/asterisk-speech-bubble-trademark.png"));
		
		this.setTitle("Compte Asterrisk");
		this.setVisible(true);
		this.setSize(690,460); // taille de l'interface graphique	
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null); // fromat de layout(de l'interface)
		
		JLabel lblNewLabel_4 = new JLabel("Num");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(105, 26, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(105, 94, 78, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(105, 161,70, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(105, 220, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Context");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(105, 285, 70, 14);
		getContentPane().add(lblNewLabel_3);
		
		 lblNum = new JLabel();
		 lblNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblNum);
		lblNum.setForeground(Color.RED);
		lblNum.setBounds(272, 54, 131, 14);
		
		lblNom = new JLabel();
		lblNom.setForeground(Color.RED);
		lblNom.setBounds(272, 122, 131, 14);
		getContentPane().add(lblNom);
		
		lblPrenom = new JLabel();
		lblPrenom.setForeground(Color.RED);
		lblPrenom.setBounds(272, 189, 131, 14);
		getContentPane().add(lblPrenom);
		
		
		
		Num = new JTextField();
		Num.addKeyListener(new KeyAdapter() {
			
		
			public void keyReleased(KeyEvent e) {
				ex=false;
				
				if(Num.getText().matches("\\d{4}")==false || Num.getText().charAt(0)!='2')
				{
					lblNum.setText("inccorect Numero");
					ex=true;
					
				}else {
					
					lblNum.setText("");
				    
					ex=false;
				
				
				}
			
				
				
			}
		});
		
		
		/*Num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(verif_champ_Num()== true)
				{
					lblNum.setText("inccorect Numero");
					
				}else {lblNum.setText("valid");}
			}
		});*/
		
		
		
		/*Num.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent arg0) {
			lblNum.setText("");
			}
		});*/
		
		
		
		Num.setForeground(Color.BLACK);
		
		getContentPane().add(Num);
		Num.setToolTipText("Num");
		Num.setBounds(262, 23, 152, 20);
		Num.setColumns(10);
		Num.requestFocus();
		
		Nom = new JTextField();
		Nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				no=false;
				if(Nom.getText().matches("[a-zA-z]{3,10}")==false)
				{
					lblNom.setText("inccorect Nom");
					no=true;
					
				}else {
					
					lblNom.setText("");
					no=false;
				}
			}
		});
		
		Nom.setToolTipText("votre nom");
		Nom.setForeground(new Color(0, 0, 0));
		
		getContentPane().add(Nom);
		Nom.setColumns(10);
		Nom.setBackground(Color.WHITE);
		Nom.setBounds(262, 91, 152, 20);
		
		Prenom = new JTextField();
		Prenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(Prenom.getText().matches("[a-zA-z]{3,10}")==false)
				{
					lblPrenom.setText("inccorect Prenom");
					per=true;
					
				}else {
					
					lblPrenom.setText("");
					per=false;
				}
				
			}
		});
		
		getContentPane().add(Prenom);
		Prenom.setColumns(10);
		Prenom.setBackground(Color.WHITE);
		Prenom.setBounds(262, 158, 152, 20);
		
		Password = new JPasswordField();
		getContentPane().add(Password);
		Password.setBounds(262, 217, 152, 20);
		
		
		context = new JTextField();
		
		getContentPane().add(context);
		context.setColumns(10);
		context.setBackground(Color.WHITE);
		context.setFont(new Font("Tahoma", Font.PLAIN, 13));
		context.setBounds(262, 281, 152, 20);
		
		
		
		
		
		
		getContentPane().add(btnADD);
		
		btnADD.setBounds(105, 340, 121, 29);
		btnADD.setForeground(Color.BLACK);
		btnADD.setBackground(Color.WHITE);
		btnADD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnADD.setIcon(new ImageIcon("/home/voip/Desktop/icon projet/true-icon2.png.jpg"));
		
		btnADD.addActionListener(this) ;// pour ajouter un evennement lorsque en clique sur le boutton 
		
		
		
		
		
		getContentPane().add(btnAnnuler);
		
		btnAnnuler.setBounds(293, 340, 121, 29);
		
		
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnnuler.setIcon(new ImageIcon("/home/voip/Desktop/icon projet/false-icon2.jpg.png"));
		
		
		btnAnnuler.addActionListener(this);
		
		

		getContentPane().add(btnRemove);

		btnRemove.setBounds(467, 340, 121, 29);
		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setIcon(new ImageIcon("/home/voip/Desktop/icon projet/sup4-icon.jpg"));
		
		
	
		btnRemove.addActionListener(this);
		
		
	}

	
	
	//method pour vider les champs:
	
	public void vider_case() {
	
		Num.setText("");                                   //  lorsque en clique sur le boutton Remove
		Nom.setText("");                  //  on vider touts les champs avec le methode setText()
		Prenom.setText("");               //  
		Password.setText("");             //
		context.setText("");		
		
	}
	
	
	public boolean verif_champs()
	
	{
		if( Num.getText().isEmpty() || Nom.getText().isEmpty() || Prenom.getText().isEmpty() || Password.getText().isEmpty() ||  context.getText().isEmpty()   )
		
	{  

      return true;
	
	}else 
	
	{return false;}
	
	}

	
	/*public boolean verif_champ_Num()
	{
		if( Num.getText().matches("\\d{4}")==false || Num.getText().charAt(0)!='2')
		{
			
			return true;
			
			
		}else
		{
			
			return false;
		}
	}*/
	
	/*public boolean verif_champ_Nom()
	{
		if(Nom.getText().matches("[a-zA-z]{3,10}")==false)
		{
			return true;
			
			
		}else
			
		{
			return false;
			
		}
	}*/
	
	/*public boolean verif_champ_Prenom()
	{
		if(Prenom.getText().matches("[a-zA-z]{3,10}")==false)
		{
			return true;
			
			
		}else
			
		{
			return false;
			
		}
	}*/
	
	
	public void actionPerformed(ActionEvent event) {
	
		
		
		File users=new File ("/etc/asterisk/users.conf"); // instancé les fichier a utiliser
	   
//		File num_users=new File ("E:\\num"); 
	
		 if(event.getSource()==btnADD) // lorsque en clique sur le boutton ADD
		{	
	
	if(verif_champs()==true)
	{ 
		JOptionPane.showMessageDialog(this, "remplie touts les champs","champs vides", JOptionPane.ERROR_MESSAGE); 
	
	}else if(ex == true)
		
		{ 
		JOptionPane.showMessageDialog(this, "votre numero est incorrecte","Erreur", JOptionPane.ERROR_MESSAGE); 
				
			
		}/*else if(verif_champ_Num()== true)
	
	{
		lblNum.setText("inccorect Numero");
		Num.requestFocus();
		
	}*/else if(no== true)
	
	{ 
		JOptionPane.showMessageDialog(this, "votre nom est incorrecte","Erreur", JOptionPane.ERROR_MESSAGE); 
	
		
	}else if(per == true)
	
	{
	
		JOptionPane.showMessageDialog(this, "votre prenom est incorrecte","Erreur", JOptionPane.ERROR_MESSAGE);
		Prenom.requestFocus();
		
	
	}else{
			
	try {
		
		
		FileWriter fr=new FileWriter(users,true);
		PrintWriter pw=new PrintWriter(fr); 
		Scanner scan=new Scanner(users);
		
		/*FileWriter nr=new FileWriter(num_users,true);
		PrintWriter pn=new PrintWriter(nr);
		Scanner sc=new Scanner(num_users);
		*/
		//Scanner scan = new Scanner(num_users);
		//PrintWriter pr=new PrintWriter(fp);
		
		num=Num.getText();        // Stocké le contenu de champ Nemero dans le variable num
		nom=Nom.getText();    // Stocké le contenu de champ Prenom dans le variable prenom
		prenom=Prenom.getText();  
		password=Password.getText();
		cont=context.getText();
		//pn.println(num);
		   
		boolean exsist=false;
		while(scan.hasNextLine())
		{
			
			String contenu_fichier=scan.nextLine();
			
			if(contenu_fichier.contains(num)) 
			{
				exsist=true;
				
			}
			
		}
		
		if(exsist == true)
		{
			JOptionPane.showMessageDialog(this, "votre est deja exsiste","verifier votre numero", JOptionPane.ERROR_MESSAGE);
            		    
            Num.requestFocus();
            
		}else 
		{
		pw.println("["+num+"]"+"(template)");  // Ecrire le contenu de varibale Num dans le fichier users 
		pw.println("fullname ="+nom);          // Ecrire le contenu de varibale nom dans le fichier users
		pw.println("username ="+prenom);       
		pw.println("secret ="+password);
		pw.println("context ="+cont);
		pw.println("");      // pour faire une espace aprés chaque nouvelle compte
		
		vider_case();         //on vider touts les champs avec mon method vider_case()
		pw.close();             // fermer le fichier users
		
		JOptionPane.showMessageDialog(this, "registre successful");  // affichier un message de success lorsque l'enregistrement est bien effectue
		
		
		}
		//pn.println(num);  //Ecrire le contenu de varibale nom dans le fichier Num
		//pn.close();      // fermer le fichier Num
				
		
		
		
	} catch (IOException e) {
		e.printStackTrace();	}
	
		}
	
	    }else if(event.getSource()==btnRemove)  //  lorsque en clique sur le boutton Remove
		
		{      
			
			String numero=Num.getText();
			try {
				
				Scanner scan=new Scanner(users);
	
			 boolean exsist=false;
							
			while(scan.hasNextLine())
			{
				
				String contenu_fichier=scan.nextLine();
				

				if(contenu_fichier.contains(numero)) 
				{
				
					exsist=true;
				
					
					//pw.println(contenu_fichier);
					//pw.close();
				}
				
			}
			
			if(exsist == true)
			{
			
				//pw.println(numero);
				//pw.close();
				Num.setBackground(Color.RED);
				
			}else {JOptionPane.showMessageDialog(this, "cette compte  n'exsiste pas","verifier votre choix",JOptionPane.ERROR_MESSAGE);}
			
			
	} catch (IOException e) {e.printStackTrace();}
			
				

			
		}else {
			
			vider_case();                   //  on vider touts les champs avec le methode vider_case();
			
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
	
    Compte  c=new Compte();		
	
	}
}
