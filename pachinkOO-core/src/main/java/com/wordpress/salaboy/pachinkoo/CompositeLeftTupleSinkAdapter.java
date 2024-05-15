
package com.wordpress.salaboy.pachinkoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class CompositeLeftTupleSinkAdapter implements LeftTupleSinkPropagator {

    private List<LeftTupleSink> sinks = new ArrayList<LeftTupleSink>();

    @Override
    public void propagateAssertLeftTuple(LeftTuple tuple, PropagationContext context, WorkingMemory wm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createAndPropagateAssertLeftTuple(Handle factHandle, PropagationContext context, WorkingMemory wm) {
        for(LeftTupleSink sink : sinks) {
            this.doPropagateAssertLeftTuple(context, sink , new LeftTuple(factHandle, sink), wm);         
        }
    }
    
    
    protected void doPropagateAssertLeftTuple(PropagationContext context,
                                              LeftTupleSink sink,
                                              LeftTuple leftTuple,
                                              WorkingMemory wm) {
        sink.assertLeftTuple( leftTuple,context, wm );
    }
    
    protected void doPropagateAssertLeftTuple(PropagationContext context,
                                              LeftTupleSink sink,
                                              LeftTuple leftTuple,
                                              RightTuple rightTuple,
                                              WorkingMemory wm) {
        sink.assertLeftTuple( leftTuple,context, wm );
    }
    
    public void addTupleSink(LeftTupleSink sink) {
        this.sinks.add( sink );
    }

}
