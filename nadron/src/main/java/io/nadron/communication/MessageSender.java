package io.nadron.communication;

/**
 * This interface declares method for sending a message to client. Different
 * implementations would be used by the server for sending based on the delivery
 * guaranty that is required.
 * 此接口声明用于向客户端发送消息的方法
 * @author Abraham Menacherry
 * 
 */
public interface MessageSender
{
	/**
	 * This method delegates to the underlying native session object to send a
	 * message to the client.
	 * 此方法将委托给下一个本地会话对象发送一个消息给客户端
	 * @param message
	 *            The message to be sent to client.
	 * @return The boolean or future associated with this operation if
	 *         synchronous or asynchronous implementation respectively.
	 */
	public Object sendMessage(Object message);

	/**
	 * Returns the delivery guaranty of the implementation. Currently only
	 * RELIABLE and FAST are supported, their respective integer values are 0
	 * and 1.
	 * 返回执行的交货保证
	 * @return The guaranty instance  associated with the implementation.
	 */
	public DeliveryGuaranty getDeliveryGuaranty();
	
	/**
	 * Since message sender would have a network connection, it would require
	 * some cleanup. This method can be overriden to close underlying channels
	 * and so on.
	 * 由于消息发送者将有一个网络连接，它需要一些清理。这个方法可以修改关闭相关通道等。
	 */
	public void close();
	
	/**
	 * An interface whose implementations would transmit messages reliably to
	 * the remote machine/vm. The transport for instance could be TCP.
	 * 一个接口，它的实现将可靠地传输消息到远程机器/虚拟机， TCP
	 * @author Abraham Menacherry
	 * 
	 */
	public interface Reliable extends MessageSender{}
	
	/**
	 * An interface whose implementations would transmit messages fast but
	 * <b>unreliably</b> to the remote machine/vm. The transport for instance
	 * could be UDP.
	 * 一个接口的实现将信息传递到远程机器/虚拟机，快速但不可靠 UDP
	 * @author Abraham Menacherry
	 * 
	 */
	public interface Fast extends MessageSender{}

}
