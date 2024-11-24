import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class will implement the SCAN 
 * disk scheduling algorithm.
 * 
 * @author ...
 */
public class SCAN implements IDiskAlgorithm {

	@Override
	public int calculateDistance(List<DiskRequest> requests, int headPosition) {
		int totalMovement = 0;
		int distance = 0;

		//variabl for the current headpostion of the disk scanner
		int curPos = headPosition;

		ArrayList<Integer> seq = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		//append marker to left list so the algorithm will scan to the end of the
		//disk before reversing direction
		left.add(0);
		

		//split the tasks into 2 sides
		for(DiskRequest request : requests){
			if (request.getTrack() < headPosition){
				left.add(request.getTrack());
			}else{
				right.add(request.getTrack());
			}
		}

		Collections.sort(left);
		Collections.sort(right);

		
		//go left then right.

		//get the track positions from end of left list first to descend
		for (int i = left.size()-1; i >=0; i--){
			seq.add(left.get(i));
			//calculate the absolute distance between current head position and requested track
			distance = Math.abs(left.get(i) - curPos);

			//update total movement
			totalMovement += distance;

			//set head to current positon
			curPos = left.get(i);
		}
		//go right by reading list right list in asceding order
		for(int i =0; i <right.size(); i ++){
			seq.add(right.get(i));
			//calculate the absolute distance between current head position and requested track
			distance = Math.abs(right.get(i) - curPos);

			//update total movement
			totalMovement += distance;
			//set head to current positon
			curPos = right.get(i);
		}

		/* DEBUG for sequence order.

		for (int i =0; i<seq.size(); i ++){
			System.out.println(seq.get(i));
		}
			
		*/
		

		return totalMovement;
	}


}
