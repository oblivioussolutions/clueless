import java.io.Serializable;

public class CluelessNetworkObject implements Serializable {
	private int type;
	private Object data = null;
	
	/**
	 * Protocol message type that the server would send to all clients
	 * to let them know the game has just started. No data would be sent
	 * with this type of packet.
	 */
	public static final int START_GAME = 1;

	/**
	 * Protocol message type that the server would send to clients trying to
	 * connect to inform them that there is no room for that client to connect.
	 * No data is associated with this message. 
	 */
	public static final int GAME_FULL = 2;

	/**
	 * Protocol message type that the server would send to clients to inform
	 * them that the game has been interrupted, most likely due to one of the
	 * clients disconnecting from the server. No data is associated with this
	 * message.
	 */
	public static final int GAME_INTERRUPTED = 3;

	/**
	 * Protocol message type that the server would send to clients to inform
	 * them that a player has made a suggestion, most likely due to one of the
	 * clients disconnecting from the server. No data is associated with this
	 * message.
	 */
    public static final int Suggestion = 4;
    
    
	/**
	 * Protocol message type that the server would send to clients to inform
	 * them that a player has made an accusation, most likely due to one of the
	 * clients disconnecting from the server. No data is associated with this
	 * message.
	 */
    public static final int Accusation = 5;
        
	/**
	 * Protocol message type that the server would use to send the current
	 * game board to clients. The data associated with this packet would
	 * be the latest game board as managed by the server.
	 */
	public static final int GAME_BOARD = 11;
	
	/**
	 * Protocol message type that the client would use to send a move
	 * to the server. The data associated with this packet would be the info
	 * specifying the row & column of the cell chosen by that move.
	 */
	public static final int MOVE = 12;

	/**
	 * Protocol message type that the server would send to all clients to
	 * inform them that the game has been won. The data associated with this packet
	 * would be a String representing the player who won ("X" or "O").
	 */
	public static final int WINNER = 13;

	/**
	 * Protocol message type that the server would send to clients to inform
	 * them that the game has been reset, like at the end of a completed game.
	 * A brand new game board would be sent as data with this packet. 
	 */
	public static final int GAME_RESET = 14;
	
	/**
	 * Constructor to be used for network packets that will include messages,
	 * but no data.
	 * 
	 * @param initType - the type of message represented by this object.
	 */
	public CluelessNetworkObject(int initType) throws IllegalArgumentException {
		if ((initType < START_GAME) || (initType > Accusation))
			throw new IllegalArgumentException("Invalid type argument for a message only packet");
		type = initType;
	}
	
	/**
	 * Constructor to be used for network packets that will include both messages
	 * and data.
	 * 
	 * @param initType - the type of message represented by this object.
	 * @param initData - the data stored by this object packet.
	 */
	public CluelessNetworkObject(int initType, Object initData) throws IllegalArgumentException {
		if ((initType < GAME_BOARD) || (initType > GAME_RESET))
			throw new IllegalArgumentException("Invalid type argument for a message & data packet");
		data = initData;
		type = initType;
	}

	
	/**
	 * Accessor method for the data stored by this packet.
	 * 
	 * @return - the data stored by this packet as an Object. To use this data,
	 * one must cast it to its correct type.
	 */
	public Object getData() { return data; }

	/**
	 * Accessor method for the type of this packet.
	 * 
	 * @return - the type of this packet, which must match one of the protocol
	 * constants.
	 */
	public int getType() 	{ return type; }
}
