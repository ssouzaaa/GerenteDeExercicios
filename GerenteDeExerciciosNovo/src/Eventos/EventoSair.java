package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoSair implements ActionListener{
	
	private static final int DISPOSE_ON_CLOSE = 0;

	public void actionPerformed(ActionEvent e) {
		System.exit(DISPOSE_ON_CLOSE);
	}

}
