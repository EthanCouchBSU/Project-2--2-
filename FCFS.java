import java.util.List;

/**
 * This class will implement the First Come First Serve 
 * disk scheduling algorithm.
 *
 * @author YourName
 */
public class FCFS implements IDiskAlgorithm {

	@Override
	public int calculateDistance(List<DiskRequest> requests, int headPosition) {
		int totalMovement = 0; // Initialize total head movement

		//iterate through the requests in the order they arrive
		for (DiskRequest request : requests) {
			//calculate the absolute distance between current head position and requested track
			int distance = Math.abs(request.getTrack() - headPosition);

			//update total movement
			totalMovement += distance;

			//move the head to the current request's track
			headPosition = request.getTrack();
		}

		return totalMovement; //return the total head movement
	}
}
