
package com.wordpress.salaboy.pachinkoo;

/**
 *
 * @author salaboy
 */
public interface Agenda {
    void addActivation(Activation activation);
    Activation getFirstActivation();
    int fireAllRules();
    int size();
}
