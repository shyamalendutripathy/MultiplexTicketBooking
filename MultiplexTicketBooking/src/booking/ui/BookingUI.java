package booking.ui;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import MovieBooking.MovieImpl;
import counter.CounterThread;
import counter.CustomerObj;

public class BookingUI {
	private JFrame mainFrame;
	private JPanel controlPanel;
	private JTextArea area;
	private JTextField windowField;
	private JTextField totalField;
	private JButton bookBtn;
	private int counterId;

	public BookingUI(){
		//		prepareGUI(i);
	}

	public BookingUI(int i){
		//		prepareGUI(i);
	}
	public void impl(int i){
		this.counterId=i;
		prepareGUI(i);
		showGridLayoutDemo();

	}
	private void prepareGUI(int i){
		mainFrame = new JFrame("Counter "+i);
		mainFrame.setSize(900,900);
		mainFrame.setLayout(new GridLayout(2,1));


		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(controlPanel);
	}
	private void showGridLayoutDemo(){

		JPanel panel = new JPanel(new GridLayout(4,2));
		//		panel.setBackground(Color.darkGray);
		panel.setSize(300,300);

		JLabel label=new JLabel("Window Seats");
		windowField=new JTextField("");
		panel.add(label); 
		panel.add(windowField); 

		label=new JLabel("Total Seats");
		totalField=new JTextField("");

		panel.add(label);
		panel.add(totalField); 

		bookBtn=new JButton("Book");
		panel.add(bookBtn);
		//		label=new JLabel("");
		JButton btn1=new JButton("View All Tickets");
		//		panel.add(label);
		panel.add(btn1);


		controlPanel.add(panel);

		area=new JTextArea();
		JScrollPane scrollPane = new JScrollPane(area);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.add(area);


		mainFrame.add(area);
		//		area.setEnabled(false);

		mainFrame.setVisible(true);  

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionevent) {
				getSeats();
			}
		});

		bookBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionevent) {

				CustomerObj beanObj=new CustomerObj();
				String str=windowField.getText().trim();
				int val1=Integer.parseInt(str);
				int val2=Integer.parseInt(totalField.getText().trim());
				beanObj.setWindowSeat(val1);
				beanObj.setTotalSeat(val2);

				CounterThread counterthread=new CounterThread(beanObj, "book", counterId);

				Thread thread= new Thread(counterthread);
				thread.start();

			}
		});
	}

	public void notifyUI(boolean isBookedFlag){
		if(!isBookedFlag){
			JOptionPane.showMessageDialog(new JFrame(), "Unable To bbook Tickets", "Dialog",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(new JFrame(), "Booking Successful", "Dialog",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private void getSeats(){
		MovieImpl impl=MovieImpl.getInstance();
		String str=impl.getTotalSeat();
		area.setText(str);
	}
}
