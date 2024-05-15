
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public class Rete extends ObjectSource implements ObjectSink {

    private WorkingMemory wm;

    public Rete(WorkingMemory wm) {
        this.wm = wm;
    }

    @Override
    public void assertObject(Handle factHandle, PropagationContext propagationContext, WorkingMemory wm) {
        sinkPropagator.propagateAssertObject(factHandle, propagationContext, wm);
    }

    @Override
    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void assertFact(Object fact){
        this.assertObject(new FactHandle(fact), null, this.wm);
    }

    public WorkingMemory getWm() {
        return wm;
    }
    
    
    
}
