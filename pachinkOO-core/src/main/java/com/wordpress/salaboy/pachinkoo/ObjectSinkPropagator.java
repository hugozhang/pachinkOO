
package com.wordpress.salaboy.pachinkoo;

import java.util.List;

/**
 *
 * @author salaboy
 */
public interface ObjectSinkPropagator {

    void propagateAssertObject(Handle factHandle, PropagationContext context, WorkingMemory wm);

    List<ObjectSink> getSinks();

    void addSinks(List<ObjectSink> sinks);
}
