
package com.wordpress.salaboy.pachinkoo;

import java.util.List;

/**
 *
 * @author salaboy
 */
public interface Tuple {
    
    Handle get(int pattern);

    //FactHandle get(Declaration declaration);

    List<Handle> getFactHandles();

    int size();

}
