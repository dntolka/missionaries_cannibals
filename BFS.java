

import java.util.*;

public class BFS {

			public State breadth_first_search(State s)
	    {
	        // Create a queue for BFS
	        LinkedList<State> queue = new LinkedList<State>();
	        Set<State> explored = new HashSet<State>();
	        queue.add(s);
	        
	       	while (queue.size() != 0)
	        {
	            State new_s = queue.poll();
	            
	            ArrayList<State> next_states = new_s.next_states();
	            
	            if(new_s.goal()){
	            	return new_s;
	            }

	            for(int i =0; i < next_states.size(); i++){

	                if (!explored.contains(next_states.get(i)) )
	                {
	                	next_states.get(i).setParent(new_s);
						explored.add(next_states.get(i));
						queue.add(next_states.get(i));
	                 }
	            	}
	        	}

	        return null;
	    	}


}
