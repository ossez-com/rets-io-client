package com.ossez.reoc.rets.client;

public class NullNetworkEventMonitor implements NetworkEventMonitor {
	
	public Object eventStart(String message) {
		return null;
	}

	
	public void eventFinish(Object o) {
		//noop
	}
}
