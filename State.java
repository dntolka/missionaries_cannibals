

import java.util.ArrayList;

public class State{

	int LeftMis;
	int LeftCan;
	int RightMis;
	int RightCan;
	int boat;


	public State(int leftCan, int leftMis, int boat, int rightCan, int rightMis) {
		super();
		LeftMis = leftMis;
		LeftCan = leftCan;
		RightMis = rightMis;
		RightCan = rightCan;
		this.boat = boat;
	}

	public static State initialS = new State(3,3,1,0,0);
	public static State finalS = new State(0,0,0,3,3);

	State parent=null;

	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}

	public int getLeftMis() {
		return LeftMis;
	}

	public void setLeftMis(int leftMis) {
		LeftMis = leftMis;
	}

	public int getLeftCan() {
		return LeftCan;
	}

	public void setLeftCan(int leftCan) {
		LeftCan = leftCan;
	}

	public int getRightMis() {
		return RightMis;
	}

	public void setRightMis(int rightMis) {
		RightMis = rightMis;
	}

	public int getRightCan() {
		return RightCan;
	}

	public void setRightCan(int rightCan) {
		RightCan = rightCan;
	}

	public int getBoat() {
		return boat;
	}

	public void setBoat(int boat) {
		this.boat = boat;
	}

	public boolean check() {
		if(LeftCan < 0 || LeftMis < 0 || RightCan < 0 || RightMis < 0 ||
			LeftCan >3 || LeftMis >3 || RightCan > 3 || RightMis > 3) return false ;

		if(LeftMis != 0 && LeftMis < LeftCan) return false;
		if(RightMis != 0 && RightMis < RightCan) return false;

		return true;

	}

	public boolean goal(){
		return LeftCan == 0 && LeftMis==0&& boat==0;
	}

	public String print(){
		return(LeftCan + "," + LeftMis + "," + boat + "," + RightCan + "," + RightMis );

	}

	@Override
	public boolean equals(Object obj) {


		if (!(obj instanceof State)) {
				return false;
			}

		State other = (State) obj;
		if (LeftCan != other.LeftCan)
			return false;
		if (LeftMis != other.LeftMis)
			return false;
		if (RightCan != other.RightCan)
			return false;
		if (RightMis != other.RightMis)
			return false;
		if (this.boat != other.boat)
			return false;

		return true;
	}

	public ArrayList<State> next_states(){
		ArrayList<State> s = new ArrayList<State>();

		if(boat == 1) {

			// Two missionaries cross left to right.
			State newState = new State(LeftCan, LeftMis - 2, 0, RightCan, RightMis + 2);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// Two cannibals cross left to right.
			newState = new State(LeftCan - 2, LeftMis, 0, RightCan + 2, RightMis);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// One cannibal and one missionary cross left to right.
			newState = new State(LeftCan - 1, LeftMis - 1, 0, RightCan + 1, RightMis + 1);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// One cannibal cross left to right.
			newState = new State(LeftCan - 1, LeftMis, 0, RightCan + 1, RightMis);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// One missionary cross left to right.
			newState = new State(LeftCan, LeftMis - 1, 0, RightCan, RightMis + 1);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

		}else {


			// Two missionaries cross right to left.
			State newState = new State(LeftCan, LeftMis + 2, 1, RightCan, RightMis - 2);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// Two cannibals cross right to left.
			newState = new State(LeftCan + 2, LeftMis, 1, RightCan - 2, RightMis);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// One cannibal and one missionary cross right to left.
			newState = new State(LeftCan + 1, LeftMis + 1, 1, RightCan - 1, RightMis - 1);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// One cannibal cross right to left.
			newState = new State(LeftCan + 1, LeftMis, 1, RightCan - 1, RightMis);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

			// One missionary cross right to left.
			newState = new State(LeftCan, LeftMis + 1, 1, RightCan, RightMis - 1);
			if (newState.check()) {
				newState.setParent(newState.parent);
				s.add(newState);
			}

		}
		return s;
	}
}
