package loga.dev4.jdbc.dto;

import lombok.Data;

@Data
public class MaxProjectCountClient {

    private final String name;
    private final int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" + "name='" + name + '\'' + ", projectCount=" + projectCount + '}';
    }

}
