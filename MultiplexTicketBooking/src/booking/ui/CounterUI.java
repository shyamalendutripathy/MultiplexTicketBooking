package booking.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class CounterUI extends JFrame {

	private int counter=0;
	public CounterUI() {

		initUI();
	}
	 private void initUI() {
	        
	        setTitle("Movie Booking");
	        setSize(500, 400);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        
	        JButton button=new JButton("Click to Open Counter");
	        button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent actionevent) {
					BookingUI bookObj = new BookingUI(1);
					synchronized (CounterUI.class) {
						bookObj.impl(++counter);
					}
				}
			});

	        add(button);
	    }

}
