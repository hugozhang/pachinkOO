
package com.wordpress.salaboy.pachinkoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salaboy
 */
public class AgendaImpl implements Agenda {

    private List<Activation> activations = new ArrayList<Activation>();
    
    @Override
    public void addActivation(Activation activation) {
        activations.add(activation);
    }

    @Override
    public Activation getFirstActivation() {
        return activations.remove(0);
    }

    @Override
    public int size() {
        return activations.size();
    }

    @Override
    public int fireAllRules() {
        int counter = 0;
        while(size() != 0) {
            getFirstActivation().execute();
            counter++;
        }
        return counter;
    }
    
}
