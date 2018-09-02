package editedTable;

public class Volume {
    private int volume;

    public Volume(int value) {
        setVolume(value);
    }

    public Volume() {
        this(50);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = (volume < 0 ? 0 : volume > 100 ? 100 : volume);
    }

    public void setVolume(Object v) {
        if (v instanceof String) {
            setVolume(Integer.parseInt((String)v));
        } else if (v instanceof Number) {
            setVolume(((Number)v).intValue());
        } else if (v instanceof Volume) {
            setVolume(((Volume)v).getVolume());
        }
    }

    @Override
    public String toString() {
        return String.valueOf(volume);
    }
}
