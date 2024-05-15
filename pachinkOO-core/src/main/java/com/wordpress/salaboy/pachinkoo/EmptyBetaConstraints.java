
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public class EmptyBetaConstraints implements BetaConstraints {

    @Override
    public Object getField() {
        return null;
    }

    @Override
    public Object getRestriction() {
       return null; 
    }

    @Override
    public Comparator getComparator() {
        return null;
    }
    
}
