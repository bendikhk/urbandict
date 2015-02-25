package net.kvamstadsolutions.urbandict.advanced.backend;

public interface AsyncCallback<T> {
	public void onSuccess(T result);

	public void onFailure(Throwable caught);
}