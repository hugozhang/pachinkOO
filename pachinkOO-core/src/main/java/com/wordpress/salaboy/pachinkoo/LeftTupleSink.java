
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public interface LeftTupleSink {

     void assertLeftTuple(LeftTuple leftTuple, PropagationContext context, WorkingMemory wm);

}
