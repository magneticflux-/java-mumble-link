package com.skaggsm.jmumblelink;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mitchell Skaggs on 5/11/2019.
 */
public class MumbleLinkMemory extends Structure {
    public int uiVersion = 0; // uint32_t
    public int uiTick = 0; // uint32_t

    public float[] fAvatarPosition = new float[3]; // float[3]
    public float[] fAvatarFront = new float[3]; // float[3]
    public float[] fAvatarTop = new float[3]; // float[3]

    public char[] name = new char[256]; // wchar_t[256]

    public float[] fCameraPosition = new float[3]; // float[3]
    public float[] fCameraFront = new float[3]; // float[3]
    public float[] fCameraTop = new float[3]; // float[3]

    public char[] identity = new char[256]; // wchar_t[256]

    public int context_len = 0; // uint32_t
    public byte[] context = new byte[256]; // unsigned char[256]

    public char[] description = new char[2048]; // wchar_t[2048]

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
