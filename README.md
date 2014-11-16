MinimalJNA ![Travis CI](https://travis-ci.org/Treehopper/MinimalJNA.png?branch=master "Build Status")
==========
Uses WinAPI to shut down windows.

Build
===================
Compile native lib for x86_64 windows, using MingW:

$ x86_64-w64-mingw32-g++ -static -m64 -shared shutdown.cpp -o shutdown.dll

License
===================
Eclipse Public License v1.0 which accompanies this distribution, and is available at  http://www.eclipse.org/legal/epl-v10.html
