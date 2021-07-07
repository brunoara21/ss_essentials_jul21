/**
 * 
 */
package com.ss.jb.two.assignmentthree;

/**
 * @author Bruno
 *
 */
public class Rectangle implements Shape {

	private Double width;
	private Double height;
	private Double area = null;
	
	public Rectangle(Double w, Double h) {
		this.width = w;
		this.height = h;
	}
	
	/**
	 * Sets up and calculates the area to be displayed.
	 */
	@Override
	public void calculateArea() {
		System.out.println("Calculating area of Rectangle Shape...");
		this.area = width * height;
		System.out.println("Finished calculating area of Rectangle Shape.");
	}

	/**
	 * Displays the area to the console, if area has not been calculated a warning is printed.
	 */
	@Override
	public void display() {

		if (this.area != null) {
			System.out.println("Retrieved area of Rectangle Shape: " + this.area);
		} else {
			System.out.println("Area has not been calculated yet.");
		}
	}

}
