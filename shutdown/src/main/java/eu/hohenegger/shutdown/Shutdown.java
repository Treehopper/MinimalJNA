package eu.hohenegger.shutdown;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Shutdown {
	public static void main(String[] args) {
		extractDll(ShutdownDll.NATIVE_LIB_NAME + ShutdownDll.EXTENSION);
		
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
	
	public static void extractDll(String name)  {
		try {
			File file = new File(name);
			if (!file.exists()) {
				InputStream in = Shutdown.class.getResourceAsStream(file.getName());
				Files.copy(in, file.getAbsoluteFile().toPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}