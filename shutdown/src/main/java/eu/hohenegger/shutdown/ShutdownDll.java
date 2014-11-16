package eu.hohenegger.shutdown;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface ShutdownDll extends Library {
	public static final String NATIVE_LIB_NAME = "shutdown";
	ShutdownDll INSTANCE = (ShutdownDll) Native.loadLibrary(NATIVE_LIB_NAME, ShutdownDll.class);
	
	public boolean winShutdown();
	
	public boolean isWinShutdownAllowed();
}
