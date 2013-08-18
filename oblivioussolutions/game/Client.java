package oblivioussolutions.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Client extends JFrame implements ActionListener, Runnable{
	private CluelessBoard board = new CluelessBoard();
	private Socket connection = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	private Thread runner = null;
	private boolean gameStarted = false;
	private boolean isStillPlaying = false;
	
	public Client() {
		super("Clueless ");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupGUI();
		connect();
	}
	
	/**
	 * This method connects to the TicTacToeServer and sets
	 * up all I/O streams to send and get information.
	 */
	private void connect() {
		try {			
			connection = new Socket("localhost", 8000);
			OutputStream os = connection.getOutputStream();
			oos = new ObjectOutputStream(os);
			InputStream is = connection.getInputStream();
			ois = new ObjectInputStream(is);
			isStillPlaying = true;
			this.start();}
			catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "Server Refused Connection - closing");
			isStillPlaying = false; 			
		}
		
	}
	
	/**
	 * This method initializes the runner Thread, specifying that
	 * the run method to use for the new Thread will be found inside
	 * this class.
	 */
	private void start() {
		runner = new Thread(this);
		runner.start();
	}

	private void setupGUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isStillPlaying) {
			try {
				CluelessNetworkObject data = (CluelessNetworkObject)ois.readObject();
				// INFORM USER THAT GAME HAS STARTED
				if (data.getType() == CluelessNetworkObject.START_GAME) {
					gameStarted = true;
					JOptionPane.showMessageDialog(this, "GAME HAS STARTED");
				}
				// UPDATE THE BOARD
				else if (data.getType() == CluelessNetworkObject.GAME_BOARD) {
					CluelessBoard updatedBoard = (CluelessBoard)data.getData();
					updateBoard(updatedBoard);
				}
				
				// Do we need seperate state for Accusation or Suggestions?
				
				// DISLPAY WINNER
				else if (data.getType() == CluelessNetworkObject.WINNER) {
					String winner = (String)data.getData();
					JOptionPane.showMessageDialog(this, winner + " is the winner!");
				}
				// INFORM USER THAT BID TO CONNECT WAS REJECTED, GAME FULL
				else if (data.getType() == CluelessNetworkObject.GAME_FULL) {
					JOptionPane.showMessageDialog(this, "Game Full");
					isStillPlaying = false;
				}
				// OTHER PLAYER DISCONNECTED, SO END APPLICATION
				else if (data.getType() == CluelessNetworkObject.GAME_INTERRUPTED) {
					JOptionPane.showMessageDialog(this, "Game Interrupted");
					isStillPlaying = false;
				}
			}
			catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			catch(IOException ioe) {
				// SERVER HAS DISCONNECTED, SO NOTIFY USER AND CLOSE APPLICATION
				isStillPlaying = false;
				JOptionPane.showMessageDialog(this, "SERVER DISCONNECTED");
			}
		}
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateBoard(CluelessBoard updatedBoard) {
		board = updatedBoard;
		// TODO update the board;
	}
	
	/**
	 * This starts execution of the Client application by
	 * constructing the GUI and setting it visible. This starts
	 * the application into event handling mode.
	 * @param args - command line arguments, not used in this application
	 */
	public static void main(String args[]) {
		Client frame = new Client();
		frame.setVisible(true);
	}

}
