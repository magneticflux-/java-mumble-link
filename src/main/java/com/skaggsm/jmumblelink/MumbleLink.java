package com.skaggsm.jmumblelink;

import com.skaggsm.sharedmemory.SharedMemory;
import com.sun.jna.Native;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Mitchell Skaggs on 5/11/2019.
 */
public class MumbleLink implements Closeable {
    private SharedMemory pointer;
    private MumbleLinkMemory mumble;

    public MumbleLink() {
        pointer = SharedMemory.getSharedMemory("MumbleLink");
        mumble = new MumbleLinkMemory(pointer.getMemory());
        mumble.clear();
    }

    private void read() {
        mumble.read();
    }

    private void write() {
        mumble.write();
    }

    @Override
    public void close() throws IOException {
        mumble = null;
        pointer.close();
        pointer = null;
    }

    public MumbleLinkMemory getMumbleLinkMemory() {
        return mumble;
    }

    public int getUiVersion() {
        read();
        return mumble.uiVersion;
    }

    public void setUiVersion(int uiVersion) {
        mumble.uiVersion = uiVersion;
        write();
    }

    public int getUiTick() {
        read();
        return mumble.uiTick;
    }

    public void setUiTick(int uiTick) {
        mumble.uiTick = uiTick;
        write();
    }

    public void incrementUiTick() {
        //setUiTick(getUiTick() + 1);
        read();
        mumble.uiTick++;
        write();
    }

    public String getName() {
        read();
        return Native.toString(mumble.name);
    }

    public void setName(String name) {
        System.arraycopy(Native.toCharArray(name), 0, mumble.name, 0, name.length() + 1);
        write();
    }
}
