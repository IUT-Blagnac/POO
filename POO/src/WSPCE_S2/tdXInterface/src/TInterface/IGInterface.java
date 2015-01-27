package igdictionnaire;

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class IGQuit extends WindowAdapter implements ActionListener
{
	private IGInterface maFen;
	
	IGQuit (IGInterface m)
	{
		maFen = m;
	}

	public void actionPerformed (ActionEvent ae)
	{
		maFen.setVisible(false); 
		System.exit(0);
	}
	
	public void windowClosing(WindowEvent e)  
	{
		maFen.setVisible(false); 
		System.exit(0);
	}
}

class FJtJlLSL implements ListSelectionListener 
{
	private IGInterface jf;
	private JList jl;
	
	FJtJlLSL (IGInterface pjf, JList pjl)
	{
		this.jf=pjf;
		this.jl=pjl;
	}
	public void valueChanged(ListSelectionEvent e)  
	{
		int index = this.jl.getSelectedIndex ();
		if (index == -1)
			return ;
		JOptionPane.showMessageDialog (this.jf, this.jf.id.definitionMot((String)jl.getSelectedValue ()),
			 "D�finition de "+jl.getSelectedValue (), 
			JOptionPane.INFORMATION_MESSAGE);
	}
}

/************************************************************
    Classe d�finissant une interface graphique pour un dictionnaire.<BR>
    Le dictionnaire utilis� doit impl�menter l'interface InterfaceDictionnaire.<BR>
    
    @author	Andr� P�ninou.
	@version	1.2
	
	@see InterfaceDictionnaire
*****************************/

public class IGInterface extends JFrame
{
	JButton bQuitte;
	JList jl ;
	String [] mots;
	InterfaceDictionnaire id;

	/**
	 	Permet de construire une interface graphique de dictionnaire.<BR>
	 	<BR>
	 	N�cessite d'indiquer le dictionnaire � utiliser.<BR>
		Pour l'affichage, on utilisera la m�thode <BR>
		setVisible (boolean isVisible) h�rit�e de JFrame.
	 	<BR>

		@param		title	Le titre de la fen�tre.
		@param		pId		Objet impl�mentant l'interface InterfaceDictionnaire.
	*/
	
	
	public IGInterface (String title, InterfaceDictionnaire pId)
	{
		super(title);
		
		this.id=pId;
		

		this.setBounds (50, 20, 200, 500);

		JButton b;
		Container c;
		JLabel l;

		c = this.getContentPane();

		jl = new JList(this.id.listeMots());
		jl.addListSelectionListener(new FJtJlLSL (this, jl));
		JScrollPane js = new JScrollPane ();

		// JScrollPane : gestion des scroll bars
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Mise du JList dans le JScrollPane
		js.setViewportView (jl);

		c.add(js, BorderLayout.CENTER);


		bQuitte = new JButton ("Quitter");
		bQuitte.addActionListener ( new IGQuit ( this ) );
		c.add(bQuitte, BorderLayout.SOUTH);
		
		this.addWindowListener (new IGQuit (this) );

	}
}
