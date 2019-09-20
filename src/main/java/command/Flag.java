package command;

public abstract class Flag {
    private static boolean addIllegalTagFlag = false;
    private static boolean banChannelFlag = false;
    private static boolean removeTagFlag = false;
    private static boolean unbanChannelFlag = false;

    public static boolean isUnbanChannelFlag() {
        return unbanChannelFlag;
    }

    public static void setUnbanChannelFlag(boolean unbanChannelFlag) {
        Flag.unbanChannelFlag = unbanChannelFlag;
    }

    public static boolean isRemoveTagFlag() {
        return removeTagFlag;
    }

    public static void setRemoveTagFlag(boolean removeTagFlag) {
        Flag.removeTagFlag = removeTagFlag;
    }

    public static boolean isBanChannelFlag() {
        return banChannelFlag;
    }

    public static void setBanChannelFlag(boolean banChannelFlag) {
        Flag.banChannelFlag = banChannelFlag;
    }

    public static boolean isAddIllegalTagFlag() {
        return addIllegalTagFlag;
    }

    public static void setAddIllegalTagFlag(boolean addIllegalTagFlag) {
        Flag.addIllegalTagFlag = addIllegalTagFlag;
    }
}
