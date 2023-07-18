// **********
// (CISC230 - 4/20/2023)
//
// File Name: Project2_Consecutive
//
// Purpose: to create a program that takes in the values for a 2D array and determines
//			if there has been a certain number of consecutive values
// **********

import java.util.Scanner;

public class Project2_Consecutive {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dimRow, dimCol;
		int[][] square;

		System.out.println("Please enter a row dimention");
		dimRow = scan.nextInt();
		
		System.out.println("Please enter a col dimention");
		dimCol = scan.nextInt();
		
		square = new int[dimRow][dimCol];
		// since the array is a square square.length and square[0].length can be used interchangeably
		for (int row = 0; row < square.length; row++)
			for (int col = 0; col < square.length; col++) {
				System.out.println("please enter a value for row " + row + " and col " + col);
				// mod 10 ensures that only values 0 through 10 can be inputs
				square[row][col] = scan.nextInt() % 10;
			}
		
		// prints the array
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square[0].length; col++) 
				System.out.print(square[row][col]);
			System.out.println();
		}
		
		// takes user input to see how many values in a row
		System.out.println("Please enter how many ints in a row you want");
		// mod 10 ensures that only values 0 through 10 can be inputs
		System.out.println(isConsecutive(square, scan.nextInt()%10));

		scan.close();
	}
	
	public static boolean isConsecutive(int[][] values, int value) {
		int consec = 1;
		
		// if only looking for 1 consecutive value and square has at least one input
		// there will always be 1 consecutive value
		if (values.length > 0)
			if ((values[0].length > 0)&&(value== 1))
				return true;
		
		// checks values across each row
		for (int row = 0; row < values.length; row++) { 
			// values - 1 so the next value can be checked without going out of bounds
			for (int col = 0; col < values[0].length - 1; col++) 
				// if value is same as one to right consec increases
				if (values[row][col] == values[row][col+1]) 
				{
					consec++;
					// checks if value is met
					if (consec >= value)
						return true;
				}else 
					// reset consec
					consec = 1;
			// reset after each row
			consec = 1;
		}
		
		// checks values down column
		for (int col = 0; col < values[0].length; col++) {
			// values - 1 so the next value can be checked without going out of bounds
			for (int row = 0; row < values.length - 1; row++) 
				// if value is same as one below consec increases
				if (values[row][col] == values[row+1][col]) {
					consec++;
					// checks if value is met
					if (consec >= value)
						return true;
					}else 
						// reset consec
						consec = 1;
			// reset after each column
			consec = 1;
		}

		// checks values along main diagonal
		for (int dim = 0; dim < values.length - 1; dim++) 
				if (values[dim][dim] == values[dim+1][dim+1]) {
					// if value is same as one diagonal to it consec increases
					consec++;
					// checks if value is met
					if (consec >= value)
						return true;
					}else 
						// reset consec
						consec = 1;

		// checks values along other diagonal
		for (int dim = 0; dim < values.length - 1; dim++)  
			if (values[dim][values.length - 1 - dim] == values[dim+1][values.length - dim - 2]) {
				// if value is same as one diagonal to it consec increases
				consec++;
				// checks if value is met
				if (consec >= value)
					return true;
			}else 
				// reset consec
				consec = 1;

		// if consec never equals value return false
		return false;
		
	}
}