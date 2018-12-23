package pl.kamil;

import java.util.List;

public class ParsedXmlPojo {
    private String name;

    private List<School> education;

    public List<School> getEducation() {
        return education;
    }

    public String getName() {
        return name;
    }

    public void setEducation(List<School> education) {
        this.education = education;
    }

    public void setName(String name) {
        this.name = name;
    }
}
