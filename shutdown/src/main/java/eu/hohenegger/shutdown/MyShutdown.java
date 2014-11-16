package eu.hohenegger.shutdown;

public class MyShutdown {
	public static void main(String[] args) {
		MyShutdownDll dll = (MyShutdownDll) MyShutdownDll.INSTANCE;
		if (!dll.isWinShutdownAllowed()) {
			System.err.println("shutdown not allowed");
			System.exit(1);
		}
		boolean shutdownSuccess = dll.winShutdown();
		if (!shutdownSuccess) {
			System.err.println("shutdown failed");
			System.exit(2);
		}
		System.exit(0);
	}
}