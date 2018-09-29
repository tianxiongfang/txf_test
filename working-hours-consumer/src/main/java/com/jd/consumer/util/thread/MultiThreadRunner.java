package com.jd.consumer.util.thread;

public class MultiThreadRunner implements Runnable {
	private String name;
	private Thread t;
	private Callback callback;

	public MultiThreadRunner(String name, Callback callback) {
		this.name = name;
		this.callback = callback;
	}

	@Override
	public void run() {
		callback.run();
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, name);
		}
		t.start();
	}
}



