package entity;

public class IllegalTag implements Entity {
    private int idIllegalTag;
    private String tag;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getIdIllegalTag() {
        return idIllegalTag;
    }

    public void setIdIllegalTag(int idIllegalTag) {
        this.idIllegalTag = idIllegalTag;
    }
}
