/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public class SingleValueRestrictionConstraint implements BetaConstraints {

    private String field;

    private String restriction;

    private Comparator comparator;

    public SingleValueRestrictionConstraint(String field, String restriction, Comparator comparator) {
        this.field = field;
        this.restriction = restriction;
        this.comparator = comparator;
    }
    
    @Override
    public Object getField() {
        return field;
    }

    @Override
    public Object getRestriction() {
        return restriction;
    }

    @Override
    public Comparator getComparator() {
       return comparator;
    }
    
}
