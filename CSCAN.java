import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class will implement the C-SCAN 
 * disk scheduling algorithm.
 * 
 * @author ...
 */
public class CSCAN implements IDiskAlgorithm {

	@Override
	public int calculateDistance(List<DiskRequest> requests, int headPosition) {

		int distance = 0;
		int totalMovement = 0;
		int curPos = headPosition;
		//specified disk size
		int diskSize=5000;

		ArrayList<Integer> seq = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		

		//add begin and end of disk to apr sides.
		left.add(0);
		right.add(diskSize -1);

		//split requests into 2 lists

		for(DiskRequest request : requests){
			if (request.getTrack() < headPosition){
				left.add(request.getTrack());
			}else{
				right.add(request.getTrack());
			}
		}

		Collections.sort(left);
		Collections.sort(right);

		//go right first, then go back to zero, and then go left. lists are
		//ran through in asceding order both times.
		for(int i =0; i <right.size(); i ++){
			seq.add(right.get(i));
			//calculate the absolute distance between current head position and requested track
			distance = Math.abs(right.get(i) - curPos);

			//update total movement
			totalMovement += distance;
			//set head to current positon
			curPos = right.get(i);
		}

		//go back to 0 and add distance from end of disk to 0 to total movement
		curPos = 0;
		totalMovement+= diskSize-1;


		for(int i =0; i <left.size(); i ++){
			seq.add(left.get(i));
			//calculate the absolute distance between current head position and requested track
			distance = Math.abs(left.get(i) - curPos);

			//update total movement
			totalMovement += distance;
			//set head to current positon
			curPos = left.get(i);
		}





		/* 
		 * Debug
		 * for (int i =0; i<seq.size(); i ++){
			System.out.println(seq.get(i));
		}
		*/

		
			
		
		
		return totalMovement;
		
	}

}
