package com.prowings.liftapi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiftApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiftApiApplication.class, args);
		Scanner sc = new Scanner(System.in);
		Set<Integer> selectedFloors = new HashSet();
		System.out.println("*****Lift_Travels*****");
		System.out.println("Enter CurrentFloor");
		int currentFloor = sc.nextInt();
		System.out.println("Enter 1 For Upward Direction OR Enter -1 For DownWard Direction");
		int direction = sc.nextInt();
		System.out.println("Due To Load  Issue Enter Only  5 Floors ");
		selectedFloors.add(sc.nextInt());
		selectedFloors.add(sc.nextInt());
		selectedFloors.add(sc.nextInt());
		selectedFloors.add(sc.nextInt());
		selectedFloors.add(sc.nextInt());

		System.out.println(
				"Seq. By Which Lift Travels :=" + Lift_Travels.liftTravel(currentFloor, direction, selectedFloors));

	}

}
