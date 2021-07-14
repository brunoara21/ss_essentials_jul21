/**
 * 
 */
package com.ss.jb.wk1;

/**
 * Functional Interface that has method to Perform operation on a number and returns a String
 * @author Bruno
 *
 */
@FunctionalInterface
public interface PerformOperation {
	public String performOp(Integer num);
}
