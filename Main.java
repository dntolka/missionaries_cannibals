

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		BFS search = new BFS();
		Main m = new Main();
		State s = search.breadth_first_search(State.initialS);

		m.show_sol(s);
	}

	public void show_sol(State s){

		LinkedList<State> queue = new LinkedList<State>();

		while(s !=null){
			queue.add(s);
			s = s.getParent();
		}
		System.out.println("Initial State");
		for(int i =queue.size()-1; i>=0; i--){
			if(i == 0 ) System.out.println("Terminal State");
			System.out.println(queue.get(i).print());
	       
	     }

	
	}

}
