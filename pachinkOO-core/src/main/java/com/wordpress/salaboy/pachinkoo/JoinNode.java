
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public class JoinNode extends BetaNode {

    public JoinNode(BetaConstraints constraint) {
        super(constraint);
    }

    @Override
    public void assertObject(Handle factHandle, PropagationContext propagationContext, WorkingMemory wm) {
        RightTuple rightTuple = new RightTuple(factHandle, this);
        //?? this to the rightTupleSink????
        getMemory().addRightTuple(rightTuple);
        for (LeftTuple leftTuple : getMemory().getLeftTuple()) {
            if(constraint instanceof EmptyBetaConstraints){
                System.out.println("Left Tuple = "+leftTuple);
                System.out.println("Right Tuple = "+rightTuple);
                for (LeftTupleSink sink : sinks) {
                    sink.assertLeftTuple(leftTuple, propagationContext, wm);
                }
            }
            
            //if it matches with the rigth tuple propagate
//            for (LeftTupleSink sink : sinks) {
//                sink.assertLeftTuple(leftTuple, propagationContext, wm);
//            }
        }
    }

    @Override
    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assertLeftTuple(LeftTuple leftTuple, PropagationContext propagationContext, WorkingMemory wm) {
        getMemory().addLeftTuple(leftTuple);
        for (RightTuple rightTuple : getMemory().getRightTuple()) {
            if(constraint instanceof EmptyBetaConstraints){
                System.out.println("Left Tuple = "+leftTuple);
                System.out.println("Right Tuple = "+rightTuple);
                for (LeftTupleSink sink : sinks) {
                    sink.assertLeftTuple(leftTuple, propagationContext, wm);
                }
            }
            
           
        }
        //if it matches with the left tuple propagate
//        for (LeftTupleSink sink : sinks) {
//            sink.assertLeftTuple(leftTuple, context, wm);
//        }
    }
}
