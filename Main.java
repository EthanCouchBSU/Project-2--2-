import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<DiskRequest> requests1 = new ArrayList<DiskRequest>();
		requests1.add(new DiskRequest(1786, 3));
		requests1.add(new DiskRequest(79, 1));
		requests1.add(new DiskRequest(34, 1));
		requests1.add(new DiskRequest(1160, 4));
		requests1.add(new DiskRequest(4000, 0));
		requests1.add(new DiskRequest(1001, 1));
		requests1.add(new DiskRequest(4143, 1));
		requests1.add(new DiskRequest(114, 7));
		
		IDiskAlgorithm diskAlgorithm;
		//diskAlgorithm = new FCFS();
		//diskAlgorithm = new CSCAN();
		diskAlgorithm = new SCAN();
		
		
		System.out.println(diskAlgorithm.calculateDistance(requests1, 50));
	}
	
}
