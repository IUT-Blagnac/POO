package TBase;

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class IGQuit extends WindowAdapter implements ActionListener
{
	protected IGDeBase maFen;
	
	IGQuit (IGDeBase m)
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
	private IGDeBase jf;
	private JList jl;
	
	FJtJlLSL (IGDeBase pjf, JList pjl)
	{
		jf=pjf;
		jl=pjl;
	}
	public void valueChanged(ListSelectionEvent e)  
	{
		int index = jl.getSelectedIndex ();
		if (index == -1)
			return ;
		String x;
		x = "Définition : ...........";
		JOptionPane.showMessageDialog (jf, x, "Définition de "+jl.getSelectedValue (), 
			JOptionPane.INFORMATION_MESSAGE);
	}
}


public class IGDeBase extends JFrame
{
	JButton bQuitte;
	JList jl ;
	Vector v;
	
	public IGDeBase (String title)
	{
		super(title);

		setBounds (50, 20, 200, 500);

		JButton b;
		Container c;
		JLabel l;

		c = this.getContentPane();

		// Valeurs du JList
		v = new Vector();
		v.add("Test1");
		v.add("Test2");

		jl = new JList(v);
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
