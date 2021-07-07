/**
 * 
 */
package com.ss.jb.two;

import com.ss.jb.two.assignmentthree.Circle;
import com.ss.jb.two.assignmentthree.Rectangle;
import com.ss.jb.two.assignmentthree.Triangle;

/**
 * Create a Shape Interface with the methods "calculateArea" and "display". Create a Rectangle, 
 * Circle, and Triangle class to implement that interface.
 * 
 * @author Bruno
 *
 */
public class AssignmentThree {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(3.d, 4.5d);
		Circle c1 = new Circle(10.d);
		Triangle t1 = new Triangle(5.5d, 10.d);
		
		r1.display(); // Display before calculating
		c1.display(); // Display before calculating
		
		t1.calculateArea(); // Calculate Triangle Area
		t1.display(); 	// Displays Area 
		
		r1.calculateArea();
		c1.calculateArea();
		r1.display();
		c1.display();
	}

}
