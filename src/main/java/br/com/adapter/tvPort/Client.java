package br.com.adapter.tvPort;

import br.com.adapter.tvPort.adapters.HDMIToOldMonitorAdapter;
import br.com.adapter.tvPort.adapters.HDMIToVGAAdapter;
import br.com.adapter.tvPort.devices.Computer;
import br.com.adapter.tvPort.devices.OldMonitor;
import br.com.adapter.tvPort.devices.TV;

public class Client {

	public static void main(String[] args) {
		System.out.println("------ No adapter ----------");

		Computer pc = new Computer();
		TV tv = new TV();
		pc.connectPort(tv);
		pc.sendImageAndSound("Cat and rainbow", "Nyan cat song");

		System.out.println("------ Monitor ----------");

		Computer pc2 = new Computer();
		OldMonitor oldMonitor = new OldMonitor();
		// Don't work! That's the reason why we create the adapter
		// pc2.connectPort(monitor.getConnector());
		pc2.connectPort(new HDMIToVGAAdapter(oldMonitor));
		pc2.sendImageAndSound("Cat and rainbow", "Nyan cat song");

		System.out.println("------ Monitor Class Adapter ----------");

		Computer pc3 = new Computer();
		HDMIToOldMonitorAdapter monitorAdapter = new HDMIToOldMonitorAdapter();
		pc3.connectPort(monitorAdapter);
		pc3.sendImageAndSound("Cat and rainbow", "Nyan cat song");
	}
}
