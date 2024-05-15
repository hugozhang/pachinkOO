
package com.wordpress.salaboy.pachinkoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class LeftTupleSource {

    protected List<LeftTupleSink> sinks = new ArrayList<LeftTupleSink>();

    public LeftTupleSource() {
    }

    public void addTupleSink(LeftTupleSink tupleSink) {
        sinks.add(tupleSink);
    }
    
    
}
