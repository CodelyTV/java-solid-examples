package tv.codely.solid_principles.liskov_substitution_principle;

final class Square extends Rectangle {
    Square(Integer lengthAndWidth) {
        super(lengthAndWidth, lengthAndWidth);
    }

    @Override
    public void setLength(Integer length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(Integer width) {
        super.setWidth(width);
        super.setLength(width);
    }
}
