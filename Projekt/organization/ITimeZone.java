public interface ITimeZone {

    void setOffset(int offset);
    void setName(String name);
    void setCountryName(String countryName);
    void setContinentName(String continentName);

    int getOffset();
    String getName();
    String getCountryName();
    String getContinentName();
}
