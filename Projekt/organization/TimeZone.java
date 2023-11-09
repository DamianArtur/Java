public class TimeZone implements ITimeZone {

    int offset;
    String name;
    String countryName;
    String continentName;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCountryName() {
        return this.countryName;
    }

    @Override
    public String getContinentName() {
        return this.continentName;
    }

    @Override
    public int getOffset() {
        return this.offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeZone timeZone = (TimeZone) o;
        return name.equals(timeZone.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
