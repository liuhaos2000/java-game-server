package io.nadron.communication;

/**
 * This interface declares method for sending a message to client. Different
 * implementations would be used by the server for sending based on the delivery
 * guaranty that is required.
 * �˽ӿ�����������ͻ��˷�����Ϣ�ķ���
 * @author Abraham Menacherry
 * 
 */
public interface MessageSender
{
	/**
	 * This method delegates to the underlying native session object to send a
	 * message to the client.
	 * �˷�����ί�и���һ�����ػỰ������һ����Ϣ���ͻ���
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
	 * ����ִ�еĽ�����֤
	 * @return The guaranty instance  associated with the implementation.
	 */
	public DeliveryGuaranty getDeliveryGuaranty();
	
	/**
	 * Since message sender would have a network connection, it would require
	 * some cleanup. This method can be overriden to close underlying channels
	 * and so on.
	 * ������Ϣ�����߽���һ���������ӣ�����ҪһЩ����������������޸Ĺر����ͨ���ȡ�
	 */
	public void close();
	
	/**
	 * An interface whose implementations would transmit messages reliably to
	 * the remote machine/vm. The transport for instance could be TCP.
	 * һ���ӿڣ�����ʵ�ֽ��ɿ��ش�����Ϣ��Զ�̻���/������� TCP
	 * @author Abraham Menacherry
	 * 
	 */
	public interface Reliable extends MessageSender{}
	
	/**
	 * An interface whose implementations would transmit messages fast but
	 * <b>unreliably</b> to the remote machine/vm. The transport for instance
	 * could be UDP.
	 * һ���ӿڵ�ʵ�ֽ���Ϣ���ݵ�Զ�̻���/����������ٵ����ɿ� UDP
	 * @author Abraham Menacherry
	 * 
	 */
	public interface Fast extends MessageSender{}

}
