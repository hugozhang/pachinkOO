
package com.wordpress.salaboy.pachinkoo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class LeftTuple implements Tuple {

    private List<Handle> handles = new LinkedList<Handle>();

    private LeftTupleSink sink;

    public LeftTuple(Handle handle, LeftTupleSink sink) {
        this.sink = sink;
        handles.add(handle);
    }

    @Override
    public Handle get(int pattern) {
        return handles.get(pattern);
    }

    @Override
    public List<Handle> getFactHandles() {
        return handles;
    }

    @Override
    public int size() {
        return handles.size();
    }

    @Override
    public String toString() {
        return "LeftTuple{" + "handles=" + handles + ", sink=" + sink + '}';
    }

}
