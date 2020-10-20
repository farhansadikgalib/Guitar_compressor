package com.farhan.guitarcompressor;

import android.media.audiofx.DynamicsProcessing;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.P)
public final class Limiter extends DynamicsProcessing.Stage {
    private int mLinkGroup;
    private float mAttackTime;
    private float mReleaseTime;
    private float mRatio;
    private float mThreshold;
    private float mPostGain;

    /**
     * Class constructor for stage
     *
     * @param inUse   true if this stage is set to be used. False otherwise. Stages that are not
     *                set "inUse" at initialization time are not available to be used at any time.
     * @param enabled true if this stage is currently used to process sound. When disabled,
     */
    @RequiresApi(api = Build.VERSION_CODES.P)

    public Limiter(boolean inUse, boolean enabled, int linkGroup, float attackTime,
                   float releaseTime, float ratio, float threshold, float postGain) {
        super(inUse, enabled);
        mLinkGroup = linkGroup;
        mAttackTime = attackTime;
        mReleaseTime = releaseTime;
        mRatio = ratio;
        mThreshold = threshold;
        mPostGain = postGain;
    }


    public int getmLinkGroup() {
        return mLinkGroup;
    }

    public void setmLinkGroup(int mLinkGroup) {
        this.mLinkGroup = mLinkGroup;
    }

    public float getmAttackTime() {
        return mAttackTime;
    }

    public void setmAttackTime(float mAttackTime) {
        this.mAttackTime = mAttackTime;
    }

    public float getmReleaseTime() {
        return mReleaseTime;
    }

    public void setmReleaseTime(float mReleaseTime) {
        this.mReleaseTime = mReleaseTime;
    }

    public float getmRatio() {
        return mRatio;
    }

    public void setmRatio(float mRatio) {
        this.mRatio = mRatio;
    }

    public float getmThreshold() {
        return mThreshold;
    }

    public void setmThreshold(float mThreshold) {
        this.mThreshold = mThreshold;
    }

    public float getmPostGain() {
        return mPostGain;
    }

    public void setmPostGain(float mPostGain) {
        this.mPostGain = mPostGain;
    }
}
