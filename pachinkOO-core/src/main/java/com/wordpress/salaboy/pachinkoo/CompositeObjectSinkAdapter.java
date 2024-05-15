
package com.wordpress.salaboy.pachinkoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class CompositeObjectSinkAdapter implements ObjectSinkPropagator {

    private List<ObjectSink> sinks = new ArrayList<ObjectSink>();
    
    @Override
    public void propagateAssertObject(Handle factHandle, PropagationContext context, WorkingMemory wm) {
        for(ObjectSink sink: sinks) {
            sink.assertObject(factHandle, context, wm);
        }
    }
    
    public void addObjectSink(ObjectSink sink){
        sinks.add(sink);
    }

    @Override
    public List<ObjectSink> getSinks() {
        return sinks;
    }

    @Override
    public void addSinks(List<ObjectSink> sinks) {
        for(ObjectSink sink: sinks){
            this.addObjectSink(sink);
        }
    }
    
}
