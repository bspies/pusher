package org.pusher.util;

import com.google.common.collect.ComparisonChain;

/**
 * @author Brennan Spies
 */
public class Version implements Comparable<Version> {

    private int majorVersion, minorVersion, patchVersion;
    private String qualifier;

    public Version(int majorVersion, int minorVersion, int patchVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.patchVersion = patchVersion;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getPatchVersion() {
        return patchVersion;
    }

    /**
     * Compares this object with the specified object for order.
     * @see Comparable#compareTo(Object)
     */
    public int compareTo(Version version) {
        return ComparisonChain.start()
                .compare(majorVersion, version.majorVersion)
                .compare(minorVersion, version.minorVersion)
                .compare(patchVersion, version.patchVersion)
                .result();
    }

    /**
     * Returns a string representation of the version.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(majorVersion)
                .append('.')
                .append(minorVersion)
                .append('.')
                .append(patchVersion);
        if(qualifier!=null) {
            sb.append("_").append(qualifier);
        }
        return sb.toString();
    }
}
