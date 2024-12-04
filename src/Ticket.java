public class Ticket {
    private int num;
    private String pName;
    private String from;
    private String to;
    private char berthPref;

    public Ticket(int num, String pName, String from, String to, char berthPref) {
        this.num = num;
        this.pName = pName;
        this.from = from;
        this.to = to;
        this.berthPref = berthPref;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public char getBerthPref() {
        return berthPref;
    }

    public void setBerthPref(char berthPref) {
        this.berthPref = berthPref;
    }
}
