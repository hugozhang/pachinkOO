
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public interface ObjectSink extends NetworkNode {

     void assertObject(Handle factHandle,PropagationContext propagationContext, WorkingMemory wm);

}
