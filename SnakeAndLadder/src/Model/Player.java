package Model;

public class Player {
    int id;
    int currPos;

    public Player(int id, int currPos) {
        this.id = id;
        this.currPos = currPos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrPos() {
        return currPos;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
}
