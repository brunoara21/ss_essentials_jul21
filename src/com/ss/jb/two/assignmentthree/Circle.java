/**
 * 
 */
package com.ss.jb.two.assignmentthree;

/**
 * @author Bruno
 *
 */
public class Circle implements Shape {

	private Double radius;
	private Double area = null;
	
	public Circle(Double r) {
		this.radius = r;
	}
	
	/**
	 * Sets up and calculates the area to be displayed.
	 */
	@Override
	public void calculateArea() {
		System.out.println("Calculating area of Circle Shape...");
		this.area = Math.PI * radius * radius;
		System.out.println("Finished calculating area of Circle Shape.");
	}

	/**
	 * Displays the area to the console, if area has not been calculated a warning is printed.
	 */
	@Override
	public void display() {

		if (this.area != null) {
			System.out.println("Retrieved area of Circle Shape: " + this.area);
		} else {
			System.out.println("Area has not been calculated yet.");
		}
	}


}
