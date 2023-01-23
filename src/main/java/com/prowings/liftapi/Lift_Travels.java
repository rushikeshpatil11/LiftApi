package com.prowings.liftapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.prowings.exception.InvalidFloorException;

public class Lift_Travels {
	static LinkedHashSet<Integer> re = new LinkedHashSet();

	public static Set<Integer> liftTravel(int currentFloor, int direction, Set<Integer> selectedFloors) {

		if (isValidSelectedFloors(selectedFloors) && currentFloor>-1 && currentFloor<51) {
			re.add(currentFloor);
			if (direction == 1)
				return upwardDirection(currentFloor, selectedFloors);
			if (direction == -1)
				return downwardDirection(currentFloor, selectedFloors);
		}
		throw new InvalidFloorException("Invalid Selected Current Floor");

	}

	private static boolean isValidSelectedFloors(Set<Integer> selectedFloors) {
		List<Integer> list = new ArrayList(selectedFloors);
		Collections.sort(list);
		if (list.get(0) > -1 && list.get(list.size() - 1) < 51)
			return true;
		else
			throw new InvalidFloorException("Selected Floor is Invalid");
	}

	private static Set<Integer> downwardDirection(int currentFloor, Set<Integer> floors) {

		TreeSet<Integer> t = new TreeSet(floors);
		int min = t.first();
		int max = t.last();

		int a = currentFloor;
		int b = currentFloor;

		while (min != a) {
			a = t.lower(currentFloor);
			re.add(a);
			currentFloor = a;
		}
		while (max != b) {
			b = t.higher(currentFloor);
			re.add(b);
			currentFloor = b;
		}

		return re;

	}

	private static Set<Integer> upwardDirection(int currentFloor, Set<Integer> floors) {

		TreeSet<Integer> t = new TreeSet(floors);
		int min = t.first();
		int max = t.last();

		int a = currentFloor;
		int b = currentFloor;

		while (max != b) {
			b = t.higher(currentFloor);
			re.add(b);
			currentFloor = b;
		}
		while (min != a) {
			a = t.lower(currentFloor);
			re.add(a);
			currentFloor = a;
		}

		return re;

	}

}
