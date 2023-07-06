package loga.dev4.jdbc.dto;

import lombok.Data;

@Data
public class LongestProject {

    private final String name;
    private final int monthCount;

    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" + "name='" + name + '\'' + ", monthCount=" + monthCount + '}';
    }

}
