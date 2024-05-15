/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.pachinkoo;


import com.wordpress.salaboy.pachinkoo.rhs.Action;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author salaboy
 */
public class SimpleReteTest {

    public SimpleReteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void simpleReteTest() {
        WorkingMemory wm = new WorkingMemoryImpl();
        Rete rete = wm.getRete();
        
        // network
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(Person.class.getCanonicalName());
        AlphaNode alphaNode = new AlphaNode(Comparator.EQUAL, "Name", "Salaboy");
        LeftInputAdapterNode leftInputAdapter = new LeftInputAdapterNode();
        RuleTerminalNode terminalNode = new RuleTerminalNode("matches a person and execute an action", new Action() {
            @Override
            public void execute(Tuple tuple, PropagationContext context) {
                // no action
                System.out.println("abc");
            }
        });
        
		objectTypeNode.addObjectSink(alphaNode);
        alphaNode.addObjectSink(leftInputAdapter);
        leftInputAdapter.addTupleSink(terminalNode);
        rete.addObjectSink(objectTypeNode);
        
        // assert and verify agenda (no firing...)
        rete.assertFact(new Person("Salaboy"));
        assertEquals(1, wm.getAgenda().size());
    }

    @Test
    public void reteOneSimpleRuleActivationAndFireTest() {

        //Create Working Memory
        WorkingMemory wm = new WorkingMemoryImpl();
        //Get the Root/Rete Node
        Rete rete = wm.getRete();

        //Create one Object Type Node: Person()
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(Person.class.getCanonicalName());
        //Create one AlpaNode for Person(name == "Salaboy")
        AlphaNode alphaNode = new AlphaNode(Comparator.EQUAL, "Name", "Salaboy");
        objectTypeNode.addObjectSink(alphaNode);
        LeftInputAdapterNode leftInputAdapter = new LeftInputAdapterNode();
        alphaNode.addObjectSink(leftInputAdapter);
        RuleTerminalNode terminalNode = new RuleTerminalNode("matches a person and execute an action", new Action() {

            @Override
            public void execute(Tuple tuple, PropagationContext context) {
                System.out.println("My Tuple = " + tuple);
            }
        });
        leftInputAdapter.addTupleSink(terminalNode);

        //Add OTN Person() to the Network
        rete.addObjectSink(objectTypeNode);
        
        
        //Let's use the network

        wm.insert(new Person("Salaboy"));

        assertEquals(1, wm.getAgenda().size());

        int fired = wm.fireAllRules();

        assertEquals(1, fired);

        assertEquals(0, wm.getAgenda().size());
        
        assertEquals(1, wm.getAssertedFacts().size());

    }
    
    @Test
    public void joinNodeTest() {
         //Create Working Memory
        WorkingMemory wm = new WorkingMemoryImpl();
        //Get the Root/Rete Node
        Rete rete = wm.getRete();

        //Create one Object Type Node: Person()
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(Person.class.getCanonicalName());
        //Create one AlpaNode for Person(name == "Salaboy")

        AlphaNode alphaNode = new AlphaNode(Comparator.EQUAL, "Name", "Salaboy");
        objectTypeNode.addObjectSink(alphaNode);

        LeftInputAdapterNode leftInputAdapter = new LeftInputAdapterNode();
        alphaNode.addObjectSink(leftInputAdapter);
        
        
        //JoinNode joinNode = new JoinNode(new SingleValueRestrictionConstraint("Address.addressLine1", "Person.address", COMPARATOR.EQUAL));
        JoinNode joinNode = new JoinNode(new EmptyBetaConstraints());

        RuleTerminalNode terminalNode = new RuleTerminalNode("matches a person and execute an action", new Action() {

            @Override
            public void execute(Tuple tuple, PropagationContext context) {
                System.out.println("My Tuple = " + tuple);
            }
        });
        leftInputAdapter.addTupleSink(joinNode);

        //Add OTN Person() to the Network
        rete.addObjectSink(objectTypeNode);
        
        
        //Create one Object Type Node: Address()
        objectTypeNode = new ObjectTypeNode(Address.class.getCanonicalName());
        //Create one AlpaNode for Address(addressLine1 == "nowhere")
        alphaNode = new AlphaNode(Comparator.EQUAL, "AddressLine1", "nowhere");
        objectTypeNode.addObjectSink(alphaNode);
        
        alphaNode.addObjectSink(joinNode);
        
        joinNode.addTupleSink(terminalNode);

        //Add OTN Address() to the Network
        rete.addObjectSink(objectTypeNode);


        //以上在组建rete网络


        //Let's use the network

        wm.insert(new Person("Salaboy"));
        wm.insert(new Person("Salaboy"));
        wm.insert(new Person("Salaboy1"));
        //Nothing happens until here.. let's add another Fact
        assertEquals(0, wm.getAgenda().size());
        
        
        wm.insert(new Address("nowhere"));
        wm.insert(new Address("nowhere"));
        wm.insert(new Address("nowhere2"));
//        assertEquals(1, wm.getAgenda().size());
        
        int fired = wm.fireAllRules();
        assertEquals(1, fired);
        
    }
    
}
