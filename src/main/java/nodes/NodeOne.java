package nodes;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;

public class NodeOne implements Runnable{
	private int slaveId = 1;
    private int offset = 0;
    private int quantity = 10;
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
		 try {
				TcpParameters nodeOneParameters = new TcpParameters();
				nodeOneParameters.setHost(InetAddress.getByName("192.168.82.14"));
				ModbusMaster nodeOne = ModbusMasterFactory.createModbusMasterTCP(nodeOneParameters);
				 Modbus.setAutoIncrementTransactionId(true);

		         

		         try {
		             if (!nodeOne.isConnected()) {
		            	 nodeOne.connect();
		            	 System.out.println("connected!!!");
		             }
		             while(true) {
		             int[] registerValues = nodeOne.readHoldingRegisters(slaveId, offset, quantity);

		             for (int value : registerValues) {
		                 System.out.println("Address: " + offset++ + ", Value: " + value);
		             	}
		             offset=0;
		             System.out.println("*****************");
		             TimeUnit.SECONDS.sleep(1);
		             }

		         } catch(
			ModbusProtocolException e)
			{
				e.printStackTrace();
			}catch(
			ModbusNumberException e)
			{
				e.printStackTrace();
			}catch(
			ModbusIOException e)
			{
				e.printStackTrace();
			}finally
			{
				System.out.println("THE END!");
				try {
					nodeOne.disconnect();
				} catch (ModbusIOException e) {
					e.printStackTrace();
				}
			}}catch(

			RuntimeException e)
			{
				throw e;
			}catch(
			Exception e)
			{
				e.printStackTrace();
			}
		
	}
		}

}
