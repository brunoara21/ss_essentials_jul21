/**
 * 
 */
package com.ss.jb.two.assignmentthree;

/**
 * @author Bruno
 *
 */
public class Triangle implements Shape {

	private Double width;
	private Double height;
	private Double area = null;
	
	public Triangle(Double w, Double h) {
		this.width = w;
		this.height = h;
	}
	
	/**
	 * Sets up and calculates the area to be displayed.
	 */
	@Override
	public void calculateArea() {
		System.out.println("Calculating area of Triangle Shape...");
		this.area = width * height / 2.0d;
		System.out.println("Finished calculating area of Triangle Shape.");
	}

	/**
	 * Displays the area to the console, if area has not been calculated a warning is printed.
	 */
	@Override
	public void display() {

		if (this.area != null) {
			System.out.println("Retrieved area of Triangle Shape: " + this.area);
		} else {
			System.out.println("Area has not been calculated yet.");
		}
	}

}
