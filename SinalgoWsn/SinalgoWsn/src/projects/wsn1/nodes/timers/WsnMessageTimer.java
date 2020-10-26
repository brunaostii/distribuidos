/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects.wsn1.nodes.timers;

import projects.wsn1.nodes.messages.WsnMsg;
import projects.wsn1.nodes.nodeImplementations.SimpleNode;
import projects.wsn1.nodes.nodeImplementations.SinkNode;
import sinalgo.nodes.Node;
import sinalgo.nodes.timers.Timer;

public class WsnMessageTimer extends Timer {

    private WsnMsg message = null;

    public WsnMessageTimer(WsnMsg message) {
        this.message = message;
    }

    @Override
    public void fire() {
    	try {
    		((SimpleNode)node).setFlag(false);
    		((SimpleNode)node).sendDirect(message, ((SimpleNode)node).getProximoNoAteEstacaoBase());   		
    	}catch(ClassCastException e) {
    		((SinkNode)node).broadcast(message);
    	}
    }

}
