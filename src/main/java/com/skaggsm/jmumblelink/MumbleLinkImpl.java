package com.skaggsm.jmumblelink;

import com.skaggsm.sharedmemory.SharedMemory;
import com.sun.jna.Native;

import java.io.IOException;

/**
 * Created by Mitchell Skaggs on 5/11/2019.
 */
public class MumbleLinkImpl implements MumbleLink {
    private SharedMemory pointer;
    private MumbleLinkMemory mumble;

    public MumbleLinkImpl() {
        pointer = SharedMemory.getSharedMemory("MumbleLink", MumbleLinkMemory.DEFAULT_SIZE);
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

    @Override
    public MumbleLinkMemory getMumbleLinkMemory() {
        return mumble;
    }

    @Override
    public int getUiVersion() {
        read();
        return mumble.uiVersion;
    }

    @Override
    public void setUiVersion(int uiVersion) {
        mumble.uiVersion = uiVersion;
        write();
    }

    @Override
    public int getUiTick() {
        read();
        return mumble.uiTick;
    }

    @Override
    public void setUiTick(int uiTick) {
        mumble.uiTick = uiTick;
        write();
    }

    @Override
    public void incrementUiTick() {
        //setUiTick(getUiTick() + 1);
        read();
        mumble.uiTick++;
        write();
    }

    @Override
    public float[] getAvatarPosition() {
        read();
        return mumble.fAvatarPosition;
    }

    @Override
    public void setAvatarPosition(float[] avatarPosition) {
        System.arraycopy(avatarPosition, 0, mumble.fAvatarPosition, 0, 3);
        write();
    }

    @Override
    public float[] getAvatarFront() {
        read();
        return mumble.fAvatarFront;
    }

    @Override
    public void setAvatarFront(float[] avatarFront) {
        System.arraycopy(avatarFront, 0, mumble.fAvatarFront, 0, 3);
        write();
    }

    @Override
    public float[] getAvatarTop() {
        read();
        return mumble.fAvatarTop;
    }

    @Override
    public void setAvatarTop(float[] avatarTop) {
        System.arraycopy(avatarTop, 0, mumble.fAvatarTop, 0, 3);
        write();
    }

    @Override
    public String getName() {
        read();
        return Native.toString(mumble.name);
    }

    @Override
    public void setName(String name) {
        // Must fit in 256 with null char at end
        assert name.length() <= 255;
        System.arraycopy(Native.toCharArray(name), 0, mumble.name, 0, name.length() + 1);
        write();
    }

    @Override
    public float[] getCameraPosition() {
        read();
        return mumble.fCameraPosition;
    }

    @Override
    public void setCameraPosition(float[] cameraPosition) {
        System.arraycopy(cameraPosition, 0, mumble.fCameraPosition, 0, 3);
        write();
    }

    @Override
    public float[] getCameraFront() {
        read();
        return mumble.fCameraFront;
    }

    @Override
    public void setCameraFront(float[] cameraFront) {
        System.arraycopy(cameraFront, 0, mumble.fCameraFront, 0, 3);
        write();
    }

    @Override
    public float[] getCameraTop() {
        read();
        return mumble.fCameraTop;
    }

    @Override
    public void setCameraTop(float[] cameraTop) {
        System.arraycopy(cameraTop, 0, mumble.fCameraTop, 0, 3);
        write();
    }

    @Override
    public String getIdentity() {
        read();
        return Native.toString(mumble.identity);
    }

    @Override
    public void setIdentity(String identity) {
        // Must fit in 256 with null char at end
        assert identity.length() <= 255;
        System.arraycopy(Native.toCharArray(identity), 0, mumble.identity, 0, identity.length() + 1);
        write();
    }

    @Override
    public String getContext() {
        read();
        return Native.toString(mumble.context);
    }

    @Override
    public void setContext(String context) {
        int length = context.length();

        // Must fit in 256 with null char at end
        assert length <= 255;

        System.arraycopy(Native.toByteArray(context), 0, mumble.context, 0, length + 1);
        mumble.context_len = length;

        write();
    }

    @Override
    public String getDescription() {
        read();
        return Native.toString(mumble.description);
    }

    @Override
    public void setDescription(String description) {
        // Must fit in 2048 with null char at end
        assert description.length() <= 2047;
        System.arraycopy(Native.toCharArray(description), 0, mumble.description, 0, description.length() + 1);
        write();
    }
}
