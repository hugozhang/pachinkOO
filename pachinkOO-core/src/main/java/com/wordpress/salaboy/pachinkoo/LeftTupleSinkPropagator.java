
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public interface LeftTupleSinkPropagator {

    void propagateAssertLeftTuple(LeftTuple tuple,PropagationContext context, WorkingMemory wm);

    void createAndPropagateAssertLeftTuple(Handle factHandle,PropagationContext context, WorkingMemory wm);

}
