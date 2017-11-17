package observer;

import java.util.Collection;

public abstract class Subject {

	private Collection<Observer> observers;

	public abstract void notifyObservers();

	public abstract void unregisterObserver(Observer o);

	public abstract void registerObserver(Observer o);

	public Collection<Observer> getObservers() {
		return observers;
	}

	public void setObservers(Collection<Observer> obs) {
		this.observers = obs;
	}

}
