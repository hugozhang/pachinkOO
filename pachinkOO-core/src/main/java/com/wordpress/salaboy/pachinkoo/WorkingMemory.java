/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.pachinkoo;

import java.util.Map;

/**
 *
 * @author salaboy
 */
public interface WorkingMemory {
    
    Agenda getAgenda();
    
    int fireAllRules();
    
    Rete getRete();
    
    void insert(Object fact);
    
    Map<Object, Object> getAssertedFacts();
}
