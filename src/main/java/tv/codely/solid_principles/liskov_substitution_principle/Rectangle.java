package tv.codely.solid_principles.liskov_substitution_principle;

class Rectangle {
    private Integer length;
    private Integer width;

    Rectangle(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    void setLength(Integer length) {
        this.length = length;
    }

    void setWidth(Integer width) {
        this.width = width;
    }

    Integer getArea() {
        return this.length * this.width;
    }
}
