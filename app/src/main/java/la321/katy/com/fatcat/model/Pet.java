package la321.katy.com.fatcat.model;

public class Pet {
    private String id;
    private String name;
    private String owners;
    private String feedings;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getFeedings() {
        return feedings;
    }

    public void setFeedings(String feedings) {
        this.feedings = feedings;
    }
}
