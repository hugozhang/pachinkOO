
package com.wordpress.salaboy.pachinkoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class BetaMemory {

    private List<LeftTuple> leftTuple = new ArrayList<LeftTuple>();

    private List<RightTuple> rightTuple = new ArrayList<RightTuple>();

    public BetaMemory() {
    }
    
    
    public void addLeftTuple(LeftTuple tuple){
        leftTuple.add(tuple);
    }
    
    public void addRightTuple(RightTuple tuple){
        rightTuple.add(tuple);
    }

    public List<LeftTuple> getLeftTuple() {
        return leftTuple;
    }

    public List<RightTuple> getRightTuple() {
        return rightTuple;
    }
    
    
}
