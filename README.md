MinimalJNA
==========

Compile native lib for x86_64 windows, using MingW:

$ x86_64-w64-mingw32-g++ -static -m64 -shared shutdown.cpp -o shutdown.dll
