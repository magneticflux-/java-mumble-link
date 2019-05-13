package com.skaggsm.jmumblelink;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Mitchell Skaggs on 5/12/2019.
 */

interface MumbleLink extends Closeable {
    @Override
    void close() throws IOException;

    MumbleLinkMemory getMumbleLinkMemory();

    int getUiVersion();

    void setUiVersion(int uiVersion);

    int getUiTick();

    void setUiTick(int uiTick);

    void incrementUiTick();

    float[] getAvatarPosition();

    void setAvatarPosition(float[] avatarPosition);

    float[] getAvatarFront();

    void setAvatarFront(float[] avatarFront);

    float[] getAvatarTop();

    void setAvatarTop(float[] avatarTop);

    String getName();

    void setName(String name);

    float[] getCameraPosition();

    void setCameraPosition(float[] cameraPosition);

    float[] getCameraFront();

    void setCameraFront(float[] cameraFront);

    float[] getCameraTop();

    void setCameraTop(float[] cameraTop);

    String getIdentity();

    void setIdentity(String identity);

    String getContext();

    void setContext(String context);

    String getDescription();

    void setDescription(String description);
}
