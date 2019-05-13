package com.skaggsm.jmumblelink;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mitchell Skaggs on 5/11/2019.
 */
public class MumbleLinkMemory extends Structure {
    public int uiVersion = 0;
    public int uiTick = 0;

    public float[] fAvatarPosition = new float[3];
    public float[] fAvatarFront = new float[3];
    public float[] fAvatarTop = new float[3];

    public char[] name = new char[256];

    public float[] fCameraPosition = new float[3];
    public float[] fCameraFront = new float[3];
    public float[] fCameraTop = new float[3];

    public char[] identity = new char[256];

    public int context_len = 0; // UNSIGNED
    public short[] context = new short[256]; // UNSIGNED CHAR

    public char[] description = new char[2048];

    public MumbleLinkMemory(Pointer p) {
        super(p);
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "uiVersion",
                "uiTick",
                "fAvatarPosition",
                "fAvatarFront",
                "fAvatarTop",
                "name",
                "fCameraPosition",
                "fCameraFront",
                "fCameraTop",
                "identity",
                "context_len",
                "context",
                "description"
        );
    }
}
