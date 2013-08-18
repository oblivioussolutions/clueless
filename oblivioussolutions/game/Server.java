package oblivioussolutions.game;
import java.util.HashSet;

//import java.awt.Dimension;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//import java.net.SocketException;
import java.util.ArrayList;

public class Server extends Thread {
	
	private Socket connection = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	private int playerNumber;
	private boolean isStillConnected;

	/**
	 * This constructor initializes the server by setting up all Object
	 * I/O to be used to communicate back and forth with this client.
	 * 
	 * @param initConnection - socket that is connected to a client
	 * @param initPlayerNumber - represents the player number for the
	 * client that will be communicated with by this thread
	 */
	public Server(Socket initConnection, int initPlayerNumber) {
		connection = initConnection;
		playerNumber = initPlayerNumber;
		try {
			OutputStream os = connection.getOutputStream();
			oos = new ObjectOutputStream(os);
			InputStream is = connection.getInputStream();
			ois = new ObjectInputStream(is);
			isStillConnected = connection.isConnected();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * This method restarts a game either after a draw or after a player has won.
	 */
	public void restartGame() {
		gameBoard.resetBoard();
		gameBoard = gameBoard.clone();
		CluelessNetworkObject outgoing = new CluelessNetworkObject(CluelessNetworkObject.GAME_BOARD, gameBoard);
		sendNetworkObjectToAll(outgoing);
	}

	/**
	 * This method listens for communications from the client handled by
	 * this thread and provides an adequate response such that the game
	 * progresses. Note that the server runs the game, the client is just 
	 * a thin client, so the server always has the true game board and is
	 * the only entity that may change it.
	 */
	public void run() {
		while (isStillConnected) {
			try {
				CluelessNetworkObject incoming = (CluelessNetworkObject)ois.readObject();
				CluelessNetworkObject outgoing;
				// HANDLE MOVES SENT BY CLIENT
				if (incoming.getType() == CluelessNetworkObject.MOVE) {
					if (playerNumber == gameBoard.getTurn()) {
						// ENFORCE LEGAL MOVES HERE, TEST FOR WINNER
						//Dimension move = (Dimension)incoming.getData();
						//ToDo: Need to test if the move is legal
						if (gameBoard.isLegalMove(/* need an input parameter*/)) {
							//gameBoard.chooseCell(move.width,move.height,gameBoard.getTurn());
							gameBoard = gameBoard.clone();
							outgoing = new CluelessNetworkObject(CluelessNetworkObject.GAME_BOARD, gameBoard);
							sendNetworkObjectToAll(outgoing);
						}
						// TEST FOR A WINNER
						if (gameBoard.getWinner() != CluelessBoard.NoWinner) {
							String winnerString;
							if (gameBoard.testWinner(CluelessBoard.player1)) {
	                            				winnerString = CluelessBoard.player1.getName();
							} else if (gameBoard.testWinner(CluelessBoard.player2) ) {
								winnerString = CluelessBoard.player2.getName();
							} else if (gameBoard.testWinner(CluelessBoard.player3) ) {
								winnerString = CluelessBoard.player3.getName();
							} else if (gameBoard.testWinner(CluelessBoard.player4) ) {
								winnerString = CluelessBoard.player4.getName();
							} else if (gameBoard.testWinner(CluelessBoard.player5) ) {
									winnerString = CluelessBoard.player5.getName();
							} else {
								winnerString = CluelessBoard.player6.getName();
							}
							outgoing = new CluelessNetworkObject(CluelessNetworkObject.WINNER, winnerString);
							sendNetworkObjectToAll(outgoing);
							restartGame();
						}
					}
				}
			}
			catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			catch(IOException ioe) {
				isStillConnected = false;
				CluelessNetworkObject gameInterruptedTTNO = new CluelessNetworkObject(CluelessNetworkObject.GAME_INTERRUPTED);
				sendNetworkObjectToAll(gameInterruptedTTNO);
				threads.clear();
			}
		}
	}
	
	/**
	 * This method is used to send a message to the client handled
	 * by this thread.
	 * 
	 * @param tttno - the network packet to be sent to the client
	 * handled by this thread.
	 */
	public void sendNetworkObject(CluelessNetworkObject tttno) {
		try {
			oos.writeObject(tttno);
		}
		catch(IOException ioe) {
			System.out.println("CLIENT DISCONNECTED, CANNOT SEND MESSAGE");
		}
	}
	
	///////////////////////////////////
	///// STATIC PORTION OF CLASS /////
	///////////////////////////////////

	private static ArrayList<Server> threads = new ArrayList<Server>();
	private static CluelessBoard gameBoard = null;

	/**
	 * This method is used to send a network packet object to all clients
	 * currently playing. It does this by going through each thread listening
	 * to a client and sends the object to each.
	 * 
	 * @param tttno - the network packet object to be sent to each client
	 */
	public static void sendNetworkObjectToAll(CluelessNetworkObject tttno) {
		for (int i = 0; i < 6; i++) {
			try {
				threads.get(i).sendNetworkObject(tttno);
			}
			catch(IndexOutOfBoundsException ioobe) {
				System.out.println("CLIENT REMOVED FROM LIST, CANNOT SEND MESSAGE");
			}
		}
	}

	/**
	 * This starts execution of the Server application by
	 * running the server and listening for connecting clients. When
	 * a client does attempt to connect, if there is room in the game,
	 * a thread is spawned to communicate with that client
	 * 
	 * @param args - command line arguments, not used in this application
	 */	
	public static void main(String[] args) {
		boolean canAcceptConnections = true;
		ServerSocket server = null;
		try {
			server = new ServerSocket(8000);
		}
		catch(IOException ioe) {
			canAcceptConnections = false;
		}

		while (canAcceptConnections) {
			try {
				Socket connection = server.accept();
				if (threads.size() < 6) {
					Server thread = new Server(connection, threads.size()+1);
					threads.add(thread);
					thread.start();
					if (threads.size() == 6) {
						CluelessNetworkObject no = new CluelessNetworkObject(CluelessNetworkObject.START_GAME);
						sendNetworkObjectToAll(no);
						gameBoard = new CluelessBoard();
					}
				}
				else {
					OutputStream out = connection.getOutputStream();
					ObjectOutputStream outObj = new ObjectOutputStream(out);
					CluelessNetworkObject no = new CluelessNetworkObject(CluelessNetworkObject.GAME_FULL);
					outObj.writeObject(no);
				}
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
