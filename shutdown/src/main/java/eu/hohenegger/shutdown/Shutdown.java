package eu.hohenegger.shutdown;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Shutdown {
	public static void main(String[] args) {
		try {
			extractDll(ShutdownDll.NATIVE_LIB_NAME + ShutdownDll.EXTENSION);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		ShutdownDll dll = (ShutdownDll) ShutdownDll.INSTANCE;
		if (!dll.isWinShutdownAllowed()) {
			System.err.println("shutdown not allowed");
			System.exit(2);
		}
		boolean shutdownSuccess = dll.winShutdown();
		if (!shutdownSuccess) {
			System.err.println("shutdown failed");
			System.exit(3);
		}
		System.exit(0);
	}
	
	public static void extractDll(String name) throws IOException {
	    InputStream in = Shutdown.class.getResourceAsStream(name);
	    Files.copy(in, new File(name).getAbsoluteFile().toPath());
	}
}