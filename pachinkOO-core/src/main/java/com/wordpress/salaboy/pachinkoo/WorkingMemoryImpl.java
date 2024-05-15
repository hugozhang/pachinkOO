/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.pachinkoo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author salaboy
 */
public class WorkingMemoryImpl implements WorkingMemory {

    private Agenda agenda = new AgendaImpl();

    private Rete rete;

    private Map<Object, Object> assertStore;

    public WorkingMemoryImpl() {
        rete = new Rete(this);
        assertStore = new HashMap<Object, Object>();   
    }

    @Override
    public Agenda getAgenda() {
        return this.agenda;
    }

    @Override
    public int fireAllRules() {
        return this.agenda.fireAllRules();
    }

    @Override
    public Rete getRete() {
        return rete;
    }
    
    @Override
    public void insert(Object object) {
       Handle handle = createHandle(object);
       rete.assertObject(handle, null, this);
    }

    private Handle createHandle(Object object) {
        FactHandle factHandle = new FactHandle(object);
        assertStore.put(factHandle, object);
        return factHandle;
    }
    
    public Object getObjectForFactHandle(Handle handle){
        return assertStore.get(handle);
    }

    @Override
    public Map<Object, Object> getAssertedFacts() {
        return assertStore;
    }
    
    
}
