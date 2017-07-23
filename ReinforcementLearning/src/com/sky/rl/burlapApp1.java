package com.sky.rl;

import burlap.domain.singleagent.graphdefined.GraphDefinedDomain;
import burlap.oomdp.core.Domain;
import burlap.oomdp.core.states.State;
import burlap.oomdp.auxiliary.DomainGenerator;
import burlap.oomdp.core.*;

public class burlapApp1 {
	
	DomainGenerator dg;
	Domain domain;
	State initState;
	
	public burlapApp1() {
		int numStates = 6;
		
		this.dg = new GraphDefinedDomain(numStates);
		
		this.domain = this.dg.generateDomain();
		
		this.initState = GraphDefinedDomain.getState(this.domain, 0);
	}

}











