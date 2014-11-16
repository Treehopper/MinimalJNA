package eu.hohenegger.shutdown;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface MyShutdownDll extends Library {
	MyShutdownDll INSTANCE = (MyShutdownDll) Native.loadLibrary("shutdown", MyShutdownDll.class);
	
	public boolean winShutdown();
	
	public boolean isWinShutdownAllowed();
}
